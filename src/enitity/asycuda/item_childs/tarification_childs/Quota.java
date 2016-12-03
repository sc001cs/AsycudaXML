package enitity.asycuda.item_childs.tarification_childs;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.item_childs.tarification_childs.quota_childs.QuotaItem;

public class Quota {

	private String QuotaCode;
	private String QuotaId;
	private List<QuotaItem> QuotaItem;
	
	public String getQuotaCode() {
		return QuotaCode;
	}
	@XmlElement(nillable = true, name = "QuotaCode")
	public void setQuotaCode(String quotaCode) {
		QuotaCode = quotaCode;
	}
	public String getQuotaId() {
		return QuotaId;
	}
	@XmlElement(nillable = true, name = "QuotaId")
	public void setQuotaId(String quotaId) {
		QuotaId = quotaId;
	}
	public List<QuotaItem> getQuotaItem() {
		return QuotaItem;
	}
	@XmlElement(nillable = true, name = "QuotaItem")
	public void setQuotaItem(List<QuotaItem> quotaItem) {
		QuotaItem = quotaItem;
	}
	
	
}
