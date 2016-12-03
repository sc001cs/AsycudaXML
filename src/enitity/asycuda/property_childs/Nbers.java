package enitity.asycuda.property_childs;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Nbers {

	private String Number_of_loading_lists;
	private String Total_number_of_items;
	private String Total_number_of_packages;
	
	public String getNumber_of_loading_lists() {
		return Number_of_loading_lists;
	}
	@XmlElement(nillable = true, name = "Number_of_loading_lists")
	public void setNumber_of_loading_lists(String number_of_loading_lists) {
		Number_of_loading_lists = number_of_loading_lists;
	}
	public String getTotal_number_of_items() {
		return Total_number_of_items;
	}
	@XmlElement(nillable = true, name = "Total_number_of_items")
	public void setTotal_number_of_items(String total_number_of_items) {
		Total_number_of_items = total_number_of_items;
	}
	public String getTotal_number_of_packages() {
		return Total_number_of_packages;
	}
	@XmlElement(nillable = true, name = "Total_number_of_packages")
	public void setTotal_number_of_packages(String total_number_of_packages) {
		Total_number_of_packages = total_number_of_packages;
	}
	
	
}
