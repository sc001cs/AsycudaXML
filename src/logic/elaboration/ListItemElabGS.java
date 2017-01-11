package logic.elaboration;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;

import configuration.ConfigFileExcel;
import enitity.Asycuda;
import enitity.asycuda.valuationItem_childs.ItemDeduction;
import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInsurance;
import enitity.asycuda.valuationItem_childs.ItemInternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
import logic.ExcelPoi;
import logic.GetCurrencyAndAmount;

public class ListItemElabGS {
	
	ListItemValidation itemValid = new ListItemValidation();
	ConfigFileExcel confFileExcel = new ConfigFileExcel();
	GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
	
	/**
	 * @param row
	 * @return ItemInvoice Valutation Childs 
	 */
	public ItemInvoice getItemInvoiceValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_Invoice = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_Invoice");
		int Currency_code_Invoice = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_Invoice");

		String Amount_foreign_currency_Invoice_String = ExcelPoi.getString(row, Amount_foreign_currency_Invoice);
		String Currency_code_Invoice_String = ExcelPoi.getString(row, Currency_code_Invoice);
		
		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(asycuda.getValuation() != null 
				&& asycuda.getValuation().getGs_Invoice() != null 
				&& (Currency_code_Invoice_String == null 
				|| Currency_code_Invoice_String.equals("")) ) {
			Currency_code_Invoice_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		}
			
