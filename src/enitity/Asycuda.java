package enitity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import enitity.asycuda.*;

@XmlRootElement(name = "ASYCUDA")
public class Asycuda {

	private ExportRelease Export_release;
	private AssessmentNotice Assessment_notice;
	private GlobalTaxes Global_taxes;
	private Property Property;
	private Identification Identification;
	private Traders Traders;
	private Declarant Declarant;
	private GeneralInformation General_information;
	private Transport Transport;
	private Financial Financial;
	private Warehouse Warehouse;
	private Transit Transit;
	private Valuation Valuation;
	private List<Item> Item;
	
	public ExportRelease getExport_release() {
		return Export_release;
	}
	@XmlElement(nillable = true, name = "Export_release")
	public void setExport_release(ExportRelease export_release) {
		Export_release = export_release;
	}
	public AssessmentNotice getAssessment_notice() {
		return Assessment_notice;
	}
	@XmlElement(nillable = true, name = "Assessment_notice")
	public void setAssessment_notice(AssessmentNotice assessment_notice) {
		Assessment_notice = assessment_notice;
	}
	public GlobalTaxes getGlobal_taxes() {
		return Global_taxes;
	}
	@XmlElement(nillable = true, name = "Global_taxes")
	public void setGlobal_taxes(GlobalTaxes global_taxes) {
		Global_taxes = global_taxes;
	}
	public Property getProperty() {
		return Property;
	}
	@XmlElement(nillable = true, name = "Property")
	public void setProperty(Property property) {
		Property = property;
	}
	public Identification getIdentification() {
		return Identification;
	}
	@XmlElement(nillable = true, name = "Identification")
	public void setIdentification(Identification identification) {
		Identification = identification;
	}
	public Traders getTraders() {
		return Traders;
	}
	@XmlElement(nillable = true, name = "Traders")
	public void setTraders(Traders traders) {
		Traders = traders;
	}
	public Declarant getDeclarant() {
		return Declarant;
	}
	@XmlElement(nillable = true, name = "Declarant")
	public void setDeclarant(Declarant declarant) {
		Declarant = declarant;
	}
	public GeneralInformation getGeneral_information() {
		return General_information;
	}
	@XmlElement(nillable = true, name = "General_information")
	public void setGeneral_information(GeneralInformation general_information) {
		General_information = general_information;
	}
	public Transport getTransport() {
		return Transport;
	}
	@XmlElement(nillable = true, name = "Transport")
	public void setTransport(Transport transport) {
		Transport = transport;
	}
	public Financial getFinancial() {
		return Financial;
	}
	@XmlElement(nillable = true, name = "Financial")
	public void setFinancial(Financial financial) {
		Financial = financial;
	}
	public Warehouse getWarehouse() {
		return Warehouse;
	}
	@XmlElement(nillable = true, name = "Warehouse")
	public void setWarehouse(Warehouse warehouse) {
		Warehouse = warehouse;
	}
	public Transit getTransit() {
		return Transit;
	}
	@XmlElement(nillable = true, name = "Transit")
	public void setTransit(Transit transit) {
		Transit = transit;
	}
	public Valuation getValuation() {
		return Valuation;
	}
	@XmlElement(nillable = true, name = "Valuation")
	public void setValuation(Valuation valuation) {
		Valuation = valuation;
	}

	public List<Item> getItem() {
		return Item;
	}
	@XmlElement(nillable = true, name = "Item")
	public void setItem(List<Item> item) {
		Item = item;
	}
	
	
	
	
	
}
