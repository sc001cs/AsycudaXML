package enitity.asycuda.financial_childs;

import javax.xml.bind.annotation.XmlElement;

public class Terms {

	private String Code;
	private String Description;
	
	public String getCode() {
		return Code;
	}
	@XmlElement(nillable = true, name = "Code")
	public void setCode(String code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	@XmlElement(nillable = true, name = "Description")
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
