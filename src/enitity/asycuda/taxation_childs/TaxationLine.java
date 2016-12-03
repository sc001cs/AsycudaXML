package enitity.asycuda.taxation_childs;

import javax.xml.bind.annotation.XmlElement;

public class TaxationLine {

	private String Duty_tax_code;
	private String Duty_tax_Base;
	private String Duty_tax_rate;
	private String Duty_tax_amount;
	private String Duty_tax_MP;
	private String Duty_tax_Type_of_calculation;
	
	public String getDuty_tax_code() {
		return Duty_tax_code;
	}
	@XmlElement(nillable = true, name = "Duty_tax_code")
	public void setDuty_tax_code(String duty_tax_code) {
		Duty_tax_code = duty_tax_code;
	}
	public String getDuty_tax_Base() {
		return Duty_tax_Base;
	}
	@XmlElement(nillable = true, name = "Duty_tax_Base")
	public void setDuty_tax_Base(String duty_tax_Base) {
		Duty_tax_Base = duty_tax_Base;
	}
	public String getDuty_tax_rate() {
		return Duty_tax_rate;
	}
	@XmlElement(nillable = true, name = "Duty_tax_rate")
	public void setDuty_tax_rate(String duty_tax_rate) {
		Duty_tax_rate = duty_tax_rate;
	}
	public String getDuty_tax_amount() {
		return Duty_tax_amount;
	}
	@XmlElement(nillable = true, name = "Duty_tax_amount")
	public void setDuty_tax_amount(String duty_tax_amount) {
		Duty_tax_amount = duty_tax_amount;
	}
	public String getDuty_tax_MP() {
		return Duty_tax_MP;
	}
	@XmlElement(nillable = true, name = "Duty_tax_MP")
	public void setDuty_tax_MP(String duty_tax_MP) {
		Duty_tax_MP = duty_tax_MP;
	}
	public String getDuty_tax_Type_of_calculation() {
		return Duty_tax_Type_of_calculation;
	}
	@XmlElement(nillable = true, name = "Duty_tax_Type_of_calculation")
	public void setDuty_tax_Type_of_calculation(String duty_tax_Type_of_calculation) {
		Duty_tax_Type_of_calculation = duty_tax_Type_of_calculation;
	}
	
}
