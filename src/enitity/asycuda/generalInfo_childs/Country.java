package enitity.asycuda.generalInfo_childs;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.generalInfo_childs.generalInfo_childs.Destination;
import enitity.asycuda.generalInfo_childs.generalInfo_childs.Export;

public class Country {

	private String Country_first_destination;
	private String Trading_country;
	private Export Export;
	private Destination Destination;
	private String Country_of_origin_name;
	
	public String getCountry_first_destination() {
		return Country_first_destination;
	}
	@XmlElement(nillable = true, name = "Country_first_destination")
	public void setCountry_first_destination(String country_first_destination) {
		Country_first_destination = country_first_destination;
	}
	public String getTrading_country() {
		return Trading_country;
	}
	@XmlElement(nillable = true, name = "Trading_country")
	public void setTrading_country(String trading_country) {
		Trading_country = trading_country;
	}
	public Export getExport() {
		return Export;
	}
	@XmlElement(nillable = true, name = "Export")
	public void setExport(Export export) {
		Export = export;
	}
	public Destination getDestination() {
		return Destination;
	}
	@XmlElement(nillable = true, name = "Destination")
	public void setDestination(Destination destination) {
		Destination = destination;
	}
	public String getCountry_of_origin_name() {
		return Country_of_origin_name;
	}
	@XmlElement(nillable = true, name = "Country_of_origin_name")
	public void setCountry_of_origin_name(String country_of_origin_name) {
		Country_of_origin_name = country_of_origin_name;
	}
	
	
}
