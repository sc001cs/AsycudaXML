package enitity.asycuda.generalInfo_childs.generalInfo_childs;

import javax.xml.bind.annotation.XmlElement;

public class Destination {

	private String Destination_country_code;
	private String Destination_country_name;
	private String Destination_country_region;
	
	public String getDestination_country_code() {
		return Destination_country_code;
	}
	@XmlElement(nillable = true, name = "Destination_country_code")
	public void setDestination_country_code(String destination_country_code) {
		Destination_country_code = destination_country_code;
	}
	public String getDestination_country_name() {
		return Destination_country_name;
	}
	@XmlElement(nillable = true, name = "Destination_country_name")
	public void setDestination_country_name(String destination_country_name) {
		Destination_country_name = destination_country_name;
	}
	public String getDestination_country_region() {
		return Destination_country_region;
	}
	@XmlElement(nillable = true, name = "Destination_country_region")
	public void setDestination_country_region(String destination_country_region) {
		Destination_country_region = destination_country_region;
	}
	
	
}
