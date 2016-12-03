package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.transit_childs.Destination2;
import enitity.asycuda.transit_childs.Principal;
import enitity.asycuda.transit_childs.Seals;
import enitity.asycuda.transit_childs.Signature;

public class Transit {

	private Principal Principal;
	private Signature Signature;
	private Destination2 Destination; // ERROR
	private Seals Seals;
	private String Result_of_control;
	private String Time_limit;
	private String Officer_name;
	
	public Principal getPrincipal() {
		return Principal;
	}
	@XmlElement(nillable = true, name = "Principal")
	public void setPrincipal(Principal principal) {
		Principal = principal;
	}
	public Signature getSignature() {
		return Signature;
	}
	@XmlElement(nillable = true, name = "Signature")
	public void setSignature(Signature signature) {
		Signature = signature;
	}
	
	public Destination2 getDestination() {
		return Destination;
	}
	@XmlElement(nillable = true, name = "Destination")
	public void setDestination(Destination2 destination) {
		Destination = destination;
	}
	public Seals getSeals() {
		return Seals;
	}
	@XmlElement(nillable = true, name = "Seals")
	public void setSeals(Seals seals) {
		Seals = seals;
	}
	public String getResult_of_control() {
		return Result_of_control;
	}
	@XmlElement(nillable = true, name = "Result_of_control")
	public void setResult_of_control(String result_of_control) {
		Result_of_control = result_of_control;
	}
	public String getTime_limit() {
		return Time_limit;
	}
	@XmlElement(nillable = true, name = "Time_limit")
	public void setTime_limit(String time_limit) {
		Time_limit = time_limit;
	}
	public String getOfficer_name() {
		return Officer_name;
	}
	@XmlElement(nillable = true, name = "Officer_name")
	public void setOfficer_name(String officer_name) {
		Officer_name = officer_name;
	}
	
	
}
