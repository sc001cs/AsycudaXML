package enitity.asycuda.item_childs.tarification_childs;

import javax.xml.bind.annotation.XmlElement;

public class HScode {

	private String Commodity_code;
	private String Precision_1;
	private String Precision_2;
	private String Precision_3;
	private String Precision_4;
	
	public String getCommodity_code() {
		return Commodity_code;
	}
	@XmlElement(nillable = true, name = "Commodity_code")
	public void setCommodity_code(String commodity_code) {
		Commodity_code = commodity_code;
	}
	public String getPrecision_1() {
		return Precision_1;
	}
	@XmlElement(nillable = true, name = "Precision_1")
	public void setPrecision_1(String precision_1) {
		Precision_1 = precision_1;
	}
	public String getPrecision_2() {
		return Precision_2;
	}
	@XmlElement(nillable = true, name = "Precision_2")
	public void setPrecision_2(String precision_2) {
		Precision_2 = precision_2;
	}
	public String getPrecision_3() {
		return Precision_3;
	}
	@XmlElement(nillable = true, name = "Precision_3")
	public void setPrecision_3(String precision_3) {
		Precision_3 = precision_3;
	}
	public String getPrecision_4() {
		return Precision_4;
	}
	@XmlElement(nillable = true, name = "Precision_4")
	public void setPrecision_4(String precision_4) {
		Precision_4 = precision_4;
	}
	
}
