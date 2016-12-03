package enitity.asycuda.transport_childs;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.transport_childs.meansOfTransport_childs.BorderInformation;
import enitity.asycuda.transport_childs.meansOfTransport_childs.DepartureArrivalInformation;

public class MeansOfTransport {

	private DepartureArrivalInformation Departure_arrival_information;
	private BorderInformation Border_information;
	private String Inland_mode_of_transport;
	
	public DepartureArrivalInformation getDeparture_arrival_information() {
		return Departure_arrival_information;
	}
	@XmlElement(nillable = true, name = "Departure_arrival_information")
	public void setDeparture_arrival_information(DepartureArrivalInformation departure_arrival_information) {
		Departure_arrival_information = departure_arrival_information;
	}
	public BorderInformation getBorder_information() {
		return Border_information;
	}
	@XmlElement(nillable = true, name = "Border_information")
	public void setBorder_information(BorderInformation border_information) {
		Border_information = border_information;
	}
	public String getInland_mode_of_transport() {
		return Inland_mode_of_transport;
	}
	@XmlElement(nillable = true, name = "Inland_mode_of_transport")
	public void setInland_mode_of_transport(String inland_mode_of_transport) {
		Inland_mode_of_transport = inland_mode_of_transport;
	}
	
	
}
