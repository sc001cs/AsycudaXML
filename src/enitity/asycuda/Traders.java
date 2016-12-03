package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.traders_childs.Consignee;
import enitity.asycuda.traders_childs.Exporter;
import enitity.asycuda.traders_childs.Financial2;

public class Traders {

	private Exporter Exporter;
	private Consignee Consignee;
	private Financial2 Financial; // ERROR Original: Financial
	
	public Exporter getExporter() {
		return Exporter;
	}
	@XmlElement(nillable = true, name = "Exporter")
	public void setExporter(Exporter exporter) {
		Exporter = exporter;
	}
	public Consignee getConsignee() {
		return Consignee;
	}
	@XmlElement(nillable = true, name = "Consignee")
	public void setConsignee(Consignee consignee) {
		Consignee = consignee;
	}
	public Financial2 getFinancial() {
		return Financial;
	}
	@XmlElement(nillable = true, name = "Financial")
	public void setFinancial(Financial2 financial) {
		Financial = financial;
	}
	
	
}
