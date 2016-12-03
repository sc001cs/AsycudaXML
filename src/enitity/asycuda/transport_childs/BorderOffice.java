package enitity.asycuda.transport_childs;

import javax.xml.bind.annotation.XmlElement;

public class BorderOffice {

	private String Code;
	private String Name;
	
	public String getCode() {
		return Code;
	}
	@XmlElement(nillable = true, name = "Code")
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	@XmlElement(nillable = true, name = "Name")
	public void setName(String name) {
		Name = name;
	}
	
	
}
