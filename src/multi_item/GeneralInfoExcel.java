package multi_item;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logic.elaboration.GeneralInfoElabGS;
import logic.elaboration.GeneralInfoElaborate;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import configuration.AlertMsg;
import enitity.Asycuda;
import enitity.asycuda.AssessmentNotice;
import enitity.asycuda.Declarant;
import enitity.asycuda.ExportRelease;
import enitity.asycuda.Financial;
import enitity.asycuda.GeneralInformation;
import enitity.asycuda.GlobalTaxes;
import enitity.asycuda.Identification;
import enitity.asycuda.Property;
import enitity.asycuda.Traders;
import enitity.asycuda.Transit;
import enitity.asycuda.Transport;
import enitity.asycuda.Valuation;
import enitity.asycuda.Warehouse;
import enitity.asycuda.declarant_childs.Reference;
import enitity.asycuda.financial_childs.Amounts;
import enitity.asycuda.financial_childs.Bank;
import enitity.asycuda.financial_childs.FinancialTransaction;
import enitity.asycuda.financial_childs.Guarantee;
import enitity.asycuda.financial_childs.Terms;
import enitity.asycuda.financial_childs.guarantee_childs.ExcludedCountry;
import enitity.asycuda.generalInfo_childs.Country;
import enitity.asycuda.generalInfo_childs.generalInfo_childs.Destination;
import enitity.asycuda.generalInfo_childs.generalInfo_childs.Export;
import enitity.asycuda.identification_childs.Assessment;
import enitity.asycuda.identification_childs.OfficeSegment;
import enitity.asycuda.identification_childs.Receipt;
import enitity.asycuda.identification_childs.Registration;
import enitity.asycuda.identification_childs.Type;
import enitity.asycuda.property_childs.Forms;
import enitity.asycuda.property_childs.Nbers;
import enitity.asycuda.traders_childs.Consignee;
import enitity.asycuda.traders_childs.Exporter;
import enitity.asycuda.traders_childs.Financial2;
import enitity.asycuda.transit_childs.Destination2;
import enitity.asycuda.transit_childs.Principal;
import enitity.asycuda.transit_childs.Seals;
import enitity.asycuda.transit_childs.Signature;
import enitity.asycuda.transport_childs.BorderOffice;
import enitity.asycuda.transport_childs.DeliveryTerms;
import enitity.asycuda.transport_childs.MeansOfTransport;
import enitity.asycuda.transport_childs.PlaceOfLoading;
import enitity.asycuda.transport_childs.meansOfTransport_childs.BorderInformation;
import enitity.asycuda.transport_childs.meansOfTransport_childs.DepartureArrivalInformation;
import enitity.asycuda.valuation_childs.GsDeduction;
import enitity.asycuda.valuation_childs.GsExternalFreight;
import enitity.asycuda.valuation_childs.GsInsurance;
import enitity.asycuda.valuation_childs.GsInternalFreight;
import enitity.asycuda.valuation_childs.GsInvoice;
import enitity.asycuda.valuation_childs.GsOtherCost;
import enitity.asycuda.valuation_childs.Weight;
import javafx.scene.control.Alert.AlertType;


public class GeneralInfoExcel {

	/**
	 * FUSHA PA SPECIFIKIM TE QARTE NE XML DHE EXCEL
	 * PER VERIFIKIM
	private static int identity_MEANTRANSP_TRANSP = 25;
	private static int nationality_MEANTRANSP_TRANSP = 26;

	private static int contaiFlag_TRANSP = 27;

	private static int rateAdjst_VALITEM_TAX_ITEM = 35;

	private static int rateAdjust_VALITEM_ITEM = 42;

	private static int statisVal_VALITEM_ITEM = 43;
	 */

	AlertMsg alertMsg = new AlertMsg();
	public static int ROW = 3;
	public static Row rowDescrGenInfo = null;