		ItemInvoice itmInv = new ItemInvoice();
		itmInv.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_Invoice_String == null || Amount_foreign_currency_Invoice_String.equals(""))
			itmInv.setAmount_foreign_currency("0");
		else
			itmInv.setAmount_foreign_currency(Amount_foreign_currency_Invoice_String);

		itmInv.setCurrency_code(Currency_code_Invoice_String);	
		
		itmInv.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_Invoice_String, Currency_code_Invoice_String, currencyExchange));
		itmInv.setCurrency_rate(currency.getCurrency(Currency_code_Invoice_String, currencyExchange));	

		itemValid.validItemInvoiceValChilds(itmInv);

		return itmInv;
	}
	
	/**
	 * @param row
	 * @return ItemExternalFreight Valutation Childs 
	 */
	public ItemExternalFreight getItemItemExternalFreightValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_ext_frei = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_ext_frei");
		int Currency_code_ext_frei = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_ext_frei");

		String Amount_foreign_currency_ext_frei_String = ExcelPoi.getString(row, Amount_foreign_currency_ext_frei);
		String Currency_code_ext_frei_String = ExcelPoi.getString(row, Currency_code_ext_frei);
		
		ItemExternalFreight itmFreig = new ItemExternalFreight();
		itmFreig.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_ext_frei_String == null || Amount_foreign_currency_ext_frei_String.equals("")) {
			Amount_foreign_currency_ext_frei_String = "0"; 
			itmFreig.setAmount_foreign_currency(Amount_foreign_currency_ext_frei_String);
			
			itmFreig.setAmount_national_currency(BigDecimal.ZERO);
			
			return itmFreig;
		} else
			itmFreig.setAmount_foreign_currency(Amount_foreign_currency_ext_frei_String);

		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(Currency_code_ext_frei_String == null || Currency_code_ext_frei_String.equals(""))
			Currency_code_ext_frei_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		
		itmFreig.setCurrency_code(Currency_code_ext_frei_String);	
		itmFreig.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_ext_frei_String, Currency_code_ext_frei_String, currencyExchange));

		itmFreig.setCurrency_rate(currency.getCurrency(Currency_code_ext_frei_String, currencyExchange));	

		itemValid.validItemItemExternalFreightValChilds(itmFreig);

		return itmFreig;
	}
	
	
	/**
	 * @param row
	 * @return ItemInternalFreight Valutation Childs 
	 */
	public ItemInternalFreight getItemItemInternalFreightValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_inter_frei = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_inter_frei", true);
		int Currency_code_inter_frei = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_inter_frei", true);

		String Amount_foreign_currency_inter_frei_String = ExcelPoi.getString(row, Amount_foreign_currency_inter_frei);
		String Currency_code_inter_frei_String = ExcelPoi.getString(row, Currency_code_inter_frei);
		
		ItemInternalFreight itmInternalFreig = new ItemInternalFreight();
		itmInternalFreig.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_inter_frei_String == null || Amount_foreign_currency_inter_frei_String.equals("")) {
			Amount_foreign_currency_inter_frei_String = "0.0"; 
			itmInternalFreig.setAmount_foreign_currency(Amount_foreign_currency_inter_frei_String);
			
			itmInternalFreig.setAmount_national_currency(BigDecimal.ZERO);
			itmInternalFreig.setCurrency_rate("0.0");
			
			return itmInternalFreig;
		} else
			itmInternalFreig.setAmount_foreign_currency(Amount_foreign_currency_inter_frei_String);

		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(Currency_code_inter_frei_String == null || Currency_code_inter_frei_String.equals(""))
			Currency_code_inter_frei_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		
		itmInternalFreig.setCurrency_code(Currency_code_inter_frei_String);	
		itmInternalFreig.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_inter_frei_String, Currency_code_inter_frei_String, currencyExchange));

		itmInternalFreig.setCurrency_rate(currency.getCurrency(Currency_code_inter_frei_String, currencyExchange));	

		itemValid.validItemItemInternalFreightValChilds(itmInternalFreig);

		return itmInternalFreig;
	}
	
	/**
	 * @param row
	 * @return ItemInsurance Valutation Childs 
	 */
	public ItemInsurance getItemItemInsuranceValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_ins = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_ins", true);
		int Currency_code_ins = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_ins", true);

		String Amount_foreign_currency_ins_String = ExcelPoi.getString(row, Amount_foreign_currency_ins);
		String Currency_code_ins_String = ExcelPoi.getString(row, Currency_code_ins);

		ItemInsurance itmInsur = new ItemInsurance();
		itmInsur.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_ins_String == null || Amount_foreign_currency_ins_String.equals("")) {
			Amount_foreign_currency_ins_String = "0.0"; 
			itmInsur.setAmount_foreign_currency(Amount_foreign_currency_ins_String);
			
			itmInsur.setAmount_national_currency(BigDecimal.ZERO);
			itmInsur.setCurrency_rate("0.0");
			
			return itmInsur;
		} else
			itmInsur.setAmount_foreign_currency(Amount_foreign_currency_ins_String);

		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(Currency_code_ins_String == null || Currency_code_ins_String.equals(""))
			Currency_code_ins_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		
		itmInsur.setCurrency_code(Currency_code_ins_String);	
		itmInsur.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_ins_String, Currency_code_ins_String, currencyExchange));

		itmInsur.setCurrency_rate(currency.getCurrency(Currency_code_ins_String, currencyExchange));	

		itemValid.validItemInsuranceValChilds(itmInsur);

		return itmInsur;
	}
	
	/**
	 * @param row
	 * @return ItemInsurance Valutation Childs 
	 */
	public ItemOtherCost getItemOtherCostValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_other_cost = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_other_cost", true);
		int Currency_code_other_cost = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_other_cost", true);

		String Amount_foreign_currency_other_cost_String = ExcelPoi.getString(row, Amount_foreign_currency_other_cost);
		String Currency_code_other_cost_String = ExcelPoi.getString(row, Currency_code_other_cost);

		ItemOtherCost itmOthCost = new ItemOtherCost();
		itmOthCost.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_other_cost_String == null || Amount_foreign_currency_other_cost_String.equals("")) {
			Amount_foreign_currency_other_cost_String = "0.0"; 
			itmOthCost.setAmount_foreign_currency(Amount_foreign_currency_other_cost_String);
			
			itmOthCost.setAmount_national_currency(BigDecimal.ZERO);
			itmOthCost.setCurrency_rate("0.0");
			
			return itmOthCost;
		} else
			itmOthCost.setAmount_foreign_currency(Amount_foreign_currency_other_cost_String);

		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(Currency_code_other_cost_String == null || Currency_code_other_cost_String.equals(""))
			Currency_code_other_cost_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		
		itmOthCost.setCurrency_code(Currency_code_other_cost_String);	
		itmOthCost.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_other_cost_String, Currency_code_other_cost_String, currencyExchange));

		itmOthCost.setCurrency_rate(currency.getCurrency(Currency_code_other_cost_String, currencyExchange));	

		itemValid.validItemOtherCostValChilds(itmOthCost);

		return itmOthCost;
	}
	
	/**
	 * @param row
	 * @return ItemDeduction Valutation Childs 
	 */
	public ItemDeduction getItemDeductionValChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmListItemColsNameAndPosit) {

		int Amount_foreign_currency_deduc = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Amount_foreign_currency_deduc", true);
		int Currency_code_deduc = confFileExcel.getKeyByValueHashMap(hmListItemColsNameAndPosit, "Currency_code_deduc", true);

		String Amount_foreign_currency_deduc_String = ExcelPoi.getString(row, Amount_foreign_currency_deduc);
		String Currency_code_deduc_String = ExcelPoi.getString(row, Currency_code_deduc);

		ItemDeduction itmDeduc = new ItemDeduction();
		itmDeduc.setCurrency_name("Ska monedhe te huaj");
		
		if(Amount_foreign_currency_deduc_String == null || Amount_foreign_currency_deduc_String.equals("")) {
			Amount_foreign_currency_deduc_String = "0.0"; 
			itmDeduc.setAmount_foreign_currency(Amount_foreign_currency_deduc_String);
			
			itmDeduc.setAmount_national_currency(BigDecimal.ZERO);
			itmDeduc.setCurrency_rate("0.0");
			
			return itmDeduc;
		} else
			itmDeduc.setAmount_foreign_currency(Currency_code_deduc_String);

		/* Check if the currency is set, if not get the currency from first page
		 * */
		if(Currency_code_deduc_String == null || Currency_code_deduc_String.equals(""))
			Currency_code_deduc_String = asycuda.getValuation().getGs_Invoice().getCurrency_code();
		
		itmDeduc.setCurrency_code(Amount_foreign_currency_deduc_String);	
		itmDeduc.setAmount_national_currency(currency.calcAmountNationalCurr(Amount_foreign_currency_deduc_String, Currency_code_deduc_String, currencyExchange));

		itmDeduc.setCurrency_rate(currency.getCurrency(Currency_code_deduc_String, currencyExchange));	

		itemValid.validItemOtherCostValChilds(itmDeduc);

		return itmDeduc;
	}
	
	
	
}
