package logic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import enitity.Asycuda;
import enitity.asycuda.AssessmentNotice;
import enitity.asycuda.Declarant;
import enitity.asycuda.ExportRelease;
import enitity.asycuda.Financial;
import enitity.asycuda.GeneralInformation;
import enitity.asycuda.GlobalTaxes;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Identification;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.Property;
import enitity.asycuda.Taxation;
import enitity.asycuda.Traders;
import enitity.asycuda.Transit;
import enitity.asycuda.Transport;
import enitity.asycuda.Valuation;
import enitity.asycuda.ValuationItem;
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
import enitity.asycuda.item_childs.IncoTerms;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.item_childs.tarification_childs.Quota;
import enitity.asycuda.item_childs.tarification_childs.SupplementaryUnit;
import enitity.asycuda.item_childs.tarification_childs.quota_childs.QuotaItem;
import enitity.asycuda.property_childs.Forms;
import enitity.asycuda.property_childs.Nbers;
import enitity.asycuda.taxation_childs.TaxationLine;
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
import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
import enitity.asycuda.valuationItem_childs.MarketValuer;
import enitity.asycuda.valuationItem_childs.WeightItm;
import enitity.asycuda.valuation_childs.GsDeduction;
import enitity.asycuda.valuation_childs.GsExternalFreight;
import enitity.asycuda.valuation_childs.GsInsurance;
import enitity.asycuda.valuation_childs.GsInvoice;
import enitity.asycuda.valuation_childs.GsOtherCost;
import enitity.asycuda.valuation_childs.Total;
import enitity.asycuda.valuation_childs.Weight;


public class GetDataFromExcelMultiLines {

	private static int typeDeclaration_TYPE_IDENT = 0;
	private static int declarGenProcCode_TYPE_IDENT = 1;
	private static int typeTransDoc_TYPE_IDENT = 2;
	
	private static int costumTransDoc_OFFICESEGM_IDENT = 3;
	private static int costumClearaOffName_OFFICESEGM_IDENT = 4;
	
	private static int expoName_EXPO_TRADERS = 5;
	
	private static int numbForm_FORMS_PROPERT = 6;
	private static int totNumbForm_FORMS_PROPERT = 7;
	
	private static int numbLoadLists_NBERS_PROPERT = 8;
	private static int totNumbItems_NBERS_PROPERT = 9;
	private static int totNumbPackages_NBERS_PROPERT = 10;
	
	private static int number_REFER_DECLAR = 11;
	
	private static int consignName_CONSI_TRADERS = 12;
	private static int consignCode_CONSI_TRADERS = 13;
	
	private static int countrFirstDest_COUNTR_GENERINFO = 15;
	private static int tradingCountr_COUNTR_GENERINFO = 16;
	
	private static int valueDetails_GENERINFO = 17;
	
	private static int declarName_DECLAR = 19;
	private static int declarCode_DECLAR = 20;
	
	private static int expoCountrName_EXPO_COUNTR_GENERINFO = 21;
	private static int expoCountrCode_EXPO_COUNTR_GENERINFO = 22;
	
	private static int countrOrigName_COUNTR_GENERINFO = 23;
	
	private static int codeCountrName_DEST_COUNTR_GENERINFO = 24;
	
	private static int identity_MEANTRANSP_TRANSP = 25;
	private static int nationality_MEANTRANSP_TRANSP = 26;
	
	private static int contaiFlag_TRANSP = 27;
	
	private static int code_DELIVTERMS_TRANSP = 28;
	private static int place_DELIVTERMS_TRANSP = 29;
	
	private static int identity_BORDERINFO_MEANTRANSP_TRANSP = 30;
	private static int nationality_BORDERINFO_MEANTRANSP_TRANSP = 31;
	
	private static int currCode_GSINVOICE_VALU = 32;
	private static int amountForegCurr_GSINVOICE_VALU = 33;
	private static int currRate_GSINVOICE_VALU = 34;
	
