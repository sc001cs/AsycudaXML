package logic.elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GeneralInfoPositionCell {

	/*
	public static int typeDeclaration_TYPE_IDENT = 0;
	public static int declarGenProcCode_TYPE_IDENT = 1;
	public static int typeTransDoc_TYPE_IDENT = 2;
	
	public static int costumTransDoc_OFFICESEGM_IDENT = 3;
	public static int costumClearaOffName_OFFICESEGM_IDENT = 4;
	
	public static int expoName_EXPO_TRADERS = 5;
	
	public static int numbForm_FORMS_PROPERT = 6;
	public static int totNumbForm_FORMS_PROPERT = 7;
	
	public static int numbLoadLists_NBERS_PROPERT = 8;
	public static int totNumbItems_NBERS_PROPERT = 9;
	public static int totNumbPackages_NBERS_PROPERT = 10;
	
	public static int number_REFER_DECLAR = 11;
	
	public static int consignName_CONSI_TRADERS = 12;
	public static int consignCode_CONSI_TRADERS = 13;
	
	public static int countrFirstDest_COUNTR_GENERINFO = 15;
	public static int tradingCountr_COUNTR_GENERINFO = 16;
	
	public static int valueDetails_GENERINFO = 17;
	
	public static int declarName_DECLAR = 19;
	public static int declarCode_DECLAR = 20;
	
	public static int expoCountrName_EXPO_COUNTR_GENERINFO = 21;
	public static int expoCountrCode_EXPO_COUNTR_GENERINFO = 22;
	
	public static int countrOrigName_COUNTR_GENERINFO = 23;
	
	public static int codeCountrName_DEST_COUNTR_GENERINFO = 24;
	
	public static int identity_MEANTRANSP_TRANSP = 25;
	public static int nationality_MEANTRANSP_TRANSP = 26;
	
	public static int contaiFlag_TRANSP = 27;
	
	public static int code_DELIVTERMS_TRANSP = 28;
	public static int place_DELIVTERMS_TRANSP = 29;
	
	public static int identity_BORDERINFO_MEANTRANSP_TRANSP = 30;
	public static int nationality_BORDERINFO_MEANTRANSP_TRANSP = 31;
	
	public static int currCode_GSINVOICE_VALU = 32;
	public static int amountForegCurr_GSINVOICE_VALU = 33;
	public static int currRate_GSINVOICE_VALU = 34;
	
	public static int rateAdjst_VALITEM_TAX_ITEM = 35;
	
	public static int calcWorkMode_VAL = 36;
	
	public static int mode_BORDERINFO_MEANTRANSP_TRANSP = 37;
	
	public static int inlandModeTransp_MEANTRANSP_TRANSP = 38;
	
	public static int code_BORDEROFFIC_TRANSP = 41;
	
	public static int rateAdjust_VALITEM_ITEM = 42;
	
	public static int statisVal_VALITEM_ITEM = 43;
	
	public static int modePaym_FINANC = 44;
	
	public static int declarReprestative_DECLAR = 45;
	*/
	
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
		
		listGenInfoColsName.add("");
		
		listGenInfoColsName.add("countrFirstDest_COUNTR_GENERINFO");
		listGenInfoColsName.add("tradingCountr_COUNTR_GENERINFO");
		
		listGenInfoColsName.add("valueDetails_GENERINFO");
		
		listGenInfoColsName.add("");
		
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
		listGenInfoColsName.add("currRate_GSINVOICE_VALU");
		
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
