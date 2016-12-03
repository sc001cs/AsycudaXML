package enitity.asycuda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.valuation_childs.*;

public class Valuation {

	private String Calculation_working_mode;
	private Weight Weight;
	private String Total_cost;
	private String Total_CIF;
	private GsInvoice Gs_Invoice;
	private List<GsExternalFreight> Gs_external_freight;
	private List<GsInsurance> Gs_insurance;
	private List<GsOtherCost> Gs_other_cost;
	private List<GsDeduction> Gs_deduction;
	private Total Total;
	
	public String getCalculation_working_mode() {
		return Calculation_working_mode;
	}
	@XmlElement(nillable = true, name = "Calculation_working_mode")
	public void setCalculation_working_mode(String calculation_working_mode) {
		Calculation_working_mode = calculation_working_mode;
	}
	public Weight getWeight() {
		return Weight;
	}
	@XmlElement(nillable = true, name = "Weight")
	public void setWeight(Weight weight) {
		Weight = weight;
	}
	public String getTotal_cost() {
		return Total_cost;
	}
	@XmlElement(nillable = true, name = "Total_cost")
	public void setTotal_cost(String total_cost) {
		Total_cost = total_cost;
	}
	public String getTotal_CIF() {
		return Total_CIF;
	}
	@XmlElement(nillable = true, name = "Total_CIF")
	public void setTotal_CIF(String total_CIF) {
		Total_CIF = total_CIF;
	}
	public GsInvoice getGs_Invoice() {
		return Gs_Invoice;
	}
	@XmlElement(nillable = true, name = "Gs_Invoice")
	public void setGs_Invoice(GsInvoice gs_Invoice) {
		Gs_Invoice = gs_Invoice;
	}
	public List<GsExternalFreight> getGs_external_freight() {
		return Gs_external_freight;
	}
	@XmlElement(nillable = true, name = "Gs_external_freight")
	public void setGs_external_freight(List<GsExternalFreight> gs_external_freight) {
		Gs_external_freight = gs_external_freight;
	}
	public List<GsInsurance> getGs_insurance() {
		return Gs_insurance;
	}
	@XmlElement(nillable = true, name = "Gs_insurance")
	public void setGs_insurance(List<GsInsurance> gs_insurance) {
		Gs_insurance = gs_insurance;
	}
	public List<GsOtherCost> getGs_other_cost() {
		return Gs_other_cost;
	}
	@XmlElement(nillable = true, name = "Gs_other_cost")
	public void setGs_other_cost(List<GsOtherCost> gs_other_cost) {
		Gs_other_cost = gs_other_cost;
	}
	public List<GsDeduction> getGs_deduction() {
		return Gs_deduction;
	}
	@XmlElement(nillable = true, name = "Gs_deduction")
	public void setGs_deduction(List<GsDeduction> gs_deduction) {
		Gs_deduction = gs_deduction;
	}
	public Total getTotal() {
		return Total;
	}
	@XmlElement(nillable = true, name = "Total")
	public void setTotal(Total total) {
		Total = total;
	}
	
	
}
