package enitity.asycuda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class GlobalTaxes {

	private List<String> Global_tax_item;

	public List<String> getGlobal_tax_item() {
		return Global_tax_item;
	}

	@XmlElement(nillable = true, name = "Global_tax_item")
	public void setGlobal_tax_item(List<String> global_tax_item) {
		Global_tax_item = global_tax_item;
	}
	
	
}
