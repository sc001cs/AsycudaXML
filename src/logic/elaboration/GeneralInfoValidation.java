package logic.elaboration;

import java.util.HashMap;

import configuration.ConfigFileExcel;
import enitity.asycuda.Declarant;
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

public class GeneralInfoValidation {

	public ConfigFileExcel confFileExcel = new ConfigFileExcel();

	public void validationCellsTypeIdentificationChilds(Type type, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(type.getType_of_declaration() == null || 
				type.getType_of_declaration().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: typeDeclaration_TYPE_IDENT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "typeDeclaration_TYPE_IDENT"));
		}

		if(type.getDeclaration_gen_procedure_code() == null ||
				type.getDeclaration_gen_procedure_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: declarGenProcCode_TYPE_IDENT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarGenProcCode_TYPE_IDENT"));
		}

	}

	public void validationCellsOfficeSegmentIdentificationChilds(OfficeSegment offSegm, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(offSegm.getCustoms_clearance_office_code() == null || 
				offSegm.getCustoms_clearance_office_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: costumTransDoc_OFFICESEGM_IDENT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumTransDoc_OFFICESEGM_IDENT"));
		}

		if(offSegm.getCustoms_Clearance_office_name() == null ||
				offSegm.getCustoms_Clearance_office_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: costumClearaOffName_OFFICESEGM_IDENT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumClearaOffName_OFFICESEGM_IDENT"));
		}

	}

	public void validationCellsExporterTradersChilds(Exporter expo, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(expo.getExporter_name() == null || 
				expo.getExporter_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: expoName_EXPO_TRADERS -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoName_EXPO_TRADERS"));
		}
	}

	public void validationCellsFormsPropertyChilds(Forms formsProp, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(formsProp.getNumber_of_the_form() == null || 
				formsProp.getNumber_of_the_form().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: numbForm_FORMS_PROPERT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "numbForm_FORMS_PROPERT"));
		}

		if(formsProp.getTotal_number_of_forms() == null || 
				formsProp.getTotal_number_of_forms().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: totNumbForm_FORMS_PROPERT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "totNumbForm_FORMS_PROPERT"));
		}
	}
	
	public void validationCellsNbersPropertyChilds(Nbers nbers, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(nbers.getTotal_number_of_items() == null || 
				nbers.getTotal_number_of_items().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: totNumbItems_NBERS_PROPERT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "totNumbItems_NBERS_PROPERT"));
		}
		
		if(nbers.getTotal_number_of_packages() == null || 
				nbers.getTotal_number_of_packages().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: totNumbPackages_NBERS_PROPERT -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "totNumbPackages_NBERS_PROPERT"));
		}
	}

	public void validationCellsReferenceDeclarantChilds(Reference ref, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(ref.getNumber() == null || 
				ref.getNumber().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: number_REFER_DECLAR -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "number_REFER_DECLAR"));
		}
		
	}
	
	public void validationCellsConsigneeTradersChilds(Consignee cons, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(cons.getConsignee_name() == null || 
				cons.getConsignee_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: consignName_CONSI_TRADERS -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "consignName_CONSI_TRADERS"));
		}
		
		if(cons.getConsignee_code() == null || 
				cons.getConsignee_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: consignCode_CONSI_TRADERS -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "consignCode_CONSI_TRADERS"));
		}
		
	}
	
	public void validationCellsCountryGeneralInfoChilds(Country count, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(count.getCountry_first_destination() == null || 
				count.getCountry_first_destination().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: countrFirstDest_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "countrFirstDest_COUNTR_GENERINFO"));
		}
		
		if(count.getTrading_country() == null || 
				count.getTrading_country().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: tradingCountr_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "tradingCountr_COUNTR_GENERINFO"));
		}
		
	}
	
	public void validCellValDetailGeneralInfo(String valueDetails_GENERINFO_String, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(valueDetails_GENERINFO_String == null || 
				valueDetails_GENERINFO_String.equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: valueDetails_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "valueDetails_GENERINFO"));
		}

	}
	
	public void validationCellsDeclarant(Declarant decl, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(decl.getDeclarant_name() == null || 
				decl.getDeclarant_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: declarName_DECLAR -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarName_DECLAR"));
		}
		
		if(decl.getDeclarant_code() == null || 
				decl.getDeclarant_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: declarCode_DECLAR -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarCode_DECLAR"));
		}
		
		if(decl.getDeclarant_representative() == null || 
				decl.getDeclarant_representative().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: declarReprestative_DECLAR -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarReprestative_DECLAR"));
		}
		
	}
	
	public void validationCellsExportGeneralInnfo(Export export, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(export.getExport_country_name() == null || 
				export.getExport_country_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: expoCountrName_EXPO_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoCountrName_EXPO_COUNTR_GENERINFO"));
		}
		
		if(export.getExport_country_code() == null || 
				export.getExport_country_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: expoCountrCode_EXPO_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "expoCountrCode_EXPO_COUNTR_GENERINFO"));
		}
		
	}
	
	public void validCellValCountrOrigNameGeneralInfo(String countrOrigName_COUNTR_GENERINFO_String, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(countrOrigName_COUNTR_GENERINFO_String == null || 
				countrOrigName_COUNTR_GENERINFO_String.equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: countrOrigName_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "countrOrigName_COUNTR_GENERINFO"));
		}

	}
	
	public void validCellValDestinationGeneralInfo(Destination dest, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(dest.getDestination_country_name() == null || 
				dest.getDestination_country_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: codeCountrName_DEST_COUNTR_GENERINFO -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "codeCountrName_DEST_COUNTR_GENERINFO"));
		}

	}
	
	public void validCellValDeliveryTermsTransportChilds(DeliveryTerms delTerm, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(delTerm.getCode() == null || 
				delTerm.getCode().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: code_DELIVTERMS_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "code_DELIVTERMS_TRANSP"));
		}
		
		if(delTerm.getPlace() == null || 
				delTerm.getPlace().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: place_DELIVTERMS_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "place_DELIVTERMS_TRANSP"));
		}
		
	}
	
	public void validCellValDepartureArrivalInformation(DepartureArrivalInformation dai, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(dai.getIdentity() == null || 
				dai.getIdentity().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: identity_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "identity_MEANTRANSP_TRANSP"));
		}
		
		if(dai.getNationality() == null || 
				dai.getNationality().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: nationality_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "nationality_MEANTRANSP_TRANSP"));
		}
		
	}
	
	public void validCellValBorderInformation(BorderInformation bi, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(bi.getIdentity() == null || 
				bi.getIdentity().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: identity_BORDERINFO_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "identity_BORDERINFO_MEANTRANSP_TRANSP"));
		}
		
		if(bi.getNationality() == null || 
				bi.getNationality().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: nationality_BORDERINFO_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "nationality_BORDERINFO_MEANTRANSP_TRANSP"));
		}
		
		if(bi.getMode() == null || 
				bi.getMode().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: mode_BORDERINFO_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "mode_BORDERINFO_MEANTRANSP_TRANSP"));
		}
	}
	
	public void validCellValGsInvoiceValuationChilds(GsInvoice gsInv, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(gsInv.getCurrency_code() == null || 
				gsInv.getCurrency_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: currCode_GSINVOICE_VALU -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU"));
		}
		
		if(gsInv.getAmount_foreign_currency() == null || 
				gsInv.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: amountForegCurr_GSINVOICE_VALU -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "amountForegCurr_GSINVOICE_VALU"));
		}
	
	}
	
	public void validCellValValuation(Valuation val, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(val.getCalculation_working_mode() == null || 
				val.getCalculation_working_mode().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: calcWorkMode_VAL -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "calcWorkMode_VAL"));
		}
	
	}
	
	public void validCellValInlandModeTransp(String inlandModeTransp_MEANTRANSP_TRANSP_String, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(inlandModeTransp_MEANTRANSP_TRANSP_String == null || 
				inlandModeTransp_MEANTRANSP_TRANSP_String.equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: inlandModeTransp_MEANTRANSP_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "inlandModeTransp_MEANTRANSP_TRANSP"));
		}
	
	}
	
	public void validCellValBorderOfficeTransChilds(BorderOffice bordOff, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(bordOff.getCode() == null || 
				bordOff.getCode().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: code_BORDEROFFIC_TRANSP -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "code_BORDEROFFIC_TRANSP"));
		}
	
	}
	
	public void validCellValModePaymFINANC(String modePaym_FINANC_String, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(modePaym_FINANC_String == null || 
				modePaym_FINANC_String.equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: modePaym_FINANC -- Sheet1 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "modePaym_FINANC"));
		}
	
	}
	
	
	
	
	
	
}
