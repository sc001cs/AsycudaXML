package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

public class GoodsDescription {

	private String Country_of_origin_code;
	private String Country_of_origin_region;
	private String Description_of_goods;
	private String Commercial_Description;
	
	public String getCountry_of_origin_code() {
		return Country_of_origin_code;
	}
	@XmlElement(nillable = true, name = "Country_of_origin_code")
	public void setCountry_of_origin_code(String country_of_origin_code) {
		Country_of_origin_code = country_of_origin_code;
	}
	public String getCountry_of_origin_region() {
		return Country_of_origin_region;
	}
	@XmlElement(nillable = true, name = "Country_of_origin_region")
	public void setCountry_of_origin_region(String country_of_origin_region) {
		Country_of_origin_region = country_of_origin_region;
	}
	public String getDescription_of_goods() {
		return Description_of_goods;
	}
	@XmlElement(nillable = true, name = "Description_of_goods")
	public void setDescription_of_goods(String description_of_goods) {
		Description_of_goods = description_of_goods;
	}
	public String getCommercial_Description() {
		return Commercial_Description;
	}
	@XmlElement(nillable = true, name = "Commercial_Description")
	public void setCommercial_Description(String commercial_Description) {
		Commercial_Description = commercial_Description;
	}
	
}
