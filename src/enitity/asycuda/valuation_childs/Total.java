package enitity.asycuda.valuation_childs;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class Total {

	private BigDecimal Total_invoice;
	private BigDecimal Total_weight;
	
	public BigDecimal getTotal_invoice() {
		return Total_invoice;
	}
	@XmlElement(nillable = true, name = "Total_invoice")
	public void setTotal_invoice(BigDecimal total_invoice) {
		Total_invoice = total_invoice;
	}
	public BigDecimal getTotal_weight() {
		return Total_weight;
	}
	@XmlElement(nillable = true, name = "Total_weight")
	public void setTotal_weight(BigDecimal total_weight) {
		Total_weight = total_weight;
	}
	
	
}
