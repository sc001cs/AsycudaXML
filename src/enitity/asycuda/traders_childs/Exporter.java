package enitity.asycuda.traders_childs;

import javax.xml.bind.annotation.XmlElement;

public class Exporter {

	private String Exporter_code;
	private String Exporter_name;
	
	public String getExporter_code() {
		return Exporter_code;
	}
	@XmlElement(nillable = true, name = "Exporter_code")
	public void setExporter_code(String exporter_code) {
		Exporter_code = exporter_code;
	}
	public String getExporter_name() {
		return Exporter_name;
	}
	@XmlElement(nillable = true, name = "Exporter_name")
	public void setExporter_name(String exporter_name) {
		Exporter_name = exporter_name;
	}
	
}
