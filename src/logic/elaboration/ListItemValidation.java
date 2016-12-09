package logic.elaboration;

import java.util.HashMap;

import configuration.ConfigFileExcel;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.ValuationItem;
import enitity.asycuda.identification_childs.Type;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.valuationItem_childs.ItemDeduction;
import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInsurance;
import enitity.asycuda.valuationItem_childs.ItemInternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
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
		
		if(tar.getAttached_doc_item() == null || 
				tar.getAttached_doc_item().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: prevDocRef_PREVDOC_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "prevDocRef_PREVDOC_ITEM"));
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
					+ "Please fill out: Amount_foreign_currency_Invoice -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_Invoice"));
		}

	}
	
	public void validItemItemExternalFreightValChilds(ItemExternalFreight itmFreig, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmFreig.getAmount_foreign_currency() == null || 
				itmFreig.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Amount_foreign_currency_ext_frei -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_ext_frei"));
		}

	}
	
	public void validItemItemInternalFreightValChilds(ItemInternalFreight itmInternalFreig, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmInternalFreig.getAmount_foreign_currency() == null || 
				itmInternalFreig.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Amount_foreign_currency_inter_frei -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_inter_frei"));
		}

	}
	
	public void validItemInsuranceValChilds(ItemInsurance itmInsur, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmInsur.getAmount_foreign_currency() == null || 
				itmInsur.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Amount_foreign_currency_ins -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_ins"));
		}

	}
	
	public void validItemOtherCostValChilds(ItemOtherCost itmOthCost, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmOthCost.getAmount_foreign_currency() == null || 
				itmOthCost.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Amount_foreign_currency_other_cost -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_other_cost"));
		}

	}
	
	public void validItemOtherCostValChilds(ItemDeduction itmDeduc, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(itmDeduc.getAmount_foreign_currency() == null || 
				itmDeduc.getAmount_foreign_currency().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Amount_foreign_currency_deduc -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Amount_foreign_currency_deduc"));
		}

	}
	
	public void validSetTotals(ValuationItem vItem, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		if(vItem.getRate_of_adjustement() == null || 
				vItem.getRate_of_adjustement().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Rate_of_adjustement_VALITEM_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Rate_of_adjustement_VALITEM_ITEM"));
		}

		if(vItem.getTotal_cost_itm() == null) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: Total_cost_itm_VALITEM_ITEM -- Sheet2 Cell " + 
					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Total_cost_itm_VALITEM_ITEM"));
		}

	}

}
