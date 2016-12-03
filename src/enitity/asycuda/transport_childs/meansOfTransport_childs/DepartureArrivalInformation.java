package enitity.asycuda.transport_childs.meansOfTransport_childs;

import javax.xml.bind.annotation.XmlElement;

public class DepartureArrivalInformation {

	private String Identity;
	private String Nationality;
	
	public String getIdentity() {
		return Identity;
	}
	@XmlElement(nillable = true, name = "Identity")
	public void setIdentity(String identity) {
		Identity = identity;
	}
	public String getNationality() {
		return Nationality;
	}
	@XmlElement(nillable = true, name = "Nationality")
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	
	
}
