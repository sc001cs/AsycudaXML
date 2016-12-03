package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

public class PreviousDoc {

	private String Summary_declaration;
	private String Summary_declaration_sl;
	private String Previous_document_reference;
	private String Previous_warehouse_code;
	
	public String getSummary_declaration() {
		return Summary_declaration;
	}
	@XmlElement(nillable = true, name = "Summary_declaration")
	public void setSummary_declaration(String summary_declaration) {
		Summary_declaration = summary_declaration;
	}
	public String getSummary_declaration_sl() {
		return Summary_declaration_sl;
	}
	@XmlElement(nillable = true, name = "Summary_declaration_sl")
	public void setSummary_declaration_sl(String summary_declaration_sl) {
		Summary_declaration_sl = summary_declaration_sl;
	}
	public String getPrevious_document_reference() {
		return Previous_document_reference;
	}
	@XmlElement(nillable = true, name = "Previous_document_reference")
	public void setPrevious_document_reference(String previous_document_reference) {
		Previous_document_reference = previous_document_reference;
	}
	public String getPrevious_warehouse_code() {
		return Previous_warehouse_code;
	}
	@XmlElement(nillable = true, name = "Previous_warehouse_code")
	public void setPrevious_warehouse_code(String previous_warehouse_code) {
		Previous_warehouse_code = previous_warehouse_code;
	}
	
}
