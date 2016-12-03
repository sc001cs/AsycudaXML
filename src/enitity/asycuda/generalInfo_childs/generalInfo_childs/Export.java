package enitity.asycuda.generalInfo_childs.generalInfo_childs;

import javax.xml.bind.annotation.XmlElement;

public class Export {

	private String Export_country_code;
	private String Export_country_name;
	private String Export_country_region;
	
	public String getExport_country_code() {
		return Export_country_code;
	}
	@XmlElement(nillable = true, name = "Export_country_code")
	public void setExport_country_code(String export_country_code) {
		Export_country_code = export_country_code;
	}
	public String getExport_country_name() {
		return Export_country_name;
	}
	@XmlElement(nillable = true, name = "Export_country_name")
	public void setExport_country_name(String export_country_name) {
		Export_country_name = export_country_name;
	}
	public String getExport_country_region() {
		return Export_country_region;
	}
	@XmlElement(nillable = true, name = "Export_country_region")
	public void setExport_country_region(String export_country_region) {
		Export_country_region = export_country_region;
	}
	
	
}
