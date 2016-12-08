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
		
		if(kindPackCode_PACK_ITEM_String.equals("52"))
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
		
		String code_PREF_TARIF_ITEM_String = ExcelPoi.getString(row, code_PREF_TARIF_ITEM);
		String msProc_EXTCUSTOM_TARIF_ITEM_String = ExcelPoi.getString(row, msProc_EXTCUSTOM_TARIF_ITEM);
		String natCustomProc_TARIF_ITEM_String = ExcelPoi.getString(row, natCustomProc_TARIF_ITEM);
		String itemPrice_TARIF_ITEM_String = ExcelPoi.getString(row, itemPrice_TARIF_ITEM);
		String valItm_TARIF_ITEM_String = ExcelPoi.getString(row, valItm_TARIF_ITEM);
		
		tar.setPreference_code(code_PREF_TARIF_ITEM_String);
		tar.setExtended_customs_procedure(msProc_EXTCUSTOM_TARIF_ITEM_String);
		tar.setNational_customs_procedure(natCustomProc_TARIF_ITEM_String);

		tar.setItem_price(itemPrice_TARIF_ITEM_String);
		tar.setValuation_method_code("null");
		tar.setValue_item(valItm_TARIF_ITEM_String);
		tar.setAttached_doc_item("null");
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
	 * @return PreviousDoc 
	 */
	public ValuationItem getTotCostCIFStatistRateItem(Row row, ValuationItem vItem, HashMap<Integer, String> hmListItemColsNameAndPosit) {

//		int Total_cost_itm_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Total_cost_itm_VALITEM_ITEM");
//		int Total_CIF_itm_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "prevDocRef_PREVDOC_ITEM");
//		int Rate_of_adjustement_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Rate_of_adjustement_VALITEM_ITEM");
//		int Statistical_value_VALITEM_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Statistical_value_VALITEM_ITEM");
//
//		String Total_cost_itm_VALITEM_ITEM_String = ExcelPoi.getString(row, Total_cost_itm_VALITEM_ITEM);
//		String Total_CIF_itm_VALITEM_ITEM_String = ExcelPoi.getString(row, Total_CIF_itm_VALITEM_ITEM);
//		String Rate_of_adjustement_VALITEM_ITEM_String = ExcelPoi.getString(row, Rate_of_adjustement_VALITEM_ITEM);
//		String Statistical_value_VALITEM_ITEM_String = ExcelPoi.getString(row, Statistical_value_VALITEM_ITEM);
//
//		vItem.setTotal_cost_itm(Total_cost_itm_VALITEM_ITEM_String);
//		vItem.setTotal_CIF_itm(calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String));
//		vItem.setRate_of_adjustement(Rate_of_adjustement_VALITEM_ITEM_String);
//		vItem.setStatistical_value(calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String));
//
//		itemValid.validPreviousDoc(vItem, hmListItemColsNameAndPosit);

		return vItem;
	}
	
	/**
	 * @param row
	 * @return ItemInvoice Valutation Childs 
	 */
	public ItemInvoice getItemInvoiceValChilds(Row row, Asycuda asycuda, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int itemPrice_TARIF_ITEM = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "itemPrice_TARIF_ITEM");

		String itemPrice_TARIF_ITEM_String = ExcelPoi.getString(row, itemPrice_TARIF_ITEM);

		ItemInvoice itmInv = new ItemInvoice();
		itmInv.setAmount_foreign_currency(itemPrice_TARIF_ITEM_String);
		
		if(asycuda.getValuation() != null 
				&& asycuda.getValuation().getGs_Invoice() != null 
				&& asycuda.getValuation().getGs_Invoice().getCurrency_code() != null) {
			
			itmInv.setCurrency_code(asycuda.getValuation().getGs_Invoice().getCurrency_code());	
			itmInv.setAmount_national_currency(currency.calcAmountNationalCurr(itemPrice_TARIF_ITEM_String, asycuda.getValuation().getGs_Invoice().getCurrency_code()));
		}
		
		if(asycuda.getValuation() != null 
				&& asycuda.getValuation().getGs_Invoice() != null 
				&& asycuda.getValuation().getGs_Invoice().getCurrency_rate() != null) {
			itmInv.setCurrency_rate(asycuda.getValuation().getGs_Invoice().getCurrency_rate());	
		}
		
		itemValid.validItemInvoiceValChilds(itmInv, hmListItemColsNameAndPosit);

		return itmInv;
	}
	
	
	/**
	 * @param row
	 * @return Statistical_value Total_CIF_itm Rate_of_adjustement
	 */
	public Item getSetTotals(Row row, Item item, ValuationItem vItem, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Rate_of_adjustement = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Rate_of_adjustement");
		int Statistical_value = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Statistical_value");
		int Total_CIF_itm = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Total_CIF_itm");

		String Rate_of_adjustement_String = ExcelPoi.getString(row, Rate_of_adjustement);
		String Statistical_value_String = ExcelPoi.getString(row, Statistical_value);
		String Total_CIF_itm_String = ExcelPoi.getString(row, Total_CIF_itm);
		
		item.setValuation_item(vItem);
		
		item.getValuation_item().setRate_of_adjustement(Rate_of_adjustement_String);
		item.getValuation_item().setStatistical_value(new BigDecimal(Statistical_value_String));
		item.getValuation_item().setTotal_CIF_itm(new BigDecimal(Total_CIF_itm_String));
		
		itemValid.validSetTotals(item, hmListItemColsNameAndPosit);

		return item;
	}
	
}
