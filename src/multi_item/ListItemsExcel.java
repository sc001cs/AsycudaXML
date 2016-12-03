package multi_item;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import logic.ExcelPoi;
import modules.GetCurrencyAndAmount;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import enitity.Asycuda;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.Taxation;
import enitity.asycuda.ValuationItem;
import enitity.asycuda.item_childs.IncoTerms;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.item_childs.tarification_childs.Quota;
import enitity.asycuda.item_childs.tarification_childs.SupplementaryUnit;
import enitity.asycuda.item_childs.tarification_childs.quota_childs.QuotaItem;
import enitity.asycuda.taxation_childs.TaxationLine;
import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
import enitity.asycuda.valuationItem_childs.MarketValuer;
import enitity.asycuda.valuationItem_childs.WeightItm;

public class ListItemsExcel {

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

	private static int ROW = 3;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] byteExcel = getByteFromFile("C:\\TemplateAsycudaTempMulti.xlsx");

		readValueFormExcel(byteExcel);
	}

	public static byte[] getByteFromFile(String pathExcel) throws IOException {

		Path path = Paths.get(pathExcel);
		byte[] data = Files.readAllBytes(path);

		return data;
	}


	public static Asycuda readValueFormExcel(byte[] byteExcel) throws IOException {

		GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
		String currencyExchange = currency.getCurrencyExchange();

		Sheet sheet = null;
		try {
			Workbook wb = WorkbookFactory.create(new ByteArrayInputStream(byteExcel));
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Row row = sheet.getRow(ROW);

		String numbPackages_PACK_ITEM_String = ExcelPoi.getString(row, numbPackages_PACK_ITEM);

		String kindPackCode_PACK_ITEM_String = ExcelPoi.getString(row, kindPackCode_PACK_ITEM);
		String kindPackName_PACK_ITEM_String = ExcelPoi.getString(row, kindPackName_PACK_ITEM);

		String descrGoods_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, descrGoods_GOODDESCR_TARIF_ITEM);

		String commDescr_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, commDescr_GOODDESCR_TARIF_ITEM);

		String totNumbItems_NBERS_PROP_String = ExcelPoi.getString(row, totNumbItems_NBERS_PROP);

		String prec1_HSCODE_TARIF_ITEM_String = ExcelPoi.getString(row, prec1_HSCODE_TARIF_ITEM);

		String commCode_HSCODE_TARIF_ITEMString = ExcelPoi.getString(row, commCode_HSCODE_TARIF_ITEM);

		String countrOrigCode_GOODDESCR_TARIF_ITEM_String = ExcelPoi.getString(row, countrOrigCode_GOODDESCR_TARIF_ITEM);

		String grossWeightItm_WEIGHTITM_VALITEM_ITEM_String = ExcelPoi.getString(row, grossWeightItm_WEIGHTITM_VALITEM_ITEM);

		String code_PREF_TARIF_ITEM_String = ExcelPoi.getString(row, code_PREF_TARIF_ITEM);

		String msProc_EXTCUSTOM_TARIF_ITEM_String = ExcelPoi.getString(row, msProc_EXTCUSTOM_TARIF_ITEM);

		String natCustomProc_TARIF_ITEM_String = ExcelPoi.getString(row, natCustomProc_TARIF_ITEM);

		String netWeightItm_WEIGHTITM_VALITEM_ITEM_String = ExcelPoi.getString(row, netWeightItm_WEIGHTITM_VALITEM_ITEM);

		String itemPrice_TARIF_ITEM_String = ExcelPoi.getString(row, itemPrice_TARIF_ITEM);

		String valItm_TARIF_ITEM_String = ExcelPoi.getString(row, valItm_TARIF_ITEM);

		String prevDocRef_PREVDOC_ITEM_String = ExcelPoi.getString(row, prevDocRef_PREVDOC_ITEM);

		Asycuda ASYCUDA = new Asycuda();

		Item item = new Item();

		Packages pack = new Packages();
		pack.setNumber_of_packages(numbPackages_PACK_ITEM_String);
		pack.setKind_of_packages_code(kindPackCode_PACK_ITEM_String);
		pack.setKind_of_packages_name(kindPackName_PACK_ITEM_String);

		pack.setMarks1_of_packages("null");
		pack.setMarks2_of_packages("null");
		item.setPackages(pack);

		IncoTerms incoTerm = new IncoTerms();
		//		incoTerm.setCode(code_DELIVTERMS_TRANSP_String);
		//		incoTerm.setPlace(place_DELIVTERMS_TRANSP_String);
		item.setIncoTerms(incoTerm);

		Tarification tar = new Tarification();
		tar.setTarification_data("null");

		HScode hsCode = new HScode();
		hsCode.setCommodity_code(commCode_HSCODE_TARIF_ITEMString);
		hsCode.setPrecision_1(prec1_HSCODE_TARIF_ITEM_String);
		hsCode.setPrecision_2("null");
		hsCode.setPrecision_3("null");
		tar.setHScode(hsCode);

		tar.setPreference_code(code_PREF_TARIF_ITEM_String);
		tar.setExtended_customs_procedure(msProc_EXTCUSTOM_TARIF_ITEM_String);
		tar.setNational_customs_procedure(natCustomProc_TARIF_ITEM_String);

		tar.setQuota_code("null");

		Quota q = new Quota();
		q.setQuotaCode("null");
		q.setQuotaId("null");

		List<QuotaItem> listQuotaItem = new ArrayList<QuotaItem>();
		QuotaItem qItem = new QuotaItem();
		listQuotaItem.add(qItem);
		q.setQuotaItem(listQuotaItem);

		tar.setQuota(q);

		List<SupplementaryUnit> listSuppUn = new ArrayList<SupplementaryUnit>();
		for (int i = 0; i < 3; i++) {

			SupplementaryUnit suppUnit = new SupplementaryUnit();
			suppUnit.setSuppplementary_unit_code("null");

			listSuppUn.add(suppUnit);
		}
		tar.setSupplementary_unit(listSuppUn);

		tar.setItem_price(itemPrice_TARIF_ITEM_String);
		tar.setValuation_method_code("null");
		tar.setValue_item(valItm_TARIF_ITEM_String);
		tar.setAttached_doc_item("null");
		tar.setAI_code("null");

		item.setTarification(tar);

		GoodsDescription gDescr = new GoodsDescription();
		gDescr.setCountry_of_origin_code(countrOrigCode_GOODDESCR_TARIF_ITEM_String);
		gDescr.setDescription_of_goods(descrGoods_GOODDESCR_TARIF_ITEM_String);
		gDescr.setCommercial_Description(commDescr_GOODDESCR_TARIF_ITEM_String);
		item.setGoods_description(gDescr);

		PreviousDoc pDoc = new PreviousDoc();
		pDoc.setSummary_declaration("null");
		pDoc.setSummary_declaration_sl("null");
		pDoc.setPrevious_document_reference(prevDocRef_PREVDOC_ITEM_String);
		pDoc.setPrevious_warehouse_code("null");
		item.setPrevious_doc(pDoc);

		item.setFree_text_1("null");
		item.setFree_text_2("null");

		Taxation tax = new Taxation();
		tax.setItem_taxes_mode_of_payment("null");

		List<TaxationLine> listTaxLine = new ArrayList<TaxationLine>();
		for (int i = 0; i < 8; i++) {
			TaxationLine tLine = new TaxationLine();
			tLine.setDuty_tax_code("null");
			tLine.setDuty_tax_MP("null");
			tLine.setDuty_tax_Type_of_calculation("null");

			listTaxLine.add(tLine);
		}
		tax.setTaxation_line(listTaxLine);

		item.setTaxation(tax);

		ValuationItem vItem = new ValuationItem();

		WeightItm wItm = new WeightItm();
		wItm.setGross_weight_itm(grossWeightItm_WEIGHTITM_VALITEM_ITEM_String);
		wItm.setNet_weight_itm(netWeightItm_WEIGHTITM_VALITEM_ITEM_String);

		List<WeightItm> listWeightItm = new ArrayList<WeightItm>();
		listWeightItm.add(wItm);
		vItem.setWeight_itm(listWeightItm);

		// vete
		vItem.setTotal_cost_itm("0.0");
		//		vItem.setTotal_CIF_itm(calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String));
		//		vItem.setRate_of_adjustement(rateAdjust_VALITEM_ITEM_String);
		//		vItem.setStatistical_value(calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String));

		ItemInvoice itmInv = new ItemInvoice();
		//		itmInv.setAmount_national_currency(calcAmountNationalCurr(amountForegCurr_GSINVOICE_VALU_String, currCode_GSINVOICE_VALU_String));
		//		itmInv.setAmount_foreign_currency(amountForegCurr_GSINVOICE_VALU_String);
		//		itmInv.setCurrency_code(currCode_GSINVOICE_VALU_String);
		//		itmInv.setCurrency_rate(currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange));

		List<ItemInvoice> listItmInv = new ArrayList<ItemInvoice>();
		listItmInv.add(itmInv);
		vItem.setItem_Invoice(listItmInv);

		List<ItemExternalFreight> listItmExtFrei = new ArrayList<ItemExternalFreight>();

		for (int i = 0; i < 2; i++) {

			ItemExternalFreight itmFreig = new ItemExternalFreight();
			itmFreig.setAmount_national_currency("0.0");
			itmFreig.setAmount_foreign_currency("0");
			itmFreig.setCurrency_rate("0.0");
			itmFreig.setCurrency_name("Ska monedhe te huaj");

			listItmExtFrei.add(itmFreig);
		}

		vItem.setItem_external_freight(listItmExtFrei);

		ItemOtherCost itmOthCost = new ItemOtherCost();
		itmOthCost.setAmount_national_currency("0.0");
		//		itmOthCost.setAmount_foreign_currency(amountForegCurr_GSINVOICE_VALU_String);
		//		itmOthCost.setCurrency_rate(currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange));

		List<ItemOtherCost> listItmOthCost = new ArrayList<ItemOtherCost>();
		vItem.setItem_other_cost(listItmOthCost);

		MarketValuer mValue = new MarketValuer();
		mValue.setCurrency_code("null");
		mValue.setBasis_description("null");

		List<MarketValuer> listMarkValue = new ArrayList<MarketValuer>();
		listMarkValue.add(mValue);

		vItem.setMarket_valuer(listMarkValue);

		item.setValuation_item(vItem);

		List<Item> items = new ArrayList<Item>();
		items.add(item);

		ASYCUDA.setItem(items);

		return ASYCUDA;

	}


}
