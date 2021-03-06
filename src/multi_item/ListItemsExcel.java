package multi_item;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logic.ExcelPoi;
import logic.elaboration.ListItemElabGS;
import logic.elaboration.ListItemElaborate;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import enitity.Asycuda;
import enitity.asycuda.GoodsDescription;
import enitity.asycuda.Item;
import enitity.asycuda.PreviousDoc;
import enitity.asycuda.Taxation;
import enitity.asycuda.ValuationItem;
import enitity.asycuda.item_childs.AttachedDocuments;
import enitity.asycuda.item_childs.IncoTerms;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;
import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.item_childs.tarification_childs.Quota;
import enitity.asycuda.item_childs.tarification_childs.SupplementaryUnit;
import enitity.asycuda.item_childs.tarification_childs.quota_childs.QuotaItem;
import enitity.asycuda.taxation_childs.TaxationLine;
import enitity.asycuda.valuationItem_childs.ItemDeduction;
import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInsurance;
import enitity.asycuda.valuationItem_childs.ItemInternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
import enitity.asycuda.valuationItem_childs.MarketValuer;
import enitity.asycuda.valuationItem_childs.WeightItm;
import javafx.scene.control.Alert.AlertType;

public class ListItemsExcel {

	ConfigFileExcel confFileExcel = new ConfigFileExcel();
	
	/**
	 * FUSHA PA SPECIFIKIM TE QARTE NE XML DHE EXCEL
	 * PER VERIFIKIM

		private static int totNumbItems_NBERS_PROP = 48;  
	 */

	AlertMsg alertMsg = new AlertMsg();
	public static int ROW_NO_CHANGE = 3;
	public static int ROW = 3;
	public static Row rowDescrListItem = null;

