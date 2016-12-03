package enitity.asycuda.item_childs;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.item_childs.tarification_childs.HScode;
import enitity.asycuda.item_childs.tarification_childs.Quota;
import enitity.asycuda.item_childs.tarification_childs.SupplementaryUnit;

public class Tarification {

	private String Tarification_data;
	private HScode HScode;
	private String Preference_code;
	private String Extended_customs_procedure;
	private String National_customs_procedure;
	private String Quota_code;
	private Quota Quota;
	private List<SupplementaryUnit> Supplementary_unit;
	private String Item_price;
	private String Valuation_method_code;
	private String Value_item;
	private String Attached_doc_item;
	private String AI_code; // ERROR Original: A.I._code
	
	public String getTarification_data() {
		return Tarification_data;
	}
	@XmlElement(nillable = true, name = "Tarification_data")
	public void setTarification_data(String tarification_data) {
		Tarification_data = tarification_data;
	}
	public HScode getHScode() {
		return HScode;
	}
	@XmlElement(nillable = true, name = "HScode")
	public void setHScode(HScode hScode) {
		HScode = hScode;
	}
	public String getPreference_code() {
		return Preference_code;
	}
	@XmlElement(nillable = true, name = "Preference_code")
	public void setPreference_code(String preference_code) {
		Preference_code = preference_code;
	}
	public String getExtended_customs_procedure() {
		return Extended_customs_procedure;
	}
	@XmlElement(nillable = true, name = "Extended_customs_procedure")
	public void setExtended_customs_procedure(String extended_customs_procedure) {
		Extended_customs_procedure = extended_customs_procedure;
	}
	public String getNational_customs_procedure() {
		return National_customs_procedure;
	}
	@XmlElement(nillable = true, name = "National_customs_procedure")
	public void setNational_customs_procedure(String national_customs_procedure) {
		National_customs_procedure = national_customs_procedure;
	}
	public String getQuota_code() {
		return Quota_code;
	}
	@XmlElement(nillable = true, name = "Quota_code")
	public void setQuota_code(String quota_code) {
		Quota_code = quota_code;
	}
	public Quota getQuota() {
		return Quota;
	}
	@XmlElement(nillable = true, name = "Quota")
	public void setQuota(Quota quota) {
		Quota = quota;
	}
	public List<SupplementaryUnit> getSupplementary_unit() {
		return Supplementary_unit;
	}
	@XmlElement(nillable = true, name = "Supplementary_unit")
	public void setSupplementary_unit(List<SupplementaryUnit> supplementary_unit) {
		Supplementary_unit = supplementary_unit;
	}
	public String getItem_price() {
		return Item_price;
	}
	@XmlElement(nillable = true, name = "Item_price")
	public void setItem_price(String item_price) {
		Item_price = item_price;
	}
	public String getValuation_method_code() {
		return Valuation_method_code;
	}
	@XmlElement(nillable = true, name = "Valuation_method_code")
	public void setValuation_method_code(String valuation_method_code) {
		Valuation_method_code = valuation_method_code;
	}
	public String getValue_item() {
		return Value_item;
	}
	@XmlElement(nillable = true, name = "Value_item")
	public void setValue_item(String value_item) {
		Value_item = value_item;
	}
	public String getAttached_doc_item() {
		return Attached_doc_item;
	}
	@XmlElement(nillable = true, name = "Attached_doc_item")
	public void setAttached_doc_item(String attached_doc_item) {
		Attached_doc_item = attached_doc_item;
	}
	public String getAI_code() {
		return AI_code;
	}
	@XmlElement(nillable = true, name = "AI_code")
	public void setAI_code(String aI_code) {
		AI_code = aI_code;
	}
	
}
