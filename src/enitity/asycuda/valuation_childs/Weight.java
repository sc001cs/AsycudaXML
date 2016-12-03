package enitity.asycuda.valuation_childs;

import javax.xml.bind.annotation.XmlElement;

public class Weight {

	private String Gross_weight;

	public String getGross_weight() {
		return Gross_weight;
	}
	@XmlElement(nillable = true, name = "Gross_weight")
	public void setGross_weight(String gross_weight) {
		Gross_weight = gross_weight;
	}
	
	
}
