package enitity.asycuda.valuation_childs;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class GsOtherCost {

	private BigDecimal Amount_national_currency;
	private BigDecimal Amount_foreign_currency;
	private String Currency_code;
	private String Currency_name;
	private String Currency_rate;
	
	public BigDecimal getAmount_national_currency() {
		return Amount_national_currency;
	}
	@XmlElement(nillable = true, name = "Amount_national_currency")
	public void setAmount_national_currency(BigDecimal amount_national_currency) {
		Amount_national_currency = amount_national_currency;
	}
	public BigDecimal getAmount_foreign_currency() {
		return Amount_foreign_currency;
	}
	@XmlElement(nillable = true, name = "Amount_foreign_currency")
	public void setAmount_foreign_currency(BigDecimal amount_foreign_currency) {
		Amount_foreign_currency = amount_foreign_currency;
	}
	public String getCurrency_code() {
		return Currency_code;
	}
	@XmlElement(nillable = true, name = "Currency_code")
	public void setCurrency_code(String currency_code) {
		Currency_code = currency_code;
	}
	public String getCurrency_name() {
		return Currency_name;
	}
	@XmlElement(nillable = true, name = "Currency_name")
	public void setCurrency_name(String currency_name) {
		Currency_name = currency_name;
	}
	public String getCurrency_rate() {
		return Currency_rate;
	}
	@XmlElement(nillable = true, name = "Currency_rate")
	public void setCurrency_rate(String currency_rate) {
		Currency_rate = currency_rate;
	}
	
	
}
