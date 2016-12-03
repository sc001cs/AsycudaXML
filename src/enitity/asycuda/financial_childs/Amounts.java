package enitity.asycuda.financial_childs;

import javax.xml.bind.annotation.XmlElement;

public class Amounts {

	private String Total_manual_taxes;
	private String Global_taxes;
	private String Totals_taxes;
	
	public String getTotal_manual_taxes() {
		return Total_manual_taxes;
	}
	@XmlElement(nillable = true, name = "Total_manual_taxes")
	public void setTotal_manual_taxes(String total_manual_taxes) {
		Total_manual_taxes = total_manual_taxes;
	}
	public String getGlobal_taxes() {
		return Global_taxes;
	}
	@XmlElement(nillable = true, name = "Global_taxes")
	public void setGlobal_taxes(String global_taxes) {
		Global_taxes = global_taxes;
	}
	public String getTotals_taxes() {
		return Totals_taxes;
	}
	@XmlElement(nillable = true, name = "Totals_taxes")
	public void setTotals_taxes(String totals_taxes) {
		Totals_taxes = totals_taxes;
	}
	
	
}
