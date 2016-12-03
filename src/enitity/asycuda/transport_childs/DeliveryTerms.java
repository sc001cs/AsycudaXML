package enitity.asycuda.transport_childs;

import javax.xml.bind.annotation.XmlElement;

public class DeliveryTerms {

	private String Code;
	private String Place;
	private String Situation;
	
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
	public String getSituation() {
		return Situation;
	}
	@XmlElement(nillable = true, name = "Situation")
	public void setSituation(String situation) {
		Situation = situation;
	}
	
	
}
