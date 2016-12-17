package logic.elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.desktop.DesktopController;
import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import configuration.xml.ConfigXML;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.ValuationItem;
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
import logic.ConvertIntToLetter;
import logic.ExcelPoi;
import multi_item.GeneralInfoExcel;
import multi_item.ListItemsExcel;

public class ListItemValidation {

	public ConfigFileExcel confFileExcel = new ConfigFileExcel();
	ConfigXML confXML = confFileExcel.getConfigXML();
	ConvertIntToLetter intToLetter = new ConvertIntToLetter();
	
	ListItemsPositionCell listItemsPosCellClass = new ListItemsPositionCell();
	HashMap<Integer, String> hmListItemsColsNameAndPositClass = listItemsPosCellClass.hmListItemsColsName();

	public void validTypeIdentificationChilds(Packages pack) {

		if(pack.getNumber_of_packages() == null || 
				pack.getNumber_of_packages().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "numbPackages_PACK_ITEM");
		}

		if(pack.getKind_of_packages_code() == null || 
				pack.getKind_of_packages_code().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "kindPackCode_PACK_ITEM");
		}

		if(pack.getKind_of_packages_name() == null || 
				pack.getKind_of_packages_name().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "kindPackName_PACK_ITEM");
		}
	}

	public void validGoodsDescription(GoodsDescription gDescr) {

		if(gDescr.getDescription_of_goods() == null || 
				gDescr.getDescription_of_goods().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "descrGoods_GOODDESCR_TARIF_ITEM");
		}

		if(gDescr.getCommercial_Description() == null || 
				gDescr.getCommercial_Description().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "commDescr_GOODDESCR_TARIF_ITEM");
		}

		if(gDescr.getCountry_of_origin_code() == null || 
				gDescr.getCountry_of_origin_code().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "countrOrigCode_GOODDESCR_TARIF_ITEM");
		}
	}

	public void validHScodeTarificItemChilds(HScode hsCode) {

		if(hsCode.getCommodity_code() == null || 
				hsCode.getCommodity_code().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "commCode_HSCODE_TARIF_ITEM");
		}

		if(hsCode.getPrecision_1() == null || 
				hsCode.getPrecision_1().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "prec1_HSCODE_TARIF_ITEM");
		}
	}

	public void validWeightItmItemChilds(WeightItm wItm) {

		if(wItm.getGross_weight_itm() == null || 
				wItm.getGross_weight_itm().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "grossWeightItm_WEIGHTITM_VALITEM_ITEM");
		}

		if(wItm.getNet_weight_itm() == null || 
				wItm.getNet_weight_itm().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Net_weight_itm_WEIGHTITM_VALITEM_ITEM");
		}
	}

	public void validTarification(Tarification tar) {

		if(tar.getPreference_code() == null || 
				tar.getPreference_code().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "code_PREF_TARIF_ITEM");
		}

		if(tar.getExtended_customs_procedure() == null || 
				tar.getExtended_customs_procedure().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "msProc_EXTCUSTOM_TARIF_ITEM");
		}

		if(tar.getNational_customs_procedure() == null || 
				tar.getNational_customs_procedure().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "natCustomProc_TARIF_ITEM");
		}

		if(tar.getItem_price() == null || 
				tar.getItem_price().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "itemPrice_TARIF_ITEM");
		}

		if(tar.getValue_item() == null || 
				tar.getValue_item().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "valItm_TARIF_ITEM");
		}
		
		if(tar.getAttached_doc_item() == null || 
				tar.getAttached_doc_item().equals("")) {

//			System.err.println("***** ERROR *****\n "
//					+ "Please fill out: prevDocRef_PREVDOC_ITEM -- Sheet2 Cell " + 
//					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "prevDocRef_PREVDOC_ITEM"));
		}
		
	}

	public void validPreviousDoc(PreviousDoc pDoc) {

		if(pDoc.getPrevious_document_reference() == null || 
				pDoc.getPrevious_document_reference().equals("")) {

//			System.err.println("***** ERROR *****\n "
//					+ "Please fill out: prevDocRef_PREVDOC_ITEM -- Sheet2 Cell " + 
//					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "prevDocRef_PREVDOC_ITEM"));
		}

	}

	public void validItemInvoiceValChilds(ItemInvoice itmInv) {

		if(itmInv.getAmount_foreign_currency() == null || 
				itmInv.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_Invoice");
		}
	}
	
	public void validItemItemExternalFreightValChilds(ItemExternalFreight itmFreig) {

		if(itmFreig.getAmount_foreign_currency() == null || 
				itmFreig.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_ext_frei");
		}
	}
	
	public void validItemItemInternalFreightValChilds(ItemInternalFreight itmInternalFreig) {

		if(itmInternalFreig.getAmount_foreign_currency() == null || 
				itmInternalFreig.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_inter_frei");
		}
	}
	
	public void validItemInsuranceValChilds(ItemInsurance itmInsur) {

		if(itmInsur.getAmount_foreign_currency() == null || 
				itmInsur.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_ins");
		}
	}
	
	public void validItemOtherCostValChilds(ItemOtherCost itmOthCost) {

		if(itmOthCost.getAmount_foreign_currency() == null || 
				itmOthCost.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_other_cost");
		}
	}
	
	public void validItemOtherCostValChilds(ItemDeduction itmDeduc) {

		if(itmDeduc.getAmount_foreign_currency() == null || 
				itmDeduc.getAmount_foreign_currency().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Amount_foreign_currency_deduc");
		}
	}
	
	public void validSetTotals(ValuationItem vItem) {

		if(vItem.getRate_of_adjustement() == null || 
				vItem.getRate_of_adjustement().equals("")) {
			addNotifMsg(AlertMsg.WARNING, "Rate_of_adjustement_VALITEM_ITEM");
		}

//		if(vItem.getTotal_cost_itm() == null) {
//
//			System.err.println("***** ERROR *****\n "
//					+ "Please fill out: Total_cost_itm_VALITEM_ITEM -- Sheet2 Cell " + 
//					confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "Total_cost_itm_VALITEM_ITEM"));
//		}

	}

	public void addNotifMsg(String typeAlert, String code) {

		int pos = confFileExcel.getKeyByValueHashMap(hmListItemsColsNameAndPositClass, code);
		String descr = ExcelPoi.getString(ListItemsExcel.rowDescrListItem, pos);

		String msg = confXML.getGeneral().getAlertFillOutCell() + descr + confXML.getGeneral().getSheet2() + 
				intToLetter.toAlphabetic(confFileExcel.getKeyByValueHashMap(hmListItemsColsNameAndPositClass, code)) + (ListItemsExcel.ROW+1);

		if(DesktopController.alerts.containsKey(typeAlert)) {
			DesktopController.alerts.get(typeAlert).add(msg);
		} else {
			List<String> listWarning = new ArrayList<String>();
			listWarning.add(msg);
			DesktopController.alerts.put(typeAlert, listWarning);
		}
	}
	
}
