package enitity.asycuda.item_childs;

import javax.xml.bind.annotation.XmlElement;

public class IncoTerms {

	private String Code;
	private String Place;
	
	public String getCode() {
		return Code;
	}
	@XmlElement(nillable = true, name = "Code")
	public void setCode(String code) {
		Code = code;
	}
	public String getPlace() {
		return Place;
	}
	@XmlElement(nillable = true, name = "Place")
	public void setPlace(String place) {
		Place = place;
	}
	
}

