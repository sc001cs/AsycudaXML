package logic.elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GeneralInfoPositionCell {
	
	public HashMap<Integer, String> hmGenInfoColsName() {
	
		List<String> listGenInfoColsName = new ArrayList<String>();
		
		listGenInfoColsName.add("typeDeclaration_TYPE_IDENT");
		listGenInfoColsName.add("declarGenProcCode_TYPE_IDENT");
		listGenInfoColsName.add("typeTransDoc_TYPE_IDENT");
		
		listGenInfoColsName.add("costumTransDoc_OFFICESEGM_IDENT");
		listGenInfoColsName.add("costumClearaOffName_OFFICESEGM_IDENT");
		
		listGenInfoColsName.add("expoName_EXPO_TRADERS");
		
		listGenInfoColsName.add("numbForm_FORMS_PROPERT");
		listGenInfoColsName.add("totNumbForm_FORMS_PROPERT");
		
		listGenInfoColsName.add("numbLoadLists_NBERS_PROPERT");
		listGenInfoColsName.add("totNumbItems_NBERS_PROPERT");
		listGenInfoColsName.add("totNumbPackages_NBERS_PROPERT");
		
		listGenInfoColsName.add("number_REFER_DECLAR");
		
		listGenInfoColsName.add("consignName_CONSI_TRADERS");
		listGenInfoColsName.add("consignCode_CONSI_TRADERS");
		
		listGenInfoColsName.add("countrFirstDest_COUNTR_GENERINFO");
		listGenInfoColsName.add("tradingCountr_COUNTR_GENERINFO");
		
	//	listGenInfoColsName.add("valueDetails_GENERINFO");
		
		listGenInfoColsName.add("declarName_DECLAR");
		listGenInfoColsName.add("declarCode_DECLAR");
		
		listGenInfoColsName.add("expoCountrName_EXPO_COUNTR_GENERINFO");
		listGenInfoColsName.add("expoCountrCode_EXPO_COUNTR_GENERINFO");
		
		listGenInfoColsName.add("countrOrigName_COUNTR_GENERINFO");
		
		listGenInfoColsName.add("codeCountrName_DEST_COUNTR_GENERINFO");
		
		listGenInfoColsName.add("identity_MEANTRANSP_TRANSP");
		listGenInfoColsName.add("nationality_MEANTRANSP_TRANSP");
		
		listGenInfoColsName.add("contaiFlag_TRANSP");
		
		listGenInfoColsName.add("code_DELIVTERMS_TRANSP");
		listGenInfoColsName.add("place_DELIVTERMS_TRANSP");
		
		listGenInfoColsName.add("identity_BORDERINFO_MEANTRANSP_TRANSP");
		listGenInfoColsName.add("nationality_BORDERINFO_MEANTRANSP_TRANSP");
		
		listGenInfoColsName.add("currCode_GSINVOICE_VALU");
		listGenInfoColsName.add("amountForegCurr_GSINVOICE_VALU");
	//	listGenInfoColsName.add("currRate_GSINVOICE_VALU");
		
		listGenInfoColsName.add("calcWorkMode_VAL");
		
		listGenInfoColsName.add("mode_BORDERINFO_MEANTRANSP_TRANSP");
		
		listGenInfoColsName.add("inlandModeTransp_MEANTRANSP_TRANSP");
		
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		
		listGenInfoColsName.add("code_BORDEROFFIC_TRANSP");
		
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		
		listGenInfoColsName.add("modePaym_FINANC");
		
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		listGenInfoColsName.add("");
		
		listGenInfoColsName.add("declarReprestative_DECLAR");
		
		HashMap<Integer, String> hmCollectionCosName = new HashMap<Integer, String>();
		
		int count = 0;
		for (String colName : listGenInfoColsName) {
			hmCollectionCosName.put(count, colName);
			count++;
		}
		
		return hmCollectionCosName;
	}
	
	
	
}
