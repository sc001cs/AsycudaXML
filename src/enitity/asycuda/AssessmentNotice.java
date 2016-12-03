package enitity.asycuda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class AssessmentNotice {

	private List<String> Item_tax_total;

	public List<String> getItem_tax_total() {
		return Item_tax_total;
	}

	@XmlElement(nillable = true, name = "Item_tax_total")
	public void setItem_tax_total(List<String> item_tax_total) {
		Item_tax_total = item_tax_total;
	}
	
}
