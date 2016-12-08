package logic.elaboration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;

import configuration.ConfigFileExcel;
import enitity.Asycuda;
import enitity.asycuda.Declarant;
import enitity.asycuda.Item;
import enitity.asycuda.Valuation;
import enitity.asycuda.declarant_childs.Reference;
import enitity.asycuda.generalInfo_childs.Country;
import enitity.asycuda.generalInfo_childs.generalInfo_childs.Destination;
import enitity.asycuda.generalInfo_childs.generalInfo_childs.Export;
import enitity.asycuda.identification_childs.OfficeSegment;
import enitity.asycuda.identification_childs.Type;
import enitity.asycuda.property_childs.Forms;
import enitity.asycuda.property_childs.Nbers;
import enitity.asycuda.traders_childs.Consignee;
import enitity.asycuda.traders_childs.Exporter;
import enitity.asycuda.transport_childs.BorderOffice;
import enitity.asycuda.transport_childs.DeliveryTerms;
import enitity.asycuda.transport_childs.meansOfTransport_childs.BorderInformation;
import enitity.asycuda.transport_childs.meansOfTransport_childs.DepartureArrivalInformation;
import enitity.asycuda.valuation_childs.GsInvoice;
import enitity.asycuda.valuation_childs.Total;
import logic.ExcelPoi;
import logic.GetCurrencyAndAmount;

public class GeneralInfoElaborate {

	GeneralInfoValidation genInfoValid = new GeneralInfoValidation();
	ConfigFileExcel confFileExcel = new ConfigFileExcel();
	GetCurrencyAndAmount currency = new GetCurrencyAndAmount();

