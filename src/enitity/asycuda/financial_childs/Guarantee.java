package enitity.asycuda.financial_childs;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.financial_childs.guarantee_childs.ExcludedCountry;

public class Guarantee {

	private String Name;
	private String Amount;
	private Date Date;
	private ExcludedCountry Excluded_country;
	
	public String getName() {
		return Name;
	}
	@XmlElement(nillable = true, name = "Name")
	public void setName(String name) {
		Name = name;
	}
	public String getAmount() {
		return Amount;
	}
	@XmlElement(nillable = true, name = "Amount")
	public void setAmount(String amount) {
		Amount = amount;
	}
	public Date getDate() {
		return Date;
	}
	@XmlElement(nillable = true, name = "Date")
	public void setDate(Date date) {
		Date = date;
	}
	public ExcludedCountry getExcluded_country() {
		return Excluded_country;
	}
	@XmlElement(nillable = true, name = "Excluded_country")
	public void setExcluded_country(ExcludedCountry excluded_country) {
		Excluded_country = excluded_country;
	}
	
	
}
