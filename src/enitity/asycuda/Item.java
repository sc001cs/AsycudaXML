package enitity.asycuda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.item_childs.AttachedDocuments;
import enitity.asycuda.item_childs.IncoTerms;
import enitity.asycuda.item_childs.Packages;
import enitity.asycuda.item_childs.Tarification;

public class Item {

	private List<AttachedDocuments> Attached_documents;
	private Packages Packages;
	private IncoTerms IncoTerms;
	private Tarification Tarification;
	private GoodsDescription Goods_description;
	private PreviousDoc Previous_doc;
	private String Licence_number;
	private String Amount_deducted_from_licence;
	private String Quantity_deducted_from_licence;
	private String Free_text_1;
	private String Free_text_2;
	private Taxation Taxation;
	private ValuationItem Valuation_item;
	
	public List<AttachedDocuments> getAttached_documents() {
		return Attached_documents;
	}
	@XmlElement(nillable = true, name = "Attached_documents")
	public void setAttached_documents(List<AttachedDocuments> attached_documents) {
		Attached_documents = attached_documents;
	}
	public Packages getPackages() {
		return Packages;
	}
	@XmlElement(nillable = true, name = "Packages")
	public void setPackages(Packages packages) {
		Packages = packages;
	}
	public IncoTerms getIncoTerms() {
		return IncoTerms;
	}
	@XmlElement(nillable = true, name = "IncoTerms")
	public void setIncoTerms(IncoTerms incoTerms) {
		IncoTerms = incoTerms;
	}
	public Tarification getTarification() {
		return Tarification;
	}
	@XmlElement(nillable = true, name = "Tarification")
	public void setTarification(Tarification tarification) {
		Tarification = tarification;
	}
	public GoodsDescription getGoods_description() {
		return Goods_description;
	}
	@XmlElement(nillable = true, name = "Goods_description")
	public void setGoods_description(GoodsDescription goods_description) {
		Goods_description = goods_description;
	}
	public PreviousDoc getPrevious_doc() {
		return Previous_doc;
	}
	@XmlElement(nillable = true, name = "Previous_doc")
	public void setPrevious_doc(PreviousDoc previous_doc) {
		Previous_doc = previous_doc;
	}
	public String getLicence_number() {
		return Licence_number;
	}
	@XmlElement(nillable = true, name = "Licence_number")
	public void setLicence_number(String licence_number) {
		Licence_number = licence_number;
	}
	public String getAmount_deducted_from_licence() {
		return Amount_deducted_from_licence;
	}
	@XmlElement(nillable = true, name = "Amount_deducted_from_licence")
	public void setAmount_deducted_from_licence(String amount_deducted_from_licence) {
		Amount_deducted_from_licence = amount_deducted_from_licence;
	}
	public String getQuantity_deducted_from_licence() {
		return Quantity_deducted_from_licence;
	}
	@XmlElement(nillable = true, name = "Quantity_deducted_from_licence")
	public void setQuantity_deducted_from_licence(String quantity_deducted_from_licence) {
		Quantity_deducted_from_licence = quantity_deducted_from_licence;
	}
	public String getFree_text_1() {
		return Free_text_1;
	}
	@XmlElement(nillable = true, name = "Free_text_1")
	public void setFree_text_1(String free_text_1) {
		Free_text_1 = free_text_1;
	}
	public String getFree_text_2() {
		return Free_text_2;
	}
	@XmlElement(nillable = true, name = "Free_text_2")
	public void setFree_text_2(String free_text_2) {
		Free_text_2 = free_text_2;
	}
	public Taxation getTaxation() {
		return Taxation;
	}
	@XmlElement(nillable = true, name = "Taxation")
	public void setTaxation(Taxation taxation) {
		Taxation = taxation;
	}
	public ValuationItem getValuation_item() {
		return Valuation_item;
	}
	@XmlElement(nillable = true, name = "Valuation_item")
	public void setValuation_item(ValuationItem valuation_item) {
		Valuation_item = valuation_item;
	}
	
	
}
