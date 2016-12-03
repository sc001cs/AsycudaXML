package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.generalInfo_childs.Country;

public class GeneralInformation {

	private Country Country;
	private String Value_details;
	private String CAP;
	private String Additional_information;
	private String Comments_free_text;
	
	public Country getCountry() {
		return Country;
	}
	@XmlElement(nillable = true, name = "Country")
	public void setCountry(Country country) {
		Country = country;
	}
	public String getValue_details() {
		return Value_details;
	}
	@XmlElement(nillable = true, name = "Value_details")
	public void setValue_details(String value_details) {
		Value_details = value_details;
	}
	public String getCAP() {
		return CAP;
	}
	@XmlElement(nillable = true, name = "CAP")
	public void setCAP(String cAP) {
		CAP = cAP;
	}
	public String getAdditional_information() {
		return Additional_information;
	}
	@XmlElement(nillable = true, name = "Additional_information")
	public void setAdditional_information(String additional_information) {
		Additional_information = additional_information;
	}
	public String getComments_free_text() {
		return Comments_free_text;
	}
	@XmlElement(nillable = true, name = "Comments_free_text")
	public void setComments_free_text(String comments_free_text) {
		Comments_free_text = comments_free_text;
	}
	
	
}
