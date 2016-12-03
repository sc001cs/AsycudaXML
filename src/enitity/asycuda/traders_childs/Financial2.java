package enitity.asycuda.traders_childs;

import javax.xml.bind.annotation.XmlElement;

public class Financial2 {

	private String Financial_code;
	private String Financial_name;
	
	public String getFinancial_code() {
		return Financial_code;
	}
	@XmlElement(nillable = true, name = "Financial_code")
	public void setFinancial_code(String financial_code) {
		Financial_code = financial_code;
	}
	public String getFinancial_name() {
		return Financial_name;
	}
	@XmlElement(nillable = true, name = "Financial_name")
	public void setFinancial_name(String financial_name) {
		Financial_name = financial_name;
	}
	
	
}
