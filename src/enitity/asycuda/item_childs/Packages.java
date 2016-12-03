package enitity.asycuda.item_childs;

import javax.xml.bind.annotation.XmlElement;

public class Packages {

	private String Number_of_packages;
	private String Marks1_of_packages;
	private String Marks2_of_packages;
	private String Kind_of_packages_code;
	private String Kind_of_packages_name;
	
	public String getNumber_of_packages() {
		return Number_of_packages;
	}
	@XmlElement(nillable = true, name = "Number_of_packages")
	public void setNumber_of_packages(String number_of_packages) {
		Number_of_packages = number_of_packages;
	}
	public String getMarks1_of_packages() {
		return Marks1_of_packages;
	}
	@XmlElement(nillable = true, name = "Marks1_of_packages")
	public void setMarks1_of_packages(String marks1_of_packages) {
		Marks1_of_packages = marks1_of_packages;
	}
	public String getMarks2_of_packages() {
		return Marks2_of_packages;
	}
	@XmlElement(nillable = true, name = "Marks2_of_packages")
	public void setMarks2_of_packages(String marks2_of_packages) {
		Marks2_of_packages = marks2_of_packages;
	}
	public String getKind_of_packages_code() {
		return Kind_of_packages_code;
	}
	@XmlElement(nillable = true, name = "Kind_of_packages_code")
	public void setKind_of_packages_code(String kind_of_packages_code) {
		Kind_of_packages_code = kind_of_packages_code;
	}
	public String getKind_of_packages_name() {
		return Kind_of_packages_name;
	}
	@XmlElement(nillable = true, name = "Kind_of_packages_name")
	public void setKind_of_packages_name(String kind_of_packages_name) {
		Kind_of_packages_name = kind_of_packages_name;
	}
	
}
