package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.declarant_childs.Reference;

public class Declarant {

	private String Declarant_code;
	private String Declarant_name;
	private String Declarant_representative;
	private Reference Reference;
	
	public String getDeclarant_code() {
		return Declarant_code;
	}
	@XmlElement(nillable = true, name = "Declarant_code")
	public void setDeclarant_code(String declarant_code) {
		Declarant_code = declarant_code;
	}
	public String getDeclarant_name() {
		return Declarant_name;
	}
	@XmlElement(nillable = true, name = "Declarant_name")
	public void setDeclarant_name(String declarant_name) {
		Declarant_name = declarant_name;
	}
	public String getDeclarant_representative() {
		return Declarant_representative;
	}
	@XmlElement(nillable = true, name = "Declarant_representative")
	public void setDeclarant_representative(String declarant_representative) {
		Declarant_representative = declarant_representative;
	}
	public Reference getReference() {
		return Reference;
	}
	@XmlElement(nillable = true, name = "Reference")
	public void setReference(Reference reference) {
		Reference = reference;
	}
	
	
}
