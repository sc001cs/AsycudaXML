package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.identification_childs.Assessment;
import enitity.asycuda.identification_childs.OfficeSegment;
import enitity.asycuda.identification_childs.Receipt;
import enitity.asycuda.identification_childs.Registration;
import enitity.asycuda.identification_childs.Type;

public class Identification {

	private OfficeSegment Office_segment;
	private Type Type;
	private String Manifest_reference_number;
	private Registration Registration;
	private Assessment Assessment;
	private Receipt receipt;
	
	public OfficeSegment getOffice_segment() {
		return Office_segment;
	}
	@XmlElement(nillable = true, name = "Office_segment")
	public void setOffice_segment(OfficeSegment office_segment) {
		Office_segment = office_segment;
	}
	public Type getType() {
		return Type;
	}
	@XmlElement(nillable = true, name = "Type")
	public void setType(Type type) {
		Type = type;
	}
	public String getManifest_reference_number() {
		return Manifest_reference_number;
	}
	@XmlElement(nillable = true, name = "Manifest_reference_number")
	public void setManifest_reference_number(String manifest_reference_number) {
		Manifest_reference_number = manifest_reference_number;
	}
	public Registration getRegistration() {
		return Registration;
	}
	@XmlElement(nillable = true, name = "Registration")
	public void setRegistration(Registration registration) {
		Registration = registration;
	}
	public Assessment getAssessment() {
		return Assessment;
	}
	@XmlElement(nillable = true, name = "Assessment")
	public void setAssessment(Assessment assessment) {
		Assessment = assessment;
	}
	public Receipt getReceipt() {
		return receipt;
	}
	@XmlElement(nillable = true, name = "receipt")
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	
}
