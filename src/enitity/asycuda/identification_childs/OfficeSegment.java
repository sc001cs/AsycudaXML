package enitity.asycuda.identification_childs;

import javax.xml.bind.annotation.XmlElement;

public class OfficeSegment {

	private String Customs_clearance_office_code;
	private String Customs_Clearance_office_name;
	
	public String getCustoms_clearance_office_code() {
		return Customs_clearance_office_code;
	}
	@XmlElement(nillable = true, name = "Customs_clearance_office_code")
	public void setCustoms_clearance_office_code(String customs_clearance_office_code) {
		Customs_clearance_office_code = customs_clearance_office_code;
	}
	public String getCustoms_Clearance_office_name() {
		return Customs_Clearance_office_name;
	}
	@XmlElement(nillable = true, name = "Customs_Clearance_office_name")
	public void setCustoms_Clearance_office_name(String customs_Clearance_office_name) {
		Customs_Clearance_office_name = customs_Clearance_office_name;
	}
	
	
}
