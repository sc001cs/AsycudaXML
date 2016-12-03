package enitity.asycuda.transit_childs;

import javax.xml.bind.annotation.XmlElement;

public class Destination2 {

	private String Office;
	private String Country;
	
	public String getOffice() {
		return Office;
	}
	@XmlElement(nillable = true, name = "Office")
	public void setOffice(String office) {
		Office = office;
	}
	public String getCountry() {
		return Country;
	}
	@XmlElement(nillable = true, name = "Country")
	public void setCountry(String country) {
		Country = country;
	}
	
	
}
