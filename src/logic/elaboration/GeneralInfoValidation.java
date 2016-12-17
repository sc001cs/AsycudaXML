package logic.elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.desktop.DesktopController;
import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import configuration.xml.ConfigXML;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.ConvertIntToLetter;
import logic.ExcelPoi;
import modules.GenerateXMLFINAL;
import multi_item.GeneralInfoExcel;

public class GeneralInfoValidation {

	public ConfigFileExcel confFileExcel = new ConfigFileExcel();
	ConfigXML confXML = confFileExcel.getConfigXML();
	ConvertIntToLetter intToLetter = new ConvertIntToLetter();
	
	GeneralInfoPositionCell genInfoPosCellClass = new GeneralInfoPositionCell();
	HashMap<Integer, String> hmGenInfoColsNameAndPositClass = genInfoPosCellClass.hmGenInfoColsName();

	public void validationCellsTypeIdentificationChilds(Type type) {

		if(type.getType_of_declaration() == null || 
				type.getType_of_declaration().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "typeDeclaration_TYPE_IDENT");
		}

		if(type.getDeclaration_gen_procedure_code() == null ||
				type.getDeclaration_gen_procedure_code().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "declarGenProcCode_TYPE_IDENT");
		}

	}

	public void validationCellsOfficeSegmentIdentificationChilds(OfficeSegment offSegm) {

		if(offSegm.getCustoms_clearance_office_code() == null || 
				offSegm.getCustoms_clearance_office_code().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "costumTransDoc_OFFICESEGM_IDENT");
			
			
		}

		if(offSegm.getCustoms_Clearance_office_name() == null ||
				offSegm.getCustoms_Clearance_office_name().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "costumClearaOffName_OFFICESEGM_IDENT");
			
		}

	}

	public void validationCellsExporterTradersChilds(Exporter expo) {

		if(expo.getExporter_name() == null || 
				expo.getExporter_name().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "expoName_EXPO_TRADERS");
			
		}
	}

	public void validationCellsFormsPropertyChilds(Forms formsProp) {

		if(formsProp.getNumber_of_the_form() == null || 
				formsProp.getNumber_of_the_form().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "numbForm_FORMS_PROPERT");
			
		}

		if(formsProp.getTotal_number_of_forms() == null || 
				formsProp.getTotal_number_of_forms().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "totNumbForm_FORMS_PROPERT");
			
		}
	}
	
	public void validationCellsNbersPropertyChilds(Nbers nbers) {

		if(nbers.getTotal_number_of_items() == null || 
				nbers.getTotal_number_of_items().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "totNumbItems_NBERS_PROPERT");
			
		}
		
		if(nbers.getTotal_number_of_packages() == null || 
				nbers.getTotal_number_of_packages().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "totNumbPackages_NBERS_PROPERT");
			
		}
	}

	public void validationCellsReferenceDeclarantChilds(Reference ref) {

		if(ref.getNumber() == null || 
				ref.getNumber().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "number_REFER_DECLAR");
			
		}
	}
	
	public void validationCellsConsigneeTradersChilds(Consignee cons) {

		if(cons.getConsignee_name() == null || 
				cons.getConsignee_name().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "consignName_CONSI_TRADERS");
			
		}
		
		if(cons.getConsignee_code() == null || 
				cons.getConsignee_code().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "consignCode_CONSI_TRADERS");
			
		}
		
	}
	
	public void validationCellsCountryGeneralInfoChilds(Country count) {

		if(count.getCountry_first_destination() == null || 
				count.getCountry_first_destination().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "countrFirstDest_COUNTR_GENERINFO");
			
		}
		
		if(count.getTrading_country() == null || 
				count.getTrading_country().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "tradingCountr_COUNTR_GENERINFO");
			
		}
		
	}
	
	public void validCellValDetailGeneralInfo(String valueDetails_GENERINFO_String) {

		if(valueDetails_GENERINFO_String == null || 
				valueDetails_GENERINFO_String.equals("")) {

			addNotifMsg(AlertMsg.WARNING, "valueDetails_GENERINFO");
			
		}

	}
	
	public void validationCellsDeclarant(Declarant decl) {

		if(decl.getDeclarant_name() == null || 
				decl.getDeclarant_name().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "declarName_DECLAR");
			
		}
		
		if(decl.getDeclarant_code() == null || 
				decl.getDeclarant_code().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "declarCode_DECLAR");
			
		}
		
		if(decl.getDeclarant_representative() == null || 
				decl.getDeclarant_representative().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "declarReprestative_DECLAR");
			
		}
		
	}
	
	public void validationCellsExportGeneralInnfo(Export export) {

		if(export.getExport_country_name() == null || 
				export.getExport_country_name().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "expoCountrName_EXPO_COUNTR_GENERINFO");
			
		}
		
		if(export.getExport_country_code() == null || 
				export.getExport_country_code().equals("")) {

			addNotifMsg(AlertMsg.WARNING, "expoCountrCode_EXPO_COUNTR_GENERINFO");
			
		}
		
	}
	
	public void validCellValCountrOrigNameGeneralInfo(String countrOrigName_COUNTR_GENERINFO_String) {

		if(countrOrigName_COUNTR_GENERINFO_String == null || 
				countrOrigName_COUNTR_GENERINFO_String.equals("")) {

			addNotifMsg(AlertMsg.WARNING, "countrOrigName_COUNTR_GENERINFO");
			
		}

	}
	
	public void validCellValDestinationGeneralInfo(Destination dest) {

		if(dest.getDestination_country_name() == null || 
				dest.getDestination_country_name().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "codeCountrName_DEST_COUNTR_GENERINFO");
			
		}

	}
	
	public void validCellValDeliveryTermsTransportChilds(DeliveryTerms delTerm) {

		if(delTerm.getCode() == null || 
				delTerm.getCode().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "code_DELIVTERMS_TRANSP");
			
		}
		
		if(delTerm.getPlace() == null || 
				delTerm.getPlace().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "place_DELIVTERMS_TRANSP");
			
		}
		
	}
	
	public void validCellValDepartureArrivalInformation(DepartureArrivalInformation dai) {

		if(dai.getIdentity() == null || 
				dai.getIdentity().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "identity_MEANTRANSP_TRANSP");
			
		}
		
		if(dai.getNationality() == null || 
				dai.getNationality().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "nationality_MEANTRANSP_TRANSP");
			
		}
		
	}
	
	public void validCellValBorderInformation(BorderInformation bi) {

		if(bi.getIdentity() == null || 
				bi.getIdentity().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "identity_BORDERINFO_MEANTRANSP_TRANSP");
			
		}
		
		if(bi.getNationality() == null || 
				bi.getNationality().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "nationality_BORDERINFO_MEANTRANSP_TRANSP");
			
		}
		
		if(bi.getMode() == null || 
				bi.getMode().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "mode_BORDERINFO_MEANTRANSP_TRANSP");
			
		}
	}
	
	public void validCellValGsInvoiceValuationChilds(GsInvoice gsInv) {

		if(gsInv.getCurrency_code() == null || 
				gsInv.getCurrency_code().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "currCode_GSINVOICE_VALU");
			
		}
		
		if(gsInv.getAmount_foreign_currency() == null || 
				gsInv.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "amountForegCurr_GSINVOICE_VALU");
			
		}
	
	}
	
	public void validCellValValuation(Valuation val) {

		if(val.getCalculation_working_mode() == null || 
				val.getCalculation_working_mode().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "calcWorkMode_VAL");
			
		}
	
	}
	
	public void validCellValInlandModeTransp(String inlandModeTransp_MEANTRANSP_TRANSP_String) {

		if(inlandModeTransp_MEANTRANSP_TRANSP_String == null || 
				inlandModeTransp_MEANTRANSP_TRANSP_String.equals("")) {
			addNotifMsg(AlertMsg.WARNING, "inlandModeTransp_MEANTRANSP_TRANSP");
			
		}
	
	}
	
	public void validCellValBorderOfficeTransChilds(BorderOffice bordOff) {

		if(bordOff.getCode() == null || 
				bordOff.getCode().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "code_BORDEROFFIC_TRANSP");
			
		}
	}
	
	public void validCellValModePaymFINANC(String modePaym_FINANC_String) {

		if(modePaym_FINANC_String == null || 
				modePaym_FINANC_String.equals("")) {
			addNotifMsg(AlertMsg.WARNING, "modePaym_FINANC");
			
		}
	
	}
	
	public void addNotifMsg(String typeAlert, String code) {

		int pos = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPositClass, code);
		String descr = ExcelPoi.getString(GeneralInfoExcel.rowDescrGenInfo, pos);

		String msg = confXML.getGeneral().getAlertFillOutCell() + descr + confXML.getGeneral().getSheet1() + 
				intToLetter.toAlphabetic(confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPositClass, code)) + (GeneralInfoExcel.ROW+1);

		if(DesktopController.alerts.containsKey(typeAlert)) {
			DesktopController.alerts.get(typeAlert).add(msg);
		} else {
			List<String> listWarning = new ArrayList<String>();
			listWarning.add(msg);
			DesktopController.alerts.put(typeAlert, listWarning);
		}
	}
	
}