	/**
	 * @param row
	 * @return Type IdentificationChilds
	 */
	public Type getTypeIdentificationChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int typeDeclaration_TYPE_IDENT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "typeDeclaration_TYPE_IDENT");
		int declarGenProcCode_TYPE_IDENT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarGenProcCode_TYPE_IDENT");
		int typeTransDoc_TYPE_IDENT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "typeTransDoc_TYPE_IDENT");

		String typeDeclaration_TYPE_IDENT_String = ExcelPoi.getString(row, typeDeclaration_TYPE_IDENT);
		String declarGenProcCode_TYPE_IDENT_String = ExcelPoi.getString(row, declarGenProcCode_TYPE_IDENT);
		String typeTransDoc_TYPE_IDENT_String = ExcelPoi.getString(row, typeTransDoc_TYPE_IDENT);

		Type type = new Type();
		type.setType_of_declaration(typeDeclaration_TYPE_IDENT_String);
		type.setDeclaration_gen_procedure_code(declarGenProcCode_TYPE_IDENT_String);
		type.setType_of_transit_document(typeTransDoc_TYPE_IDENT_String);

		genInfoValid.validationCellsTypeIdentificationChilds(type, hmGenInfoColsNameAndPosit);

		return type;
	}

	/**
	 * @param row
	 * @return OfficeSegment IdentificationChilds
	 */
	public OfficeSegment getOfficeSegmentIdentificationChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int costumTransDoc_OFFICESEGM_IDENT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumTransDoc_OFFICESEGM_IDENT");
		int costumClearaOffName_OFFICESEGM_IDENT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumClearaOffName_OFFICESEGM_IDENT");

		String costumTransDoc_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumTransDoc_OFFICESEGM_IDENT);
		String costumClearaOffName_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumClearaOffName_OFFICESEGM_IDENT);

		OfficeSegment offSegm = new OfficeSegment();
		offSegm.setCustoms_clearance_office_code(costumTransDoc_OFFICESEGM_IDENT_String);
		offSegm.setCustoms_Clearance_office_name(costumClearaOffName_OFFICESEGM_IDENT_String);

		genInfoValid.validationCellsOfficeSegmentIdentificationChilds(offSegm, hmGenInfoColsNameAndPosit);

		return offSegm;
	}

	/**
	 * @param row
	 * @return Exporter TradersChilds
	 */
	public Exporter getExporterTradersChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int expoName_EXPO_TRADERS = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoName_EXPO_TRADERS");

		String expoName_EXPO_TRADERS_String = ExcelPoi.getString(row, expoName_EXPO_TRADERS);

		Exporter expo = new Exporter();
		expo.setExporter_name(expoName_EXPO_TRADERS_String);

		genInfoValid.validationCellsExporterTradersChilds(expo, hmGenInfoColsNameAndPosit);

		return expo;
	}

	/**
	 * @param row
	 * @return Forms PropertyChilds
	 */
	public Forms getFormsPropertyChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int numbForm_FORMS_PROPERT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "numbForm_FORMS_PROPERT");
		int totNumbForm_FORMS_PROPERT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "totNumbForm_FORMS_PROPERT");

		String numbForm_FORMS_PROPERT_String = ExcelPoi.getString(row, numbForm_FORMS_PROPERT);
		String totNumbForm_FORMS_PROPERT_String = ExcelPoi.getString(row, totNumbForm_FORMS_PROPERT);

		Forms formsProp = new Forms();
		formsProp.setNumber_of_the_form(numbForm_FORMS_PROPERT_String);
		formsProp.setTotal_number_of_forms(totNumbForm_FORMS_PROPERT_String);

		genInfoValid.validationCellsFormsPropertyChilds(formsProp, hmGenInfoColsNameAndPosit);

		return formsProp;
	}

	/**
	 * @param row
	 * @return Reference DeclarantChilds
	 */
	public Reference getReferenceDeclarantChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int number_REFER_DECLAR = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "number_REFER_DECLAR");

		String number_REFER_DECLAR_String = ExcelPoi.getString(row, number_REFER_DECLAR);

		Reference ref = new Reference();
		ref.setNumber(number_REFER_DECLAR_String);

		genInfoValid.validationCellsReferenceDeclarantChilds(ref, hmGenInfoColsNameAndPosit);

		return ref;
	}

	/**
	 * @param row
	 * @return Consignee TradersChilds
	 */
	public Consignee getConsigneeTradersChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int consignName_CONSI_TRADERS = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "consignName_CONSI_TRADERS");
		int consignCode_CONSI_TRADERS = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "consignCode_CONSI_TRADERS");

		String consignName_CONSI_TRADERS_String = ExcelPoi.getString(row, consignName_CONSI_TRADERS);
		String consignCode_CONSI_TRADERS_String = ExcelPoi.getString(row, consignCode_CONSI_TRADERS);

		Consignee cons = new Consignee();
		cons.setConsignee_code(consignCode_CONSI_TRADERS_String);
		cons.setConsignee_name(consignName_CONSI_TRADERS_String);

		genInfoValid.validationCellsConsigneeTradersChilds(cons, hmGenInfoColsNameAndPosit);

		return cons;
	}

	/**
	 * @param row
	 * @return Country GeneralInfoChilds
	 */
	public Country getCountryGeneralInfoChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int countrFirstDest_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "countrFirstDest_COUNTR_GENERINFO");
		int tradingCountr_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "tradingCountr_COUNTR_GENERINFO");

		String countrFirstDest_COUNTR_GENERINFO_String = ExcelPoi.getString(row, countrFirstDest_COUNTR_GENERINFO);
		String tradingCountr_COUNTR_GENERINFO_String = ExcelPoi.getString(row, tradingCountr_COUNTR_GENERINFO);

		Country count = new Country();
		count.setCountry_first_destination(countrFirstDest_COUNTR_GENERINFO_String);
		count.setTrading_country(tradingCountr_COUNTR_GENERINFO_String);

		genInfoValid.validationCellsCountryGeneralInfoChilds(count, hmGenInfoColsNameAndPosit);

		return count;
	}

	/**
	 * @param row
	 * @return valueDetails GENERINFO
	 */
	public String getValueDetailGeneralInfo(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int valueDetails_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "valueDetails_GENERINFO");

		String valueDetails_GENERINFO_String = ExcelPoi.getString(row, valueDetails_GENERINFO);

		genInfoValid.validCellValDetailGeneralInfo(valueDetails_GENERINFO_String, hmGenInfoColsNameAndPosit);

		return valueDetails_GENERINFO_String;
	}

	/**
	 * @param row
	 * @return Declarant
	 */
	public Declarant getDeclarant(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int declarName_DECLAR = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarName_DECLAR");
		int declarCode_DECLAR = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarCode_DECLAR");
		int declarReprestative_DECLAR = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarReprestative_DECLAR");

		String declarName_DECLAR_String = ExcelPoi.getString(row, declarName_DECLAR);
		String declarCode_DECLAR_String = ExcelPoi.getString(row, declarCode_DECLAR);
		String declarReprestative_DECLAR_String = ExcelPoi.getString(row, declarReprestative_DECLAR);

		Declarant decl = new Declarant();
		decl.setDeclarant_code(declarCode_DECLAR_String);
		decl.setDeclarant_name(declarName_DECLAR_String);
		decl.setDeclarant_representative(declarReprestative_DECLAR_String);

		genInfoValid.validationCellsDeclarant(decl, hmGenInfoColsNameAndPosit);

		return decl;
	}

	/**
	 * @param row
	 * @return Export GeneralInnfo
	 */
	public Export getExportGeneralInnfo(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int expoCountrName_EXPO_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoCountrName_EXPO_COUNTR_GENERINFO");
		int expoCountrCode_EXPO_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoCountrCode_EXPO_COUNTR_GENERINFO");

		String expoCountrName_EXPO_COUNTR_GENERINFO_String = ExcelPoi.getString(row, expoCountrName_EXPO_COUNTR_GENERINFO);
		String expoCountrCode_EXPO_COUNTR_GENERINFO_String = ExcelPoi.getString(row, expoCountrCode_EXPO_COUNTR_GENERINFO);

		Export export = new Export();
		export.setExport_country_code(expoCountrCode_EXPO_COUNTR_GENERINFO_String);
		export.setExport_country_name(expoCountrName_EXPO_COUNTR_GENERINFO_String);

		genInfoValid.validationCellsExportGeneralInnfo(export, hmGenInfoColsNameAndPosit);

		return export;
	}

	/**
	 * @param row
	 * @return countrOrigName GENERINFO
	 */
	public String getValueCountrOrigNameGeneralInfo(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int countrOrigName_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "countrOrigName_COUNTR_GENERINFO");

		String countrOrigName_COUNTR_GENERINFO_String = ExcelPoi.getString(row, countrOrigName_COUNTR_GENERINFO);

		genInfoValid.validCellValCountrOrigNameGeneralInfo(countrOrigName_COUNTR_GENERINFO_String, hmGenInfoColsNameAndPosit);

		return countrOrigName_COUNTR_GENERINFO_String;
	}

	/**
	 * @param row
	 * @return Destination GENERINFO
	 */
	public Destination getValueCountrDestCountrNameGeneralInfo(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int codeCountrName_DEST_COUNTR_GENERINFO = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "codeCountrName_DEST_COUNTR_GENERINFO");

		String codeCountrName_DEST_COUNTR_GENERINFO_String = ExcelPoi.getString(row, codeCountrName_DEST_COUNTR_GENERINFO);
		String destCountrName_DEST_COUNTR_GENERINFO_String = "";

		Destination dest = new Destination();
		
		dest.setDestination_country_code(codeCountrName_DEST_COUNTR_GENERINFO_String);
		
		// ****TODO
		if(codeCountrName_DEST_COUNTR_GENERINFO_String.equals("AL"))
			destCountrName_DEST_COUNTR_GENERINFO_String = "Albania";
		if(codeCountrName_DEST_COUNTR_GENERINFO_String.equals("TR"))
			destCountrName_DEST_COUNTR_GENERINFO_String = "Turqia";
		
		dest.setDestination_country_name(destCountrName_DEST_COUNTR_GENERINFO_String);

		genInfoValid.validCellValDestinationGeneralInfo(dest, hmGenInfoColsNameAndPosit);

		return dest;
	}

	/**
	 * @param row
	 * @return DeliveryTerms TransportChilds
	 */
	public DeliveryTerms getValueDeliveryTermsTransportChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int code_DELIVTERMS_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "code_DELIVTERMS_TRANSP");
		int place_DELIVTERMS_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "place_DELIVTERMS_TRANSP");

		String code_DELIVTERMS_TRANSP_String = ExcelPoi.getString(row, code_DELIVTERMS_TRANSP);
		String place_DELIVTERMS_TRANSP_String = ExcelPoi.getString(row, place_DELIVTERMS_TRANSP);

		DeliveryTerms delTerm = new DeliveryTerms();
		delTerm.setCode(code_DELIVTERMS_TRANSP_String);
		delTerm.setPlace(place_DELIVTERMS_TRANSP_String);

		genInfoValid.validCellValDeliveryTermsTransportChilds(delTerm, hmGenInfoColsNameAndPosit);

		return delTerm;
	}

	/**
	 * @param row
	 * @return DepartureArrivalInformation
	 * NJESOJ ME BORDER INFORMATION, PER TU VERIFIKUAR
	 */
	public DepartureArrivalInformation getValueDepartureArrivalInformation(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int identity_BORDERINFO_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "identity_BORDERINFO_MEANTRANSP_TRANSP");
		int nationality_BORDERINFO_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "nationality_BORDERINFO_MEANTRANSP_TRANSP");

		String identity_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, identity_BORDERINFO_MEANTRANSP_TRANSP);
		String nationality_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, nationality_BORDERINFO_MEANTRANSP_TRANSP);

		DepartureArrivalInformation dai = new DepartureArrivalInformation();
		dai.setIdentity(identity_BORDERINFO_MEANTRANSP_TRANSP_String);
		dai.setNationality(nationality_BORDERINFO_MEANTRANSP_TRANSP_String);

		genInfoValid.validCellValDepartureArrivalInformation(dai, hmGenInfoColsNameAndPosit);

		return dai;
	}

	/**
	 * @param row
	 * @return BorderInformation
	 */
	public BorderInformation getValueBorderInformation(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int identity_BORDERINFO_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "identity_BORDERINFO_MEANTRANSP_TRANSP");
		int nationality_BORDERINFO_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "nationality_BORDERINFO_MEANTRANSP_TRANSP");
		int mode_BORDERINFO_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "mode_BORDERINFO_MEANTRANSP_TRANSP");

		String identity_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, identity_BORDERINFO_MEANTRANSP_TRANSP);
		String nationality_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, nationality_BORDERINFO_MEANTRANSP_TRANSP);
		String mode_BORDERINFO_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, mode_BORDERINFO_MEANTRANSP_TRANSP);

		BorderInformation bi = new BorderInformation();
		bi.setIdentity(identity_BORDERINFO_MEANTRANSP_TRANSP_String);
		bi.setNationality(nationality_BORDERINFO_MEANTRANSP_TRANSP_String);
		bi.setMode(mode_BORDERINFO_MEANTRANSP_TRANSP_String);

		genInfoValid.validCellValBorderInformation(bi, hmGenInfoColsNameAndPosit);

		return bi;
	}

	/**
	 * @param row
	 * @return GsInvoice ValuationChilds
	 */ 
	public GsInvoice getValueGsInvoiceValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		int amountForegCurr_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "amountForegCurr_GSINVOICE_VALU");
		int currRate_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currRate_GSINVOICE_VALU");

		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);
		String amountForegCurr_GSINVOICE_VALU_String = ExcelPoi.getString(row, amountForegCurr_GSINVOICE_VALU);
		String currRate_GSINVOICE_VALU_String = ExcelPoi.getString(row, currRate_GSINVOICE_VALU);

		GsInvoice gsInv = new GsInvoice();
		gsInv.setCurrency_code(currCode_GSINVOICE_VALU_String);
		gsInv.setAmount_foreign_currency(amountForegCurr_GSINVOICE_VALU_String);
		// kot
		gsInv.setCurrency_name("Ska monedhe te huaj");
		gsInv.setAmount_national_currency( currency.calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String) );
		gsInv.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
		

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_Invoice() != null 
						&& item.getValuation_item().getItem_Invoice().getAmount_foreign_currency() != null)
				sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_Invoice().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_Invoice() != null 
						&& item.getValuation_item().getItem_Invoice().getAmount_national_currency() != null)
					sumAmounNationalCurr.add(item.getValuation_item().getItem_Invoice().getAmount_national_currency());
				
			}
		}

		genInfoValid.validCellValGsInvoiceValuationChilds(gsInv, hmGenInfoColsNameAndPosit);

		return gsInv;
	}
	
	/**
	 * @param row
	 * @return Valuation
	 */ 
	public Valuation getValueValuation(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int calcWorkMode_VAL = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "calcWorkMode_VAL");

		String calcWorkMode_VAL_String = ExcelPoi.getString(row, calcWorkMode_VAL);

		Valuation val = new Valuation();
		val.setCalculation_working_mode(calcWorkMode_VAL_String);
		
		
		genInfoValid.validCellValValuation(val, hmGenInfoColsNameAndPosit);

		return val;
	}
	
	/**
	 * @param row
	 * @return InlandModeTransp MEANTRANSP_TRANSP
	 */
	public String getValueInlandModeTransp(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int inlandModeTransp_MEANTRANSP_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "inlandModeTransp_MEANTRANSP_TRANSP");

		String inlandModeTransp_MEANTRANSP_TRANSP_String = ExcelPoi.getString(row, inlandModeTransp_MEANTRANSP_TRANSP);

		genInfoValid.validCellValInlandModeTransp(inlandModeTransp_MEANTRANSP_TRANSP_String, hmGenInfoColsNameAndPosit);

		return inlandModeTransp_MEANTRANSP_TRANSP_String;
	}
	
	/**
	 * @param row
	 * @return Valuation
	 */ 
	public BorderOffice getValueBorderOfficeTransChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int code_BORDEROFFIC_TRANSP = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "code_BORDEROFFIC_TRANSP");

		String code_BORDEROFFIC_TRANSP_String = ExcelPoi.getString(row, code_BORDEROFFIC_TRANSP);

		BorderOffice bordOff = new BorderOffice();
		bordOff.setCode(code_BORDEROFFIC_TRANSP_String);

		if(code_BORDEROFFIC_TRANSP_String.equals("AL190000"))
			bordOff.setName("Kapshtica");
		else
			bordOff.setName("Durresi");	// vete
		
		
		genInfoValid.validCellValBorderOfficeTransChilds(bordOff, hmGenInfoColsNameAndPosit);

		return bordOff;
	}
	
	/**
	 * @param row
	 * @return modePaym_FINANC_TRANSP
	 */
	public String getValueModePaymFINANC(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int modePaym_FINANC = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "modePaym_FINANC");

		String modePaym_FINANC_String = ExcelPoi.getString(row, modePaym_FINANC);

		genInfoValid.validCellValModePaymFINANC(modePaym_FINANC_String, hmGenInfoColsNameAndPosit);

		return modePaym_FINANC_String;
	}
	
	/**
	 * 
	 * */
	public Asycuda updateTotCostTotCIFTotInvoiceTotWeight(Asycuda asycuda) {

		BigDecimal sumTotalCIF = BigDecimal.ZERO;
		BigDecimal sumTotalCost = BigDecimal.ZERO;
		
		BigDecimal sumTotalInvoice = BigDecimal.ZERO;
		BigDecimal sumTotalWeight = BigDecimal.ZERO;
		
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getTotal_CIF_itm() != null)
					sumTotalCIF = sumTotalCIF.add(item.getValuation_item().getTotal_CIF_itm());
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getTotal_cost_itm() != null)
					sumTotalCost = sumTotalCost.add(new BigDecimal(item.getValuation_item().getTotal_cost_itm()));
				
				
				if(item != null 
						&& item.getTarification() != null 
						&& item.getTarification().getItem_price() != null)
					sumTotalInvoice = sumTotalInvoice.add(new BigDecimal(item.getTarification().getItem_price()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getWeight_itm() != null
						&& item.getValuation_item().getWeight_itm().getGross_weight_itm() != null)
					sumTotalWeight = sumTotalWeight.add(new BigDecimal(item.getValuation_item().getWeight_itm().getGross_weight_itm()));
				
			}
		}
		asycuda.getValuation().setTotal_CIF(sumTotalCIF);
		asycuda.getValuation().setTotal_cost(sumTotalCost);
		
		Total tot = new Total();
		tot.setTotal_invoice(sumTotalInvoice);
		tot.setTotal_weight(sumTotalWeight);

		asycuda.getValuation().setTotal(tot);
		
		asycuda.getValuation().getTotal().setTotal_invoice(sumTotalInvoice);
		
		return asycuda;
	}
	
	
	/**
	 * @param row
	 * @return Nbers PropertyChilds
	 */
	public Nbers getNbersPropertyChilds(Row row, Asycuda asycuda, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int numbLoadLists_NBERS_PROPERT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "numbLoadLists_NBERS_PROPERT");
		int totNumbPackages_NBERS_PROPERT = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "totNumbPackages_NBERS_PROPERT");

		String numbLoadLists_NBERS_PROPERT_String = ExcelPoi.getString(row, numbLoadLists_NBERS_PROPERT);
		String totNumbPackages_NBERS_PROPERT_String = ExcelPoi.getString(row, totNumbPackages_NBERS_PROPERT);

		Nbers nbers = new Nbers();
		
		BigDecimal sumTotalNumbPackages_NBERS_PROPERT = BigDecimal.ZERO;
		BigDecimal sumTotalWeight = BigDecimal.ZERO;
		
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {

				if(item.getPackages() != null
						&& item.getPackages().getNumber_of_packages() != null) {
					sumTotalNumbPackages_NBERS_PROPERT = 
							sumTotalNumbPackages_NBERS_PROPERT.add(
									new BigDecimal(item.getPackages()
											           .getNumber_of_packages())
									                   .setScale(0, BigDecimal.ROUND_UP));
				}
					
					
			}
			nbers.setTotal_number_of_items(new Integer(asycuda.getItem().size()));
		}

		nbers.setNumber_of_loading_lists(numbLoadLists_NBERS_PROPERT_String);
		
		nbers.setTotal_number_of_packages(sumTotalNumbPackages_NBERS_PROPERT);

		genInfoValid.validationCellsNbersPropertyChilds(nbers, hmGenInfoColsNameAndPosit);

		return nbers;
	}
	
	
}