	/**
	 * @param byteExcel
	 * @return Asycuda populated first sheet
	 */
	public Asycuda writeValueFromGeneralInfoExcel(byte[] byteExcel, String currencyExchangeRoot, HashMap<Integer, String> hmGenInfoColsNameAndPosit, HashMap<Integer, String> hmListItemsColsNameAndPosit) {

		GeneralInfoElabGS genInfoElabGS = new GeneralInfoElabGS();
		GeneralInfoElaborate genInfoElab = new GeneralInfoElaborate();
		String currencyExchange = currencyExchangeRoot;

		Sheet sheet = null;
		try {
			Workbook wb = WorkbookFactory.create(new ByteArrayInputStream(byteExcel));
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Nuk mund te konvertohet workbook ne object \n" + null, ExceptionUtils.getStackTrace(e));
		}
		
		rowDescrGenInfo = sheet.getRow((ROW-1));
		Row row = sheet.getRow(ROW);

		Asycuda ASYCUDA = new Asycuda();

		ExportRelease expRelease = new ExportRelease();
		ASYCUDA.setExport_release(expRelease);

		AssessmentNotice assesNotice = new AssessmentNotice();
		List<String> listItemTaxTotal = new ArrayList<String>();
		for (int i = 0; i < 14; i++) {
			listItemTaxTotal.add(null);
		}
		assesNotice.setItem_tax_total(listItemTaxTotal);
		ASYCUDA.setAssessment_notice(assesNotice);

		GlobalTaxes globTaxes = new GlobalTaxes();
		List<String> listGlobTaxItem = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			listGlobTaxItem.add(null);
		}
		globTaxes.setGlobal_tax_item(listGlobTaxItem);
		ASYCUDA.setGlobal_taxes(globTaxes);

		Property property = new Property();

		// e futur vete
		property.setSad_flow("I");

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 6, 7
		 * - numbForm_FORMS_PROPERT (mandatory)
		 * - totNumbForm_FORMS_PROPERT (mandatory)
		 * */
		Forms formsProp = genInfoElab.getFormsPropertyChilds(row, hmGenInfoColsNameAndPosit);
		property.setForms(formsProp);


		property.setPlace_of_declaration("null");

		// e futur vete
		property.setSelected_page("1");

		ASYCUDA.setProperty(property);

		Identification ident = new Identification();

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 3, 4
		 * - costumTransDoc_OFFICESEGM_IDENT (mandatory)
		 * - costumClearaOffName_OFFICESEGM_IDENT (mandatory)
		 * */
		OfficeSegment offSegm = genInfoElab.getOfficeSegmentIdentificationChilds(row, hmGenInfoColsNameAndPosit);

		ident.setOffice_segment(offSegm);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 0, 1, 2
		 * - typeDeclaration_TYPE_IDENT (mandatory)
		 * - declarGenProcCode_TYPE_IDENT (mandatory)
		 * - typeTransDoc_TYPE_IDENT
		 * */
		Type type = genInfoElab.getTypeIdentificationChilds(row, hmGenInfoColsNameAndPosit);

		ident.setType(type);

		ident.setManifest_reference_number("null");

		Registration reg = new Registration();
		reg.setSerial_number("null");

		ident.setRegistration(reg);

		Assessment assesm = new Assessment();
		assesm.setSerial_number("null");

		ident.setAssessment(assesm);

		Receipt rec = new Receipt();
		rec.setSerial_number("null");

		ident.setReceipt(rec);

		ASYCUDA.setIdentification(ident);

		Traders trad = new Traders();

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 5
		 * - expoName_EXPO_TRADERS (mandatory)
		 * */
		Exporter expo = genInfoElab.getExporterTradersChilds(row, hmGenInfoColsNameAndPosit);
		trad.setExporter(expo);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 12, 13, 53
		 * - consignName_CONSI_TRADERS (mandatory)
		 * - consignCode_CONSI_TRADERS (mandatory)
		 * */
		Consignee cons = genInfoElab.getConsigneeTradersChilds(row, hmGenInfoColsNameAndPosit);

		trad.setConsignee(cons);

		Financial2 financial2 = new Financial2();
		trad.setFinancial(financial2);

		ASYCUDA.setTraders(trad);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 19, 20
		 * - declarName_DECLAR (mandatory)
		 * - declarCode_DECLAR (mandatory)
		 * - declarReprestative_DECLAR (mandatory)
		 * */
		Declarant decl = genInfoElab.getDeclarant(row, hmGenInfoColsNameAndPosit);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 11
		 * - number_REFER_DECLAR (mandatory)
		 * */
		Reference ref = genInfoElab.getReferenceDeclarantChilds(row, hmGenInfoColsNameAndPosit);
		decl.setReference(ref);

		ASYCUDA.setDeclarant(decl);

