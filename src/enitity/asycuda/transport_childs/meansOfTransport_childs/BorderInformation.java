package enitity.asycuda.transport_childs.meansOfTransport_childs;

import javax.xml.bind.annotation.XmlElement;

public class BorderInformation {

	private String Identity;
	private String Nationality;
	private String Mode;
	
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
	public String getMode() {
		return Mode;
	}
	@XmlElement(nillable = true, name = "Mode")
	public void setMode(String mode) {
		Mode = mode;
	}
	
	
}
