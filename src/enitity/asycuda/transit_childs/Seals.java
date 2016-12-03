package enitity.asycuda.transit_childs;

import javax.xml.bind.annotation.XmlElement;

public class Seals {

	private String Number;
	private String Identity;
	
	public String getNumber() {
		return Number;
	}
	@XmlElement(nillable = true, name = "Number")
	public void setNumber(String number) {
		Number = number;
	}
	public String getIdentity() {
		return Identity;
	}
	@XmlElement(nillable = true, name = "Identity")
	public void setIdentity(String identity) {
		Identity = identity;
	}
	
	
}
