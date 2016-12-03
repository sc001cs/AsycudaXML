package enitity.asycuda.financial_childs;

import javax.xml.bind.annotation.XmlElement;

public class FinancialTransaction {

	private String code1;
	private String code2;
	
	public String getCode1() {
		return code1;
	}
	@XmlElement(nillable = true, name = "code1")
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getCode2() {
		return code2;
	}
	@XmlElement(nillable = true, name = "code2")
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	
}
