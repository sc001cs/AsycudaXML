package enitity.asycuda.item_childs.tarification_childs.quota_childs;

import javax.xml.bind.annotation.XmlElement;

public class QuotaItem {

	private String ItmNbr;

	public String getItmNbr() {
		return ItmNbr;
	}
	@XmlElement(nillable = true, name = "ItmNbr")
	public void setItmNbr(String itmNbr) {
		ItmNbr = itmNbr;
	}
	
}