	public Asycuda writeValueListItems(byte[] byteExcel, Asycuda ASYCUDA, String currencyExchangeRoot, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		ListItemElaborate itemElab = new ListItemElaborate();
		ListItemElabGS itemElabGS = new ListItemElabGS();
		String currencyExchange = currencyExchangeRoot;

		Sheet sheet = null;
		try {
			Workbook wb = WorkbookFactory.create(new ByteArrayInputStream(byteExcel));
			sheet = wb.getSheetAt(1);
		} catch (Exception e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Nuk mund te konvertohet workbook ne object \n" + null, ExceptionUtils.getStackTrace(e));
		}

		List<Item> items = new ArrayList<Item>();
		Row row = sheet.getRow(ROW);

		while(checkHasNextRow(row, hmListItemColsNameAndPosit)) {

			Item item = new Item();

			AttachedDocuments attDoc = new AttachedDocuments();
			List<AttachedDocuments> listAttDoc = new ArrayList<AttachedDocuments>();
			listAttDoc.add(attDoc);
			item.setAttached_documents(listAttDoc);

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 0, 1, 2
			 * - numbPackages_PACK_ITEM (mandatory)
			 * - kindPackCode_PACK_ITEM (mandatory)
			 * - kindPackName_PACK_ITEM (mandatory)
			 * */
			Packages pack = itemElab.getPackagesItemChilds(row, hmListItemColsNameAndPosit);

			item.setPackages(pack);

			// Same as Delivery_terms -> code & place
			IncoTerms incoTerm = new IncoTerms();
			if(ASYCUDA.getTransport() != null 
					&& ASYCUDA.getTransport().getDelivery_terms() != null 
					&& ASYCUDA.getTransport().getDelivery_terms().getCode() != null) {
				incoTerm.setCode(ASYCUDA.getTransport().getDelivery_terms().getCode());
			}

			if(ASYCUDA.getTransport() != null 
					&& ASYCUDA.getTransport().getDelivery_terms() != null 
					&& ASYCUDA.getTransport().getDelivery_terms().getPlace() != null) {
				incoTerm.setPlace(ASYCUDA.getTransport().getDelivery_terms().getPlace());
			}

			item.setIncoTerms(incoTerm);

			Tarification tar = new Tarification();
			tar.setTarification_data("null");

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 6, 7
			 * - commCode_HSCODE_TARIF_ITEM (mandatory)
			 * - prec1_HSCODE_TARIF_ITEM (mandatory)
			 * */
			HScode hsCode = itemElab.getHScodeTarificItemChilds(row, hmListItemColsNameAndPosit);

			tar.setHScode(hsCode);

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 10, 11, 12,  17, 19
			 * - code_PREF_TARIF_ITEM (mandatory)
			 * - msProc_EXTCUSTOM_TARIF_ITEM (mandatory)
			 * - natCustomProc_TARIF_ITEM (mandatory)
			 * 
			 * - itemPrice_TARIF_ITEM (mandatory)
			 * - valItm_TARIF_ITEM (mandatory)
			 * */
			tar = itemElab.getTarification(row, tar, hmListItemColsNameAndPosit);

			tar.setQuota_code("null");

			Quota q = new Quota();
			q.setQuotaCode("null");
			q.setQuotaId("null");

			List<QuotaItem> listQuotaItem = new ArrayList<QuotaItem>();
			QuotaItem qItem = new QuotaItem();
			listQuotaItem.add(qItem);
			q.setQuotaItem(listQuotaItem);

			tar.setQuota(q);

			int Suppplementary_unit_code = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Suppplementary_unit_code");
			String Suppplementary_unit_code_String = ExcelPoi.getString(row, Suppplementary_unit_code);
			
			int Suppplementary_unit_quantity = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Suppplementary_unit_quantity");
			String Suppplementary_unit_quantity_String = ExcelPoi.getString(row, Suppplementary_unit_quantity);
			
			SupplementaryUnit suppUnit = new SupplementaryUnit();
			suppUnit.setSuppplementary_unit_code(Suppplementary_unit_code_String);
			suppUnit.setSuppplementary_unit_quantity(Suppplementary_unit_quantity_String);
			
			List<SupplementaryUnit> listSuppUn = new ArrayList<SupplementaryUnit>();
			listSuppUn.add(suppUnit);
			for (int i = 0; i < 2; i++) {

				SupplementaryUnit suppUnit1 = new SupplementaryUnit();
				suppUnit1.setSuppplementary_unit_code("null");

				listSuppUn.add(suppUnit1);
			}
			tar.setSupplementary_unit(listSuppUn);

			item.setTarification(tar);

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 3, 4, 8
			 * - descrGoods_GOODDESCR_TARIF_ITEM (mandatory)
			 * - commDescr_GOODDESCR_TARIF_ITEM (mandatory)
			 * - countrOrigCode_GOODDESCR_TARIF_ITEM (mandatory)
			 * */
			GoodsDescription gDescr = itemElab.getGoodsDescription(row, hmListItemColsNameAndPosit);

			item.setGoods_description(gDescr);

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 20
			 * - prevDocRef_PREVDOC_ITEM (mandatory)
			 * */
			PreviousDoc pDoc = itemElab.getPreviousDoc(row, hmListItemColsNameAndPosit);

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

			/**
			 * SHEET: LIST ITEMS
			 * COLUMNS: 9, 13
			 * - grossWeightItm_WEIGHTITM_VALITEM_ITEM (mandatory)
			 * - netWeightItm_WEIGHTITM_VALITEM_ITEM (mandatory)
			 * */
			WeightItm wItm = itemElab.getWeightItmItemChilds(row, hmListItemColsNameAndPosit);

			vItem.setWeight_itm(wItm);

			ItemInvoice itmInv = itemElabGS.getItemInvoiceValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_Invoice(itmInv);
			 
			ItemExternalFreight itmFreig = itemElabGS.getItemItemExternalFreightValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_external_freight(itmFreig);

			/**
			 * Mandi's notes
			 * Delete those rows
			 * 
			 * */
			ItemInternalFreight itmInternalFreig = itemElabGS.getItemItemInternalFreightValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_internal_freight(itmInternalFreig);

			ItemInsurance itmInsur = itemElabGS.getItemItemInsuranceValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_insurance(itmInsur);

			ItemOtherCost itmOthCost = itemElabGS.getItemOtherCostValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_other_cost(itmOthCost);

			ItemDeduction itmDeduc = itemElabGS.getItemDeductionValChilds(row, ASYCUDA, currencyExchangeRoot, hmListItemColsNameAndPosit);
			vItem.setItem_deduction(itmDeduc);
			
			
			MarketValuer mValue = new MarketValuer();
			mValue.setCurrency_code("null");
			mValue.setBasis_description("null");

			vItem.setMarket_valuer(mValue);

			/** UPDATE VALUATION ITEM WITH:
			 * - Total Cost Item
			 * - Total CIF Item
			 * - Statistical value
			 * */
			vItem = itemElab.getSetTotals(row, vItem, hmListItemColsNameAndPosit);

			item.setValuation_item(vItem);

			
			items.add(item);

			ROW++;
			row = sheet.getRow(ROW);
			rowDescrListItem = sheet.getRow((ROW_NO_CHANGE-1));
		}
		ASYCUDA.setItem(items);
		ROW = ROW_NO_CHANGE;
		return ASYCUDA;

	}

	private Boolean checkHasNextRow(Row row, HashMap<Integer, String> hmListItemColsNameAndPosit) {
		
		ConfigFileExcel confFileExcel = new ConfigFileExcel();
		
		int Amount_foreign_currency_Invoice = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_Invoice");
		String Amount_foreign_currency_Invoice_String = ExcelPoi.getString(row, Amount_foreign_currency_Invoice);
		
		if(Amount_foreign_currency_Invoice_String == null 
				|| Amount_foreign_currency_Invoice_String.equals("0") 
				|| Amount_foreign_currency_Invoice_String.equals("0.0")) {
			return false;
		} else {
			return true;
		}
	}

}
