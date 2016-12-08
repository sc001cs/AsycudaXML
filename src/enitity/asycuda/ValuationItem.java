package enitity.asycuda;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.valuationItem_childs.ItemExternalFreight;
import enitity.asycuda.valuationItem_childs.ItemInsurance;
import enitity.asycuda.valuationItem_childs.ItemInvoice;
import enitity.asycuda.valuationItem_childs.ItemOtherCost;
import enitity.asycuda.valuationItem_childs.MarketValuer;
import enitity.asycuda.valuationItem_childs.WeightItm;

public class ValuationItem {

	private WeightItm Weight_itm;
	private String Total_cost_itm;
	private BigDecimal Total_CIF_itm;
	private String Rate_of_adjustement;
	private BigDecimal Statistical_value;
	private String Alpha_coeficient_of_apportionment;
	private List<ItemInvoice> Item_Invoice;
	private List<ItemExternalFreight> item_external_freight;
	private List<ItemInsurance> item_insurance;
	private List<ItemOtherCost> item_other_cost;
	private List<MarketValuer> Market_valuer;
	
	public WeightItm getWeight_itm() {
		return Weight_itm;
	}
	@XmlElement(nillable = true, name = "Weight_itm")
	public void setWeight_itm(WeightItm weight_itm) {
		Weight_itm = weight_itm;
	}
	public String getTotal_cost_itm() {
		return Total_cost_itm;
	}
	@XmlElement(nillable = true, name = "Total_cost_itm")
	public void setTotal_cost_itm(String total_cost_itm) {
		Total_cost_itm = total_cost_itm;
	}
	public BigDecimal getTotal_CIF_itm() {
		return Total_CIF_itm;
	}
	@XmlElement(nillable = true, name = "Total_CIF_itm")
	public void setTotal_CIF_itm(BigDecimal total_CIF_itm) {
		Total_CIF_itm = total_CIF_itm;
	}
	public String getRate_of_adjustement() {
		return Rate_of_adjustement;
	}
	@XmlElement(nillable = true, name = "Rate_of_adjustement")
	public void setRate_of_adjustement(String rate_of_adjustement) {
		Rate_of_adjustement = rate_of_adjustement;
	}
	public BigDecimal getStatistical_value() {
		return Statistical_value;
	}
	@XmlElement(nillable = true, name = "Statistical_value")
	public void setStatistical_value(BigDecimal statistical_value) {
		Statistical_value = statistical_value;
	}
	public String getAlpha_coeficient_of_apportionment() {
		return Alpha_coeficient_of_apportionment;
	}
	@XmlElement(nillable = true, name = "Alpha_coeficient_of_apportionment")
	public void setAlpha_coeficient_of_apportionment(String alpha_coeficient_of_apportionment) {
		Alpha_coeficient_of_apportionment = alpha_coeficient_of_apportionment;
	}
	public List<ItemInvoice> getItem_Invoice() {
		return Item_Invoice;
	}
	@XmlElement(nillable = true, name = "Item_Invoice")
	public void setItem_Invoice(List<ItemInvoice> item_Invoice) {
		Item_Invoice = item_Invoice;
	}
	public List<ItemExternalFreight> getItem_external_freight() {
		return item_external_freight;
	}
	@XmlElement(nillable = true, name = "item_external_freight")
	public void setItem_external_freight(List<ItemExternalFreight> item_external_freight) {
		this.item_external_freight = item_external_freight;
	}
	public List<ItemInsurance> getItem_insurance() {
		return item_insurance;
	}
	@XmlElement(nillable = true, name = "item_insurance")
	public void setItem_insurance(List<ItemInsurance> item_insurance) {
		this.item_insurance = item_insurance;
	}
	public List<ItemOtherCost> getItem_other_cost() {
		return item_other_cost;
	}
	@XmlElement(nillable = true, name = "item_other_cost")
	public void setItem_other_cost(List<ItemOtherCost> item_other_cost) {
		this.item_other_cost = item_other_cost;
	}
	public List<MarketValuer> getMarket_valuer() {
		return Market_valuer;
	}
	@XmlElement(nillable = true, name = "Market_valuer")
	public void setMarket_valuer(List<MarketValuer> market_valuer) {
		Market_valuer = market_valuer;
	}
	
}
