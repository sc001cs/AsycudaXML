package enitity.asycuda.valuationItem_childs;

import javax.xml.bind.annotation.XmlElement;

public class MarketValuer {

	private String Rate;
	private String Currency_code;
	private String Currency_amount;
	private String Basis_description;
	private String Basis_amount;
	
	public String getRate() {
		return Rate;
	}
	@XmlElement(nillable = true, name = "Rate")
	public void setRate(String rate) {
		Rate = rate;
	}
	public String getCurrency_code() {
		return Currency_code;
	}
	@XmlElement(nillable = true, name = "Currency_code")
	public void setCurrency_code(String currency_code) {
		Currency_code = currency_code;
	}
	public String getCurrency_amount() {
		return Currency_amount;
	}
	@XmlElement(nillable = true, name = "Currency_amount")
	public void setCurrency_amount(String currency_amount) {
		Currency_amount = currency_amount;
	}
	public String getBasis_description() {
		return Basis_description;
	}
	@XmlElement(nillable = true, name = "Basis_description")
	public void setBasis_description(String basis_description) {
		Basis_description = basis_description;
	}
	public String getBasis_amount() {
		return Basis_amount;
	}
	@XmlElement(nillable = true, name = "Basis_amount")
	public void setBasis_amount(String basis_amount) {
		Basis_amount = basis_amount;
	}
	
}
