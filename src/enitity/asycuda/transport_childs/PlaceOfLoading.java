package enitity.asycuda.transport_childs;

import javax.xml.bind.annotation.XmlElement;

public class PlaceOfLoading {

	private String Code;
	private String Name;
	private String Country;
	
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
	public String getCountry() {
		return Country;
	}
	@XmlElement(nillable = true, name = "Country")
	public void setCountry(String country) {
		Country = country;
	}
	
	
}
