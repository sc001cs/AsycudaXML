package logic.elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListItemsPositionCell {

	/*
	private static int numbPackages_PACK_ITEM = 43;

	private static int kindPackCode_PACK_ITEM = 44;
	private static int kindPackName_PACK_ITEM = 45;

	private static int descrGoods_GOODDESCR_TARIF_ITEM = 46;

	private static int commDescr_GOODDESCR_TARIF_ITEM = 47;

	private static int totNumbItems_NBERS_PROP = 48;

	private static int commCode_HSCODE_TARIF_ITEM = 49;

	private static int prec1_HSCODE_TARIF_ITEM = 50;

	private static int countrOrigCode_GOODDESCR_TARIF_ITEM = 51;

	private static int grossWeightItm_WEIGHTITM_VALITEM_ITEM = 52;

	private static int code_PREF_TARIF_ITEM = 53;

	private static int msProc_EXTCUSTOM_TARIF_ITEM = 54;

	private static int natCustomProc_TARIF_ITEM = 55;

	private static int netWeightItm_WEIGHTITM_VALITEM_ITEM = 56;

	private static int itemPrice_TARIF_ITEM = 60;

	private static int valItm_TARIF_ITEM = 62;

	private static int prevDocRef_PREVDOC_ITEM = 63;
	*/
	
	public HashMap<Integer, String> hmListItemsColsName() {
		
		List<String> listItemsColsName = new ArrayList<String>();
		
		listItemsColsName.add("numbPackages_PACK_ITEM");
		
		listItemsColsName.add("kindPackCode_PACK_ITEM");
		listItemsColsName.add("kindPackName_PACK_ITEM");
		
		listItemsColsName.add("descrGoods_GOODDESCR_TARIF_ITEM");
		
		listItemsColsName.add("commDescr_GOODDESCR_TARIF_ITEM");
		
		listItemsColsName.add("totNumbItems_NBERS_PROP");
		
		listItemsColsName.add("commCode_HSCODE_TARIF_ITEM");
		
		listItemsColsName.add("prec1_HSCODE_TARIF_ITEM");
		
		listItemsColsName.add("countrOrigCode_GOODDESCR_TARIF_ITEM");
		
		listItemsColsName.add("grossWeightItm_WEIGHTITM_VALITEM_ITEM");
		
		listItemsColsName.add("code_PREF_TARIF_ITEM");
		
		listItemsColsName.add("msProc_EXTCUSTOM_TARIF_ITEM");
		
		listItemsColsName.add("natCustomProc_TARIF_ITEM");
		
		listItemsColsName.add("netWeightItm_WEIGHTITM_VALITEM_ITEM");
		
		listItemsColsName.add("");
		listItemsColsName.add("");
		listItemsColsName.add("");
		
		listItemsColsName.add("itemPrice_TARIF_ITEM");
		
		listItemsColsName.add("");
		
		listItemsColsName.add("valItm_TARIF_ITEM");
		
		listItemsColsName.add("prevDocRef_PREVDOC_ITEM");
		
		HashMap<Integer, String> hmCollectionCosName = new HashMap<Integer, String>();
		
		int count = 0;
		for (String colName : listItemsColsName) {
			hmCollectionCosName.put(count, colName);
			count++;
		}
		
		return hmCollectionCosName;
	}
	
}