		GeneralInformation genInfo = new GeneralInformation();

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 12, 13
		 * - countrFirstDest_COUNTR_GENERINFO (mandatory)
		 * - tradingCountr_COUNTR_GENERINFO (mandatory)
		 * */
		Country count = genInfoElab.getCountryGeneralInfoChilds(row, hmGenInfoColsNameAndPosit);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 21, 22
		 * - expoCountrName_EXPO_COUNTR_GENERINFO (mandatory)
		 * - expoCountrCode_EXPO_COUNTR_GENERINFO (mandatory)
		 * */
		Export export = genInfoElab.getExportGeneralInnfo(row, hmGenInfoColsNameAndPosit);

		count.setExport(export);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 24
		 * - codeCountrName_DEST_COUNTR_GENERINFO (mandatory)
		 * */
		Destination dest = genInfoElab.getValueCountrDestCountrNameGeneralInfo(row, hmGenInfoColsNameAndPosit);

		count.setDestination(dest);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 23
		 * - countrOrigName_COUNTR_GENERINFO (mandatory)
		 * */
		count.setCountry_of_origin_name(genInfoElab.getValueCountrOrigNameGeneralInfo(row, hmGenInfoColsNameAndPosit));

		genInfo.setCountry(count);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 17
		 * - valueDetails_GENERINFO (mandatory)
		 * 
		 * E PLOTESON VETE SISTEMI
		 * */
	//	genInfo.setValue_details(genInfoElab.getValueDetailGeneralInfo(row, hmGenInfoColsNameAndPosit));

		genInfo.setAdditional_information("null");
		genInfo.setComments_free_text("null");

		ASYCUDA.setGeneral_information(genInfo);

		Transport trans = new Transport();

		MeansOfTransport meTran = new MeansOfTransport();

		DepartureArrivalInformation dai = genInfoElab.getValueDepartureArrivalInformation(row, hmGenInfoColsNameAndPosit);

		meTran.setDeparture_arrival_information(dai);

		/**
		 * NOTE FIRST AND SECOND COLUMNS ARE SAME WITH: DeliveryTerms delTerm
		 * SHEET: GENERAL INFO
		 * COLUMNS: 28, 29
		 * - code_DELIVTERMS_TRANSP (mandatory)
		 * - place_DELIVTERMS_TRANSP (mandatory)
		 * */
		BorderInformation bi = genInfoElab.getValueBorderInformation(row, hmGenInfoColsNameAndPosit);

		meTran.setBorder_information(bi);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 38
		 * - inlandModeTransp_MEANTRANSP_TRANSP (mandatory)
		 * */
		meTran.setInland_mode_of_transport(genInfoElab.getValueInlandModeTransp(row, hmGenInfoColsNameAndPosit));

		trans.setMeans_of_transport(meTran);

		// Vete, eshte checkbox ne app
		trans.setContainer_flag("false");

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 28, 29
		 * - code_DELIVTERMS_TRANSP (mandatory)
		 * - place_DELIVTERMS_TRANSP (mandatory)
		 * */
		DeliveryTerms delTerm = genInfoElab.getValueDeliveryTermsTransportChilds(row, hmGenInfoColsNameAndPosit);

		trans.setDelivery_terms(delTerm);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 37
		 * - code_BORDEROFFIC_TRANSP (mandatory)
		 * */
		BorderOffice bordOff = genInfoElab.getValueBorderOfficeTransChilds(row, hmGenInfoColsNameAndPosit);

		trans.setBorder_office(bordOff);

		PlaceOfLoading placLoad = new PlaceOfLoading();
		placLoad.setCode("null");
		placLoad.setName("null");
		trans.setPlace_of_loading(placLoad);

		trans.setLocation_of_goods("null");

		ASYCUDA.setTransport(trans);

		Financial fin = new Financial();

		FinancialTransaction finTra = new FinancialTransaction();
		// vete te dyja
		finTra.setCode1("1");
		finTra.setCode2("1");

		fin.setFinancial_transaction(finTra);

		Bank bank = new Bank();

		bank.setCode("null");
		bank.setName("null");

		fin.setBank(bank);

		Terms terms = new Terms();
		terms.setCode("null");
		terms.setDescription("null");

		fin.setTerms(terms);

