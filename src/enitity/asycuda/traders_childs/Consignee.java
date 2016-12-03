package enitity.asycuda.traders_childs;

import javax.xml.bind.annotation.XmlElement;

public class Consignee {

	private String Consignee_code;
	private String Consignee_name;
	
	public String getConsignee_code() {
		return Consignee_code;
	}
	@XmlElement(nillable = true, name = "Consignee_code")
	public void setConsignee_code(String consignee_code) {
		Consignee_code = consignee_code;
	}
	public String getConsignee_name() {
		return Consignee_name;
	}
	@XmlElement(nillable = true, name = "Consignee_name")
	public void setConsignee_name(String consignee_name) {
		Consignee_name = consignee_name;
	}
	
}
