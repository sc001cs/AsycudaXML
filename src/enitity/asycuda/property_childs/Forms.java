package enitity.asycuda.property_childs;

import javax.xml.bind.annotation.XmlElement;

public class Forms {

	private String Number_of_the_form;
	private String Total_number_of_forms;
	
	public String getNumber_of_the_form() {
		return Number_of_the_form;
	}
	@XmlElement(nillable = true, name = "Number_of_the_form")
	public void setNumber_of_the_form(String number_of_the_form) {
		Number_of_the_form = number_of_the_form;
	}
	public String getTotal_number_of_forms() {
		return Total_number_of_forms;
	}
	@XmlElement(nillable = true, name = "Total_number_of_forms")
	public void setTotal_number_of_forms(String total_number_of_forms) {
		Total_number_of_forms = total_number_of_forms;
	}
	
	
}
