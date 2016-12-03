package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

public class Warehouse {

	private String Identification;
	private String Delay;
	
	public String getIdentification() {
		return Identification;
	}
	@XmlElement(nillable = true, name = "Identification")
	public void setIdentification(String identification) {
		Identification = identification;
	}
	public String getDelay() {
		return Delay;
	}
	@XmlElement(nillable = true, name = "Delay")
	public void setDelay(String delay) {
		Delay = delay;
	}
	
	
	
}