	private static int rateAdjst_VALITEM_TAX_ITEM = 35;
	
	private static int calcWorkMode_VAL = 36;
	
	private static int mode_BORDERINFO_MEANTRANSP_TRANSP = 37;
	
	private static int inlandModeTransp_MEANTRANSP_TRANSP = 38;
	
	private static int code_BORDEROFFIC_TRANSP = 41;
	
	private static int rateAdjust_VALITEM_ITEM = 64;
	
	private static int statisVal_VALITEM_ITEM = 65;
	
	private static int modePaym_FINANC = 69;
	
	private static int declarReprestative_DECLAR = 74;

	private static int ROW = 3;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] byteExcel = getByteFromFile("C:\\TemplateAsycudaTemp.xlsx");
		
		readValueFormExcel(byteExcel);
	}

	public static byte[] getByteFromFile(String pathExcel) throws IOException {
		
		Path path = Paths.get(pathExcel);
		byte[] data = Files.readAllBytes(path);
		
		return data;
	}
	
	public static Asycuda readValueFormExcel(byte[] byteExcel) throws IOException {
		
		GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
		String currencyExchange = currency.getCurrencyExchange();
		
		Sheet sheet = null;
		try {
			Workbook wb = WorkbookFactory.create(new ByteArrayInputStream(byteExcel));
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Row row = sheet.getRow(ROW);
		
		String typeDeclaration_TYPE_IDENT_String = ExcelPoi.getString(row, typeDeclaration_TYPE_IDENT);
		String declarGenProcCode_TYPE_IDENT_String = ExcelPoi.getString(row, declarGenProcCode_TYPE_IDENT);
		String typeTransDoc_TYPE_IDENT_String = ExcelPoi.getString(row, typeTransDoc_TYPE_IDENT);

		String costumTransDoc_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumTransDoc_OFFICESEGM_IDENT);
		String costumClearaOffName_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumClearaOffName_OFFICESEGM_IDENT);

		String expoName_EXPO_TRADERS_String = ExcelPoi.getString(row, expoName_EXPO_TRADERS);

		String numbForm_FORMS_PROPERT_String = ExcelPoi.getString(row, numbForm_FORMS_PROPERT);
		String totNumbForm_FORMS_PROPERT_String = ExcelPoi.getString(row, totNumbForm_FORMS_PROPERT);

		String numbLoadLists_NBERS_PROPERT_String = ExcelPoi.getString(row, numbLoadLists_NBERS_PROPERT);
		String totNumbItems_NBERS_PROPERT_String = ExcelPoi.getString(row, totNumbItems_NBERS_PROPERT);
		String totNumbPackages_NBERS_PROPERT_String = ExcelPoi.getString(row, totNumbPackages_NBERS_PROPERT);

		String number_REFER_DECLAR_String = ExcelPoi.getString(row, number_REFER_DECLAR);

		String consignName_CONSI_TRADERS_String = ExcelPoi.getString(row, consignName_CONSI_TRADERS);
		String consignCode_CONSI_TRADERS_String = ExcelPoi.getString(row, consignCode_CONSI_TRADERS);

		String countrFirstDest_COUNTR_GENERINFO_String = ExcelPoi.getString(row, countrFirstDest_COUNTR_GENERINFO);
		String tradingCountr_COUNTR_GENERINFO_String = ExcelPoi.getString(row, tradingCountr_COUNTR_GENERINFO);

		String valueDetails_GENERINFO_String = ExcelPoi.getString(row, valueDetails_GENERINFO);

		String declarName_DECLAR_String = ExcelPoi.getString(row, declarName_DECLAR);
		String declarCode_DECLAR_String = ExcelPoi.getString(row, declarCode_DECLAR);

		String expoCountrName_EXPO_COUNTR_GENERINFO_String = ExcelPoi.getString(row, expoCountrName_EXPO_COUNTR_GENERINFO);
		String expoCountrCode_EXPO_COUNTR_GENERINFO_String = ExcelPoi.getString(row, expoCountrCode_EXPO_COUNTR_GENERINFO);

		String countrOrigName_COUNTR_GENERINFO_String = ExcelPoi.getString(row, countrOrigName_COUNTR_GENERINFO);

		String codeCountrName_DEST_COUNTR_GENERINFO_String = ExcelPoi.getString(row, codeCountrName_DEST_COUNTR_GENERINFO);

		String identity_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, identity_MEANTRANSP_TRANSP);
		String nationality_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, nationality_MEANTRANSP_TRANSP);

		String contaiFlag_TRANSP_String = ExcelPoi.getString(row, contaiFlag_TRANSP);

		String code_DELIVTERMS_TRANSP_String = ExcelPoi.getString(row, code_DELIVTERMS_TRANSP);
		String place_DELIVTERMS_TRANSP_String = ExcelPoi.getString(row, place_DELIVTERMS_TRANSP);

		String identity_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, identity_BORDERINFO_MEANTRANSP_TRANSP);
		String nationality_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, nationality_BORDERINFO_MEANTRANSP_TRANSP);

		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);
		String amountForegCurr_GSINVOICE_VALU_String = ExcelPoi.getString(row, amountForegCurr_GSINVOICE_VALU);
		String currRate_GSINVOICE_VALU_String = ExcelPoi.getString(row, currRate_GSINVOICE_VALU);

		String rateAdjst_VALITEM_TAX_ITEM_String = ExcelPoi.getString(row, rateAdjst_VALITEM_TAX_ITEM);

		String calcWorkMode_VAL_String = ExcelPoi.getString(row, calcWorkMode_VAL);

		String mode_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, mode_BORDERINFO_MEANTRANSP_TRANSP);

		String inlandModeTransp_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, inlandModeTransp_MEANTRANSP_TRANSP);

		String code_BORDEROFFIC_TRANSP_String = ExcelPoi.getString(row, code_BORDEROFFIC_TRANSP);

		

		String rateAdjust_VALITEM_ITEM_String = ExcelPoi.getString(row, rateAdjust_VALITEM_ITEM);

		String statisVal_VALITEM_ITEM_String = ExcelPoi.getString(row, statisVal_VALITEM_ITEM);

		String modePaym_FINANC_String = ExcelPoi.getString(row, modePaym_FINANC);

		String declarReprestative_DECLAR_String = ExcelPoi.getString(row, declarReprestative_DECLAR);
		
		
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
		
		Forms formsProp = new Forms();
		formsProp.setNumber_of_the_form(numbForm_FORMS_PROPERT_String);
		formsProp.setTotal_number_of_forms(totNumbForm_FORMS_PROPERT_String);
		property.setForms(formsProp);
		
		Nbers nbers = new Nbers();

		nbers.setNumber_of_loading_lists(numbLoadLists_NBERS_PROPERT_String);
		nbers.setTotal_number_of_items(new Integer(totNumbItems_NBERS_PROPERT_String));
		nbers.setTotal_number_of_packages(new BigDecimal(totNumbPackages_NBERS_PROPERT_String));
		
		property.setNbers(nbers);
		
		property.setPlace_of_declaration("null");
		
		// e futur vete
		property.setSelected_page("1");
		
		ASYCUDA.setProperty(property);
		
		Identification ident = new Identification();
		
		OfficeSegment offSegm = new OfficeSegment();
		offSegm.setCustoms_clearance_office_code(costumTransDoc_OFFICESEGM_IDENT_String);
		offSegm.setCustoms_Clearance_office_name(costumClearaOffName_OFFICESEGM_IDENT_String);
		
		ident.setOffice_segment(offSegm);
		
		Type type = new Type();
		type.setType_of_declaration(typeDeclaration_TYPE_IDENT_String);
		type.setDeclaration_gen_procedure_code(declarGenProcCode_TYPE_IDENT_String);
		type.setType_of_transit_document(typeTransDoc_TYPE_IDENT_String);
		
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
		
		Exporter expo = new Exporter();
		expo.setExporter_name(expoName_EXPO_TRADERS_String);
		trad.setExporter(expo);
		
		Consignee cons = new Consignee();
		cons.setConsignee_code(consignCode_CONSI_TRADERS_String);
		cons.setConsignee_name(consignName_CONSI_TRADERS_String);
		
		trad.setConsignee(cons);
		
		Financial2 financial2 = new Financial2();
		trad.setFinancial(financial2);
		
		ASYCUDA.setTraders(trad);
		
		Declarant decl = new Declarant();
		decl.setDeclarant_code(declarCode_DECLAR_String);
		decl.setDeclarant_name(declarName_DECLAR_String);
		decl.setDeclarant_representative(declarReprestative_DECLAR_String);
		
		Reference ref = new Reference();
		ref.setNumber(number_REFER_DECLAR_String);
		decl.setReference(ref);
		
		ASYCUDA.setDeclarant(decl);
		
		GeneralInformation genInfo = new GeneralInformation();
		
		Country count = new Country();
		count.setCountry_first_destination(countrFirstDest_COUNTR_GENERINFO_String);
		count.setTrading_country(tradingCountr_COUNTR_GENERINFO_String);
		
		Export export = new Export();
		export.setExport_country_code(expoCountrCode_EXPO_COUNTR_GENERINFO_String);
		export.setExport_country_name(expoCountrName_EXPO_COUNTR_GENERINFO_String);
		count.setExport(export);
		
		Destination dest = new Destination();
		// vete
		dest.setDestination_country_code("AL");
		dest.setDestination_country_name(codeCountrName_DEST_COUNTR_GENERINFO_String);
		count.setDestination(dest);
		
		count.setCountry_of_origin_name(countrOrigName_COUNTR_GENERINFO_String);
		
		genInfo.setCountry(count);
		
		genInfo.setValue_details(valueDetails_GENERINFO_String);
		
		genInfo.setAdditional_information("null");
		genInfo.setComments_free_text("null");
		
		ASYCUDA.setGeneral_information(genInfo);
		
		Transport trans = new Transport();
		
		MeansOfTransport meTran = new MeansOfTransport();
		
		DepartureArrivalInformation dai = new DepartureArrivalInformation();
		dai.setIdentity(identity_BORDERINFO_MEANTRANSP_TRANSP_String);
		dai.setNationality(nationality_BORDERINFO_MEANTRANSP_TRANSP_String);
		meTran.setDeparture_arrival_information(dai);
		
		BorderInformation bi = new BorderInformation();
		bi.setIdentity(identity_BORDERINFO_MEANTRANSP_TRANSP_String);
		bi.setNationality(nationality_BORDERINFO_MEANTRANSP_TRANSP_String);
		bi.setMode(mode_BORDERINFO_MEANTRANSP_TRANSP_String);
		meTran.setBorder_information(bi);
		
		meTran.setInland_mode_of_transport(inlandModeTransp_MEANTRANSP_TRANSP_String);
		
		trans.setMeans_of_transport(meTran);
		
		// Vete, eshte checkbox ne app
		trans.setContainer_flag("false");
		
		DeliveryTerms delTerm = new DeliveryTerms();
		delTerm.setCode(code_DELIVTERMS_TRANSP_String);
		delTerm.setPlace(place_DELIVTERMS_TRANSP_String);
		trans.setDelivery_terms(delTerm);
		
		BorderOffice bordOff = new BorderOffice();
		bordOff.setCode(code_BORDEROFFIC_TRANSP_String);
		// vete
		bordOff.setName("Durresi");
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
		finTra.setCode2("2");
		
		fin.setFinancial_transaction(finTra);
		
		Bank bank = new Bank();
		
		bank.setCode("null");
		bank.setName("null");
		
		fin.setBank(bank);
		
		Terms terms = new Terms();
		terms.setCode("null");
		terms.setDescription("null");
		
		fin.setTerms(terms);
		
		fin.setDeffered_payment_reference("null");
		fin.setMode_of_payment(modePaym_FINANC_String);
		
		Amounts am = new Amounts();
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
		
		Valuation val = new Valuation();
		val.setCalculation_working_mode(calcWorkMode_VAL_String);
		
		Weight weight = new Weight();
		val.setWeight(weight);
		
		// vete
		val.setTotal_cost(new BigDecimal("0.0"));
		val.setTotal_CIF(new BigDecimal("819240.0"));
		
		GsInvoice gsInv = new GsInvoice();
		gsInv.setAmount_foreign_currency(amountForegCurr_GSINVOICE_VALU_String);
		gsInv.setCurrency_code(currCode_GSINVOICE_VALU_String);
		
		// kot
		gsInv.setCurrency_name("Ska monedhe te huaj");
		
		gsInv.setAmount_national_currency( calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String) );
		gsInv.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
		
		val.setGs_Invoice(gsInv);
		
		GsExternalFreight gsExtFrei = new GsExternalFreight();
		gsExtFrei.setAmount_national_currency(BigDecimal.ZERO);
		gsExtFrei.setAmount_foreign_currency("0");
		gsExtFrei.setCurrency_name("Ska monedhe te huaj");
		gsExtFrei.setCurrency_rate("0.0");
		val.setGs_external_freight(gsExtFrei);
		
		GsInsurance gsIns = new GsInsurance();
		gsIns.setAmount_national_currency(BigDecimal.ZERO);
		gsIns.setAmount_foreign_currency("0");
		gsIns.setCurrency_name("Ska monedhe te huaj");
		gsIns.setCurrency_rate("0.0");
		val.setGs_insurance(gsIns);
		
		GsOtherCost gsOtherCost = new GsOtherCost();
		gsOtherCost.setAmount_national_currency(BigDecimal.ZERO);
		gsOtherCost.setAmount_foreign_currency("0");
		gsOtherCost.setCurrency_name("Ska monedhe te huaj");
		gsOtherCost.setCurrency_rate("0.0");
		val.setGs_other_cost(gsOtherCost);
		
		GsDeduction gsDed = new GsDeduction();
		gsDed.setAmount_national_currency(BigDecimal.ZERO);
		gsDed.setAmount_foreign_currency("0");
		gsDed.setCurrency_name("Ska monedhe te huaj");
		gsDed.setCurrency_rate("0.0");
		val.setGs_deduction(gsDed);
		
		Total tot = new Total();
		// vete
		tot.setTotal_invoice(new BigDecimal("6000.0"));
		tot.setTotal_weight(new BigDecimal("300.0"));
		
		val.setTotal(tot);
		
		ASYCUDA.setValuation(val);
		
		
		
		return ASYCUDA;
	}
	
	public static BigDecimal calcAmountNationalCurr(String amountForegCurr, String currCode) throws IOException {

		String currString = "";
		BigDecimal amountNationalCurr = null;
		
		if(currCode.equalsIgnoreCase("EUR")) {

			GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
			String currencyExchange = currency.getCurrencyExchange();
			
			currString = currency.getCurrency(currCode, currencyExchange);
		}
		
		if(!currString.equals("")) {
			BigDecimal amountForegCurrDec = new BigDecimal(amountForegCurr);
			BigDecimal currStringDec = new BigDecimal(currString);
			
			amountNationalCurr = amountForegCurrDec.multiply(currStringDec);
			
			// One decimal place
			amountNationalCurr = amountNationalCurr.setScale(1, RoundingMode.CEILING);
		} else {
			return BigDecimal.ZERO;
		}

		return amountNationalCurr;
	}
	
}
