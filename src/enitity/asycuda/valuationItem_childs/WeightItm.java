package enitity.asycuda.valuationItem_childs;

import javax.xml.bind.annotation.XmlElement;

public class WeightItm {

	private String Gross_weight_itm;
	private String Net_weight_itm;
	
	public String getGross_weight_itm() {
		return Gross_weight_itm;
	}
	@XmlElement(nillable = true, name = "Gross_weight_itm")
	public void setGross_weight_itm(String gross_weight_itm) {
		Gross_weight_itm = gross_weight_itm;
	}
	public String getNet_weight_itm() {
		return Net_weight_itm;
	}
	@XmlElement(nillable = true, name = "Net_weight_itm")
	public void setNet_weight_itm(String net_weight_itm) {
		Net_weight_itm = net_weight_itm;
	}
	
}
