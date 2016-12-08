package logic.elaboration;

import java.util.HashMap;

import configuration.ConfigFileExcel;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.identification_childs.Type;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.WeightItm;

public class ListItemValidation {

	public ConfigFileExcel confFileExcel = new ConfigFileExcel();
	
	public void validTypeIdentificationChilds(Packages pack, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(pack.getNumber_of_packages() == null || 
				pack.getNumber_of_packages().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: numbPackages_PACK_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "numbPackages_PACK_ITEM"));
		}

		if(pack.getKind_of_packages_code() == null || 
				pack.getKind_of_packages_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: kindPackCode_PACK_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "kindPackCode_PACK_ITEM"));
		}

		if(pack.getKind_of_packages_name() == null || 
				pack.getKind_of_packages_name().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: kindPackName_PACK_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "kindPackName_PACK_ITEM"));
		}
	}
	
	public void validGoodsDescription(GoodsDescription gDescr, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(gDescr.getDescription_of_goods() == null || 
				gDescr.getDescription_of_goods().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: descrGoods_GOODDESCR_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "descrGoods_GOODDESCR_TARIF_ITEM"));
		}

		if(gDescr.getCommercial_Description() == null || 
				gDescr.getCommercial_Description().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: commDescr_GOODDESCR_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "commDescr_GOODDESCR_TARIF_ITEM"));
		}

		if(gDescr.getCountry_of_origin_code() == null || 
				gDescr.getCountry_of_origin_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: countrOrigCode_GOODDESCR_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "countrOrigCode_GOODDESCR_TARIF_ITEM"));
		}
	}
	
	public void validHScodeTarificItemChilds(HScode hsCode, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(hsCode.getCommodity_code() == null || 
				hsCode.getCommodity_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: commCode_HSCODE_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "commCode_HSCODE_TARIF_ITEM"));
		}

		if(hsCode.getPrecision_1() == null || 
				hsCode.getPrecision_1().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: prec1_HSCODE_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "prec1_HSCODE_TARIF_ITEM"));
		}

	}
	
	public void validWeightItmItemChilds(WeightItm wItm, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(wItm.getGross_weight_itm() == null || 
				wItm.getGross_weight_itm().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: grossWeightItm_WEIGHTITM_VALITEM_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "grossWeightItm_WEIGHTITM_VALITEM_ITEM"));
		}

		if(wItm.getNet_weight_itm() == null || 
				wItm.getNet_weight_itm().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: netWeightItm_WEIGHTITM_VALITEM_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Net_weight_itm_WEIGHTITM_VALITEM_ITEM"));
		}

	}
	
	public void validTarification(Tarification tar, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(tar.getPreference_code() == null || 
				tar.getPreference_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: code_PREF_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "code_PREF_TARIF_ITEM"));
		}

		if(tar.getExtended_customs_procedure() == null || 
				tar.getExtended_customs_procedure().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: msProc_EXTCUSTOM_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "msProc_EXTCUSTOM_TARIF_ITEM"));
		}
		
		if(tar.getNational_customs_procedure() == null || 
				tar.getNational_customs_procedure().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: natCustomProc_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "natCustomProc_TARIF_ITEM"));
		}

		
		if(tar.getItem_price() == null || 
				tar.getItem_price().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: itemPrice_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "itemPrice_TARIF_ITEM"));
		}
		
		if(tar.getValue_item() == null || 
				tar.getValue_item().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: valItm_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "valItm_TARIF_ITEM"));
		}
		
	}
	
	public void validPreviousDoc(PreviousDoc pDoc, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(pDoc.getPrevious_document_reference() == null || 
				pDoc.getPrevious_document_reference().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: prevDocRef_PREVDOC_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "prevDocRef_PREVDOC_ITEM"));
		}

	}
	
	public void validItemInvoiceValChilds(ItemInvoice itmInv, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmInv.getAmount_foreign_currency() == null || 
				itmInv.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: itemPrice_TARIF_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "itemPrice_TARIF_ITEM"));
		}

	}
	
	public void validSetTotals(Item item, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(item.getValuation_item().getRate_of_adjustement() == null || 
				item.getValuation_item().getRate_of_adjustement().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Rate_of_adjustement -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Rate_of_adjustement"));
		}

		if(item.getValuation_item().getStatistical_value() == null) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Statistical_value -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Statistical_value"));
		}
		
		if(item.getValuation_item().getTotal_CIF_itm() == null) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Total_CIF_itm -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Total_CIF_itm"));
		}
	}
	
}
