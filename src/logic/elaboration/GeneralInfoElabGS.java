package logic.elaboration;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;

import configuration.ConfigFileExcel;
import enitity.Asycuda;
import enitity.asycuda.Item;
import enitity.asycuda.valuation_childs.GsDeduction;
import enitity.asycuda.valuation_childs.GsExternalFreight;
import enitity.asycuda.valuation_childs.GsInsurance;
import enitity.asycuda.valuation_childs.GsInternalFreight;
import enitity.asycuda.valuation_childs.GsInvoice;
import enitity.asycuda.valuation_childs.GsOtherCost;
import logic.ExcelPoi;
import logic.GetCurrencyAndAmount;

public class GeneralInfoElabGS {

	GeneralInfoValidation genInfoValid = new GeneralInfoValidation();
	ConfigFileExcel confFileExcel = new ConfigFileExcel();
	GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
	
	/**
	 * @param row
	 * @return GsInvoice ValuationChilds
	 */ 
	public GsInvoice getValueGsInvoiceValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		int amountForegCurr_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "amountForegCurr_GSINVOICE_VALU");
		//int currRate_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currRate_GSINVOICE_VALU");

		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);
		String amountForegCurr_GSINVOICE_VALU_String = ExcelPoi.getString(row, amountForegCurr_GSINVOICE_VALU);
	//	String currRate_GSINVOICE_VALU_String = ExcelPoi.getString(row, currRate_GSINVOICE_VALU);

		GsInvoice gsInv = new GsInvoice();
		gsInv.setCurrency_code(currCode_GSINVOICE_VALU_String);
		// kot
		gsInv.setCurrency_name("Ska monedhe te huaj");
		gsInv.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
		

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_Invoice() != null 
						&& item.getValuation_item().getItem_Invoice().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_Invoice().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_Invoice() != null 
						&& item.getValuation_item().getItem_Invoice().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_Invoice().getAmount_national_currency());
				
			}
		}

		gsInv.setAmount_foreign_currency(sumAmountForeignCurr);
		gsInv.setAmount_national_currency( sumAmounNationalCurr );
		
		genInfoValid.validCellValGsInvoiceValuationChilds(gsInv);

		return gsInv;
	}
	
	/**
	 * @param row
	 * @return GsExternalFreight ValuationChilds
	 */ 
	public GsExternalFreight getValueGsExternalFreiValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);

		GsExternalFreight gsExtFrei = new GsExternalFreight();
		gsExtFrei.setCurrency_name("Ska monedhe te huaj");

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_external_freight() != null 
						&& item.getValuation_item().getItem_external_freight().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_external_freight().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_external_freight() != null 
						&& item.getValuation_item().getItem_external_freight().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_external_freight().getAmount_national_currency());
				
			}
			
			if(sumAmountForeignCurr.compareTo(BigDecimal.ZERO) != 0) {
				gsExtFrei.setCurrency_code(currCode_GSINVOICE_VALU_String);
				gsExtFrei.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
			}
		}

		gsExtFrei.setAmount_foreign_currency(sumAmountForeignCurr);
		gsExtFrei.setAmount_national_currency( sumAmounNationalCurr );
		
		return gsExtFrei;
	}
	
	
	/**
	 * @param row
	 * @return GsInternalFreight ValuationChilds
	 */ 
	public GsInternalFreight getValueGsInternalFreightValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);

		GsInternalFreight gsIntFrei = new GsInternalFreight();
		gsIntFrei.setCurrency_name("Ska monedhe te huaj");

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_internal_freight() != null 
						&& item.getValuation_item().getItem_internal_freight().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_internal_freight().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_internal_freight() != null 
						&& item.getValuation_item().getItem_internal_freight().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_internal_freight().getAmount_national_currency());
				
			}
			
			if(sumAmountForeignCurr.compareTo(BigDecimal.ZERO) != 0) {
				gsIntFrei.setCurrency_code(currCode_GSINVOICE_VALU_String);
				gsIntFrei.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
			}
		}

		gsIntFrei.setAmount_foreign_currency(sumAmountForeignCurr);
		gsIntFrei.setAmount_national_currency( sumAmounNationalCurr );
		
		return gsIntFrei;
	}
	
	/**
	 * @param row
	 * @return GsInsurance ValuationChilds
	 */ 
	public GsInsurance getValueGsInsuranceValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);

		GsInsurance gsIns = new GsInsurance();
		gsIns.setCurrency_name("Ska monedhe te huaj");

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_insurance() != null 
						&& item.getValuation_item().getItem_insurance().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_insurance().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_insurance() != null 
						&& item.getValuation_item().getItem_insurance().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_insurance().getAmount_national_currency());
				
			}
			
			if(sumAmountForeignCurr.compareTo(BigDecimal.ZERO) != 0) {
				gsIns.setCurrency_code(currCode_GSINVOICE_VALU_String);
				gsIns.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
			}
		}

		gsIns.setAmount_foreign_currency(sumAmountForeignCurr);
		gsIns.setAmount_national_currency( sumAmounNationalCurr );
		
		return gsIns;
	}
	
	/**
	 * @param row
	 * @return GsOtherCost ValuationChilds
	 */ 
	public GsOtherCost getValueGsOtherCosteValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);

		GsOtherCost gsOtherCost = new GsOtherCost();
		gsOtherCost.setCurrency_name("Ska monedhe te huaj");

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_other_cost() != null 
						&& item.getValuation_item().getItem_other_cost().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_other_cost().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_other_cost() != null 
						&& item.getValuation_item().getItem_other_cost().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_other_cost().getAmount_national_currency());
				
			}
			
			if(sumAmountForeignCurr.compareTo(BigDecimal.ZERO) != 0) {
				gsOtherCost.setCurrency_code(currCode_GSINVOICE_VALU_String);
				gsOtherCost.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
			}
		}

		gsOtherCost.setAmount_foreign_currency(sumAmountForeignCurr);
		gsOtherCost.setAmount_national_currency( sumAmounNationalCurr );
		
		return gsOtherCost;
	}
	
	/**
	 * @param row
	 * @return GsDeduction ValuationChilds
	 */ 
	public GsDeduction getValueGsDeductionValuationChilds(Row row, Asycuda asycuda, String currencyExchange, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int currCode_GSINVOICE_VALU = confFileExcel.getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "currCode_GSINVOICE_VALU");
		String currCode_GSINVOICE_VALU_String = ExcelPoi.getString(row, currCode_GSINVOICE_VALU);

		GsDeduction gsDed = new GsDeduction();
		gsDed.setCurrency_name("Ska monedhe te huaj");

		BigDecimal sumAmountForeignCurr = BigDecimal.ZERO;
		BigDecimal sumAmounNationalCurr = BigDecimal.ZERO;
		if(asycuda.getItem() != null && asycuda.getItem().size() > 0) {
			for (Item item : asycuda.getItem()) {
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_deduction() != null 
						&& item.getValuation_item().getItem_deduction().getAmount_foreign_currency() != null)
					sumAmountForeignCurr = sumAmountForeignCurr.add(new BigDecimal(item.getValuation_item().getItem_deduction().getAmount_foreign_currency()));
				
				if(item != null 
						&& item.getValuation_item() != null 
						&& item.getValuation_item().getItem_deduction() != null 
						&& item.getValuation_item().getItem_deduction().getAmount_national_currency() != null)
					sumAmounNationalCurr = sumAmounNationalCurr.add(item.getValuation_item().getItem_deduction().getAmount_national_currency());
				
			}
			
			if(sumAmountForeignCurr.compareTo(BigDecimal.ZERO) != 0) {
				gsDed.setCurrency_code(currCode_GSINVOICE_VALU_String);
				gsDed.setCurrency_rate( currency.getCurrency(currCode_GSINVOICE_VALU_String, currencyExchange) );
			}
		}

		gsDed.setAmount_foreign_currency(sumAmountForeignCurr);
		gsDed.setAmount_national_currency( sumAmounNationalCurr );
		
		return gsDed;
	}
	
	
	
	
	
	
	
}