		// i njete me Consignee_code
		if(ASYCUDA.getTraders() != null
				&& ASYCUDA.getTraders().getConsignee() != null
				&& ASYCUDA.getTraders().getConsignee().getConsignee_code() != null)
			fin.setDeffered_payment_reference(ASYCUDA.getTraders().getConsignee().getConsignee_code());

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 48
		 * - modePaym_FINANC (mandatory)
		 * */
		fin.setMode_of_payment(genInfoElab.getValueModePaymFINANC(row, hmGenInfoColsNameAndPosit));

		// ALARM NUK DIHET SI LLOGARITET TAKSA GLOBARE DHE TAKSA TOTALE
		// VLERA ESHTE FUTUR VETE
		Amounts am = new Amounts();
		am.setGlobal_taxes("2996.0");
		am.setTotals_taxes("180464.0");
		fin.setAmounts(am);

		Guarantee guar = new Guarantee();
		guar.setName("null");

		ExcludedCountry exCou = new ExcludedCountry();
		exCou.setCode("null");
		exCou.setName("null");
		guar.setExcluded_country(exCou);

		fin.setGuarantee(guar);

		ASYCUDA.setFinancial(fin);

		Warehouse wh = new Warehouse();
		ASYCUDA.setWarehouse(wh);

		Transit transi = new Transit();

		Principal princ = new Principal();
		princ.setCode("null");
		princ.setName("null");
		princ.setRepresentative("null");

		transi.setPrincipal(princ);

		Signature sign = new Signature();
		sign.setPlace("null");

		transi.setSignature(sign);

		Destination2 des = new Destination2();
		des.setOffice("null");
		des.setCountry("null");
		transi.setDestination(des);

		Seals seal = new Seals();
		seal.setIdentity("null");
		transi.setSeals(seal);

		transi.setOfficer_name("null");

		ASYCUDA.setTransit(transi);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 36
		 * - calcWorkMode_VAL (mandatory)
		 * */
		Valuation val = genInfoElab.getValueValuation(row, hmGenInfoColsNameAndPosit);

		Weight weight = new Weight();
		val.setWeight(weight);

		
		
		/*|------------------------------------------| 
		  |------------------------------------------|
		 
		     ASYCUDA: THE SECOND SHEET -> LIST ITEMS
		  
		  |------------------------------------------|
		  |------------------------------------------|*/
		ListItemsExcel listItemsExcel = new ListItemsExcel();
		
		ASYCUDA = listItemsExcel.writeValueListItems(byteExcel, ASYCUDA, currencyExchange, hmListItemsColsNameAndPosit);
		
		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 28, 29
		 * - currCode_GSINVOICE_VALU (mandatory)
		 * - amountForegCurr_GSINVOICE_VALU (mandatory)
		 * - setCurrency_name 
		 * - setAmount_national_currency 
		 * - setCurrency_rate 
		 * */
		GsInvoice gsInv = genInfoElabGS.getValueGsInvoiceValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_Invoice(gsInv);

		GsExternalFreight gsExtFrei = genInfoElabGS.getValueGsExternalFreiValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_external_freight(gsExtFrei);
		
		GsInternalFreight gsIntFrei = genInfoElabGS.getValueGsInternalFreightValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_internal_freight(gsIntFrei);

		GsInsurance gsIns = genInfoElabGS.getValueGsInsuranceValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_insurance(gsIns);

		GsOtherCost gsOtherCost = genInfoElabGS.getValueGsOtherCosteValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_other_cost(gsOtherCost);

		GsDeduction gsDed = genInfoElabGS.getValueGsDeductionValuationChilds(row, ASYCUDA, currencyExchange, hmGenInfoColsNameAndPosit);
		val.setGs_deduction(gsDed);

		ASYCUDA.setValuation(val);

		/**
		 * SHEET: GENERAL INFO
		 * COLUMNS: 8, 9, 10
		 * - totNumbItems_NBERS_PROPERT (mandatory)
		 * - totNumbPackages_NBERS_PROPERT (mandatory)
		 * */
		Nbers nbers = genInfoElab.getNbersPropertyChilds(row, ASYCUDA, hmGenInfoColsNameAndPosit);

		ASYCUDA.getProperty().setNbers(nbers);

		ASYCUDA = genInfoElab.updateTotCostTotCIFTotInvoiceTotWeight(ASYCUDA);
		
		return ASYCUDA;
	}



}
