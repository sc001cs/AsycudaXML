package enitity.asycuda.identification_childs;

import javax.xml.bind.annotation.XmlElement;

public class Type {

	private String Type_of_declaration;
	private String Declaration_gen_procedure_code;
	private String Type_of_transit_document;
	
	public String getType_of_declaration() {
		return Type_of_declaration;
	}
	@XmlElement(nillable = true, name = "Type_of_declaration")
	public void setType_of_declaration(String type_of_declaration) {
		Type_of_declaration = type_of_declaration;
	}
	public String getDeclaration_gen_procedure_code() {
		return Declaration_gen_procedure_code;
	}
	@XmlElement(nillable = true, name = "Declaration_gen_procedure_code")
	public void setDeclaration_gen_procedure_code(String declaration_gen_procedure_code) {
		Declaration_gen_procedure_code = declaration_gen_procedure_code;
	}
	public String getType_of_transit_document() {
		return Type_of_transit_document;
	}
	@XmlElement(nillable = true, name = "Type_of_transit_document")
	public void setType_of_transit_document(String type_of_transit_document) {
		Type_of_transit_document = type_of_transit_document;
	}
	
	
}
