package enitity.asycuda.financial_childs;

import javax.xml.bind.annotation.XmlElement;

public class Bank {

	private String Code;
	private String Name;
	private String Branch;
	private String Reference;
	
	public String getCode() {
		return Code;
	}
	@XmlElement(nillable = true, name = "Code")
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	@XmlElement(nillable = true, name = "Name")
	public void setName(String name) {
		Name = name;
	}
	public String getBranch() {
		return Branch;
	}
	@XmlElement(nillable = true, name = "Branch")
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getReference() {
		return Reference;
	}
	@XmlElement(nillable = true, name = "Reference")
	public void setReference(String reference) {
		Reference = reference;
	}
	
	
}
