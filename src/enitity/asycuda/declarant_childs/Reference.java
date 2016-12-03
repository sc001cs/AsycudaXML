package enitity.asycuda.declarant_childs;

import javax.xml.bind.annotation.XmlElement;

public class Reference {

	private String Number;

	public String getNumber() {
		return Number;
	}
	@XmlElement(nillable = true, name = "Number")
	public void setNumber(String number) {
		Number = number;
	}
	
	
}
