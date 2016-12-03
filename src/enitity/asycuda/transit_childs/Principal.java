package enitity.asycuda.transit_childs;

import javax.xml.bind.annotation.XmlElement;

public class Principal {

	private String Code;
	private String Name;
	private String Representative;
	
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
	public String getRepresentative() {
		return Representative;
	}
	@XmlElement(nillable = true, name = "Representative")
	public void setRepresentative(String representative) {
		Representative = representative;
	}
	
	
}
