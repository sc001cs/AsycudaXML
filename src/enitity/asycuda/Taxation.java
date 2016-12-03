package enitity.asycuda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.taxation_childs.TaxationLine;

public class Taxation {

	private String Item_taxes_amount;
	private String Item_taxes_guaranted_amount;
	private String Item_taxes_mode_of_payment;
	private String Counter_of_normal_mode_of_payment;
	private String Displayed_item_taxes_amount;
	private List<TaxationLine> Taxation_line;
	
	public String getItem_taxes_amount() {
		return Item_taxes_amount;
	}
	@XmlElement(nillable = true, name = "Item_taxes_amount")
	public void setItem_taxes_amount(String item_taxes_amount) {
		Item_taxes_amount = item_taxes_amount;
	}
	public String getItem_taxes_guaranted_amount() {
		return Item_taxes_guaranted_amount;
	}
	@XmlElement(nillable = true, name = "Item_taxes_guaranted_amount")
	public void setItem_taxes_guaranted_amount(String item_taxes_guaranted_amount) {
		Item_taxes_guaranted_amount = item_taxes_guaranted_amount;
	}
	public String getItem_taxes_mode_of_payment() {
		return Item_taxes_mode_of_payment;
	}
	@XmlElement(nillable = true, name = "Item_taxes_mode_of_payment")
	public void setItem_taxes_mode_of_payment(String item_taxes_mode_of_payment) {
		Item_taxes_mode_of_payment = item_taxes_mode_of_payment;
	}
	public String getCounter_of_normal_mode_of_payment() {
		return Counter_of_normal_mode_of_payment;
	}
	@XmlElement(nillable = true, name = "Counter_of_normal_mode_of_payment")
	public void setCounter_of_normal_mode_of_payment(String counter_of_normal_mode_of_payment) {
		Counter_of_normal_mode_of_payment = counter_of_normal_mode_of_payment;
	}
	public String getDisplayed_item_taxes_amount() {
		return Displayed_item_taxes_amount;
	}
	@XmlElement(nillable = true, name = "Displayed_item_taxes_amount")
	public void setDisplayed_item_taxes_amount(String displayed_item_taxes_amount) {
		Displayed_item_taxes_amount = displayed_item_taxes_amount;
	}
	public List<TaxationLine> getTaxation_line() {
		return Taxation_line;
	}
	@XmlElement(nillable = true, name = "Taxation_line")
	public void setTaxation_line(List<TaxationLine> taxation_line) {
		Taxation_line = taxation_line;
	}
	
	
}
