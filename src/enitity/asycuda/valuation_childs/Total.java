package enitity.asycuda.valuation_childs;

import javax.xml.bind.annotation.XmlElement;

public class Total {

	private String Total_invoice;
	private String Total_weight;
	
	public String getTotal_invoice() {
		return Total_invoice;
	}
	@XmlElement(nillable = true, name = "Total_invoice")
	public void setTotal_invoice(String total_invoice) {
		Total_invoice = total_invoice;
	}
	public String getTotal_weight() {
		return Total_weight;
	}
	@XmlElement(nillable = true, name = "Total_weight")
	public void setTotal_weight(String total_weight) {
		Total_weight = total_weight;
	}
	
	
}
