package enitity.asycuda.item_childs;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class AttachedDocuments {

	private String Attached_document_code;
	private String Attached_document_name;
	private String Attached_document_reference;
	private String Attached_document_from_rule;
	private Date Attached_document_date;
	
	public String getAttached_document_code() {
		return Attached_document_code;
	}
	@XmlElement(nillable = true, name = "Attached_document_code")
	public void setAttached_document_code(String attached_document_code) {
		Attached_document_code = attached_document_code;
	}
	public String getAttached_document_name() {
		return Attached_document_name;
	}
	@XmlElement(nillable = true, name = "Attached_document_name")
	public void setAttached_document_name(String attached_document_name) {
		Attached_document_name = attached_document_name;
	}
	public String getAttached_document_reference() {
		return Attached_document_reference;
	}
	@XmlElement(nillable = true, name = "Attached_document_reference")
	public void setAttached_document_reference(String attached_document_reference) {
		Attached_document_reference = attached_document_reference;
	}
	public String getAttached_document_from_rule() {
		return Attached_document_from_rule;
	}
	@XmlElement(nillable = true, name = "Attached_document_from_rule")
	public void setAttached_document_from_rule(String attached_document_from_rule) {
		Attached_document_from_rule = attached_document_from_rule;
	}
	public Date getAttached_document_date() {
		return Attached_document_date;
	}
	@XmlElement(nillable = true, name = "Attached_document_date")
	public void setAttached_document_date(Date attached_document_date) {
		Attached_document_date = attached_document_date;
	}
	
	
}
