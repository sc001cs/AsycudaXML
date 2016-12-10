package logic.elaboration;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;

import configuration.ConfigFileExcel;
import enitity.Asycuda;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.ValuationItem;
import enitity.asycuda.identification_childs.Type;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.WeightItm;
import logic.ExcelPoi;
import logic.GetCurrencyAndAmount;

public class ListItemElaborate {

	ListItemValidation itemValid = new ListItemValidation();
	ConfigFileExcel confFileExcel = new ConfigFileExcel();
	GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
	
	/**
	 * @param row
	 * @return Packages ItemChilds
	 */
	public Packages getPackagesItemChilds(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int numbPackages_PACK_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "numbPackages_PACK_ITEM");
		int kindPackCode_PACK_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "kindPackCode_PACK_ITEM");
		int kindPackName_PACK_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "kindPackName_PACK_ITEM");

		String numbPackages_PACK_ITEM_String = ExcelPoi.getString(row, numbPackages_PACK_ITEM);
		String kindPackCode_PACK_ITEM_String = ExcelPoi.getString(row, kindPackCode_PACK_ITEM);
		String kindPackName_PACK_ITEM_String = ExcelPoi.getString(row, kindPackName_PACK_ITEM);

		Packages pack = new Packages();
		pack.setNumber_of_packages(numbPackages_PACK_ITEM_String);
		pack.setKind_of_packages_code(kindPackCode_PACK_ITEM_String);
		
		if(kindPackCode_PACK_ITEM_String != null 
				&& kindPackCode_PACK_ITEM_String.equals("52"))
			pack.setKind_of_packages_name("Arka derrase");
		else
			pack.setKind_of_packages_name(kindPackName_PACK_ITEM_String);

		pack.setMarks1_of_packages("null");
		pack.setMarks2_of_packages("null");

		itemValid.validTypeIdentificationChilds(pack, hmListItemColsNameAndPosit);

		return pack;
	}
	
	/**
	 * @param row
	 * @return GoodsDescription ItemChilds
	 */
	public GoodsDescription getGoodsDescription(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int descrGoods_GOODDESCR_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "descrGoods_GOODDESCR_TARIF_ITEM");
		int commDescr_GOODDESCR_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "commDescr_GOODDESCR_TARIF_ITEM");
		int countrOrigCode_GOODDESCR_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "countrOrigCode_GOODDESCR_TARIF_ITEM");

		String descrGoods_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, descrGoods_GOODDESCR_TARIF_ITEM);
		String commDescr_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, commDescr_GOODDESCR_TARIF_ITEM);
		String countrOrigCode_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, countrOrigCode_GOODDESCR_TARIF_ITEM);

		GoodsDescription gDescr = new GoodsDescription();
		gDescr.setCountry_of_origin_code(countrOrigCode_GOODDESCR_TARIF_ITEM_String);
		gDescr.setDescription_of_goods(descrGoods_GOODDESCR_TARIF_ITEM_String);
		gDescr.setCommercial_Description(commDescr_GOODDESCR_TARIF_ITEM_String);

		itemValid.validGoodsDescription(gDescr, hmListItemColsNameAndPosit);

		return gDescr;
	}
	
	/**
	 * @param row
	 * @return HScode TarificItemChilds
	 */
	public HScode getHScodeTarificItemChilds(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int commCode_HSCODE_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "commCode_HSCODE_TARIF_ITEM");
		int prec1_HSCODE_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "prec1_HSCODE_TARIF_ITEM");

		String prec1_HSCODE_TARIF_ITEM_String = ExcelPoi.getString(row, prec1_HSCODE_TARIF_ITEM);
		String commCode_HSCODE_TARIF_ITEMString = ExcelPoi.getString(row, commCode_HSCODE_TARIF_ITEM);

		HScode hsCode = new HScode();
		hsCode.setCommodity_code(commCode_HSCODE_TARIF_ITEMString);
		hsCode.setPrecision_1(prec1_HSCODE_TARIF_ITEM_String);
		hsCode.setPrecision_2("null");
		hsCode.setPrecision_3("null");

		itemValid.validHScodeTarificItemChilds(hsCode, hmListItemColsNameAndPosit);

		return hsCode;
	}
	
	/**
	 * @param row
	 * @return WeightItm ItemChilds
	 */
	public WeightItm getWeightItmItemChilds(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int grossWeightItm_WEIGHTITM_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "grossWeightItm_WEIGHTITM_VALITEM_ITEM");
		int netWeightItm_WEIGHTITM_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Net_weight_itm_WEIGHTITM_VALITEM_ITEM");

		String grossWeightItm_WEIGHTITM_VALITEM_ITEM_String = ExcelPoi.getString(row, grossWeightItm_WEIGHTITM_VALITEM_ITEM);
		String netWeightItm_WEIGHTITM_VALITEM_ITEM_String = ExcelPoi.getString(row, netWeightItm_WEIGHTITM_VALITEM_ITEM);

		WeightItm wItm = new WeightItm();
		wItm.setGross_weight_itm(grossWeightItm_WEIGHTITM_VALITEM_ITEM_String);
		wItm.setNet_weight_itm(netWeightItm_WEIGHTITM_VALITEM_ITEM_String);

		itemValid.validWeightItmItemChilds(wItm, hmListItemColsNameAndPosit);

		return wItm;
	}
	
	/**
	 * @param row
	 * @return Tarification ItemChilds
	 */
	public Tarification getTarification(Row row, Tarification tar, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int code_PREF_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "code_PREF_TARIF_ITEM");
		int msProc_EXTCUSTOM_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "msProc_EXTCUSTOM_TARIF_ITEM");
		int natCustomProc_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "natCustomProc_TARIF_ITEM");
		int itemPrice_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "itemPrice_TARIF_ITEM");
		int valItm_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "valItm_TARIF_ITEM");
		int Attached_doc_item = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Attached_doc_item");
		
		String code_PREF_TARIF_ITEM_String = ExcelPoi.getString(row, code_PREF_TARIF_ITEM);
		String msProc_EXTCUSTOM_TARIF_ITEM_String = ExcelPoi.getString(row, msProc_EXTCUSTOM_TARIF_ITEM);
		String natCustomProc_TARIF_ITEM_String = ExcelPoi.getString(row, natCustomProc_TARIF_ITEM);
		String itemPrice_TARIF_ITEM_String = ExcelPoi.getString(row, itemPrice_TARIF_ITEM);
		String valItm_TARIF_ITEM_String = ExcelPoi.getString(row, valItm_TARIF_ITEM);
		String Attached_doc_item_String = ExcelPoi.getString(row, Attached_doc_item);
		
		tar.setPreference_code(code_PREF_TARIF_ITEM_String);
		tar.setExtended_customs_procedure(msProc_EXTCUSTOM_TARIF_ITEM_String);
		tar.setNational_customs_procedure(natCustomProc_TARIF_ITEM_String);

		tar.setItem_price(itemPrice_TARIF_ITEM_String);
		tar.setValuation_method_code("null");
		tar.setValue_item(valItm_TARIF_ITEM_String);
		tar.setAttached_doc_item(Attached_doc_item_String);
		tar.setAI_code("null");
		
		itemValid.validTarification(tar, hmListItemColsNameAndPosit);

		return tar;
	}
	
	/**
	 * @param row
	 * @return PreviousDoc 
	 */
	public PreviousDoc getPreviousDoc(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int prevDocRef_PREVDOC_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "prevDocRef_PREVDOC_ITEM");

		String prevDocRef_PREVDOC_ITEM_String = ExcelPoi.getString(row, prevDocRef_PREVDOC_ITEM);

		PreviousDoc pDoc = new PreviousDoc();
		pDoc.setSummary_declaration("null");
		pDoc.setSummary_declaration_sl("null");
		pDoc.setPrevious_document_reference(prevDocRef_PREVDOC_ITEM_String);
		pDoc.setPrevious_warehouse_code("null");

		itemValid.validPreviousDoc(pDoc, hmListItemColsNameAndPosit);

		return pDoc;
	}

	
	
	/**
	 * @param row
	 * @return Statistical_value Total_CIF_itm Rate_of_adjustement
	 */
	public ValuationItem getSetTotals(Row row, ValuationItem vItem, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Rate_of_adjustement_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Rate_of_adjustement_VALITEM_ITEM");
		
		String Rate_of_adjustement_VALITEM_ITEM_String = ExcelPoi.getString(row, Rate_of_adjustement_VALITEM_ITEM);
		
		BigDecimal totCIFitm = BigDecimal.ZERO;
		BigDecimal statistValue = BigDecimal.ZERO;
		
		if(vItem.getItem_Invoice() != null
				&& vItem.getItem_Invoice().getAmount_national_currency() != null)
			totCIFitm = totCIFitm.add(vItem.getItem_Invoice().getAmount_national_currency());
		
		if(vItem.getItem_external_freight() != null
				&& vItem.getItem_external_freight().getAmount_national_currency() != null) {
			totCIFitm = totCIFitm.add(vItem.getItem_external_freight().getAmount_national_currency());
			vItem.setTotal_cost_itm(vItem.getItem_external_freight().getAmount_national_currency());
		}
		
		if(vItem.getItem_internal_freight() != null
				&& vItem.getItem_internal_freight().getAmount_national_currency() != null)
			totCIFitm = totCIFitm.add(vItem.getItem_internal_freight().getAmount_national_currency());
		
		if(vItem.getItem_insurance() != null
				&& vItem.getItem_insurance().getAmount_national_currency() != null)
			totCIFitm = totCIFitm.add(vItem.getItem_insurance().getAmount_national_currency());
		
		if(vItem.getItem_other_cost() != null
				&& vItem.getItem_other_cost().getAmount_national_currency() != null)
			totCIFitm = totCIFitm.add(vItem.getItem_other_cost().getAmount_national_currency());
		
		if(vItem.getItem_deduction() != null
				&& vItem.getItem_deduction().getAmount_national_currency() != null)
			totCIFitm = totCIFitm.add(vItem.getItem_deduction().getAmount_national_currency());
		
		
		
		vItem.setRate_of_adjustement(Rate_of_adjustement_VALITEM_ITEM_String);
		
		statistValue = totCIFitm;
		vItem.setStatistical_value(statistValue);
		vItem.setTotal_CIF_itm(totCIFitm);
		
		itemValid.validSetTotals(vItem, hmListItemColsNameAndPosit);

		return vItem;
	}
	
}
