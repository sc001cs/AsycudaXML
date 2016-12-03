package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.financial_childs.Amounts;
import enitity.asycuda.financial_childs.Bank;
import enitity.asycuda.financial_childs.FinancialTransaction;
import enitity.asycuda.financial_childs.Guarantee;
import enitity.asycuda.financial_childs.Terms;

public class Financial {

	private FinancialTransaction Financial_transaction;
	private Bank Bank;
	private Terms Terms;
	private String Total_invoice;
	private String Deffered_payment_reference;
	private String Mode_of_payment;
	private Amounts Amounts;
	private Guarantee Guarantee;
	
	public FinancialTransaction getFinancial_transaction() {
		return Financial_transaction;
	}
	@XmlElement(nillable = true, name = "Financial_transaction")
	public void setFinancial_transaction(FinancialTransaction financial_transaction) {
		Financial_transaction = financial_transaction;
	}
	public Bank getBank() {
		return Bank;
	}
	@XmlElement(nillable = true, name = "Bank")
	public void setBank(Bank bank) {
		Bank = bank;
	}
	public Terms getTerms() {
		return Terms;
	}
	@XmlElement(nillable = true, name = "Terms")
	public void setTerms(Terms terms) {
		Terms = terms;
	}
	public String getTotal_invoice() {
		return Total_invoice;
	}
	@XmlElement(nillable = true, name = "Total_invoice")
	public void setTotal_invoice(String total_invoice) {
		Total_invoice = total_invoice;
	}
	public String getDeffered_payment_reference() {
		return Deffered_payment_reference;
	}
	@XmlElement(nillable = true, name = "Deffered_payment_reference")
	public void setDeffered_payment_reference(String deffered_payment_reference) {
		Deffered_payment_reference = deffered_payment_reference;
	}
	public String getMode_of_payment() {
		return Mode_of_payment;
	}
	@XmlElement(nillable = true, name = "Mode_of_payment")
	public void setMode_of_payment(String mode_of_payment) {
		Mode_of_payment = mode_of_payment;
	}
	public Amounts getAmounts() {
		return Amounts;
	}
	@XmlElement(nillable = true, name = "Amounts")
	public void setAmounts(Amounts amounts) {
		Amounts = amounts;
	}
	public Guarantee getGuarantee() {
		return Guarantee;
	}
	@XmlElement(nillable = true, name = "Guarantee")
	public void setGuarantee(Guarantee guarantee) {
		Guarantee = guarantee;
	}
	
	
}
