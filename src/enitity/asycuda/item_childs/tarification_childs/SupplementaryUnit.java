package enitity.asycuda.item_childs.tarification_childs;

import javax.xml.bind.annotation.XmlElement;

public class SupplementaryUnit {

	private String Suppplementary_unit_code;
	private String Suppplementary_unit_name;
	private String Suppplementary_unit_quantity;
	
	public String getSuppplementary_unit_code() {
		return Suppplementary_unit_code;
	}
	@XmlElement(nillable = true, name = "Suppplementary_unit_code")
	public void setSuppplementary_unit_code(String suppplementary_unit_code) {
		Suppplementary_unit_code = suppplementary_unit_code;
	}
	public String getSuppplementary_unit_name() {
		return Suppplementary_unit_name;
	}
	@XmlElement(nillable = true, name = "Suppplementary_unit_name")
	public void setSuppplementary_unit_name(String suppplementary_unit_name) {
		Suppplementary_unit_name = suppplementary_unit_name;
	}
	public String getSuppplementary_unit_quantity() {
		return Suppplementary_unit_quantity;
	}
	@XmlElement(nillable = true, name = "Suppplementary_unit_quantity")
	public void setSuppplementary_unit_quantity(String suppplementary_unit_quantity) {
		Suppplementary_unit_quantity = suppplementary_unit_quantity;
	}
	
}
