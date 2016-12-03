package enitity.asycuda;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.transport_childs.BorderOffice;
import enitity.asycuda.transport_childs.DeliveryTerms;
import enitity.asycuda.transport_childs.MeansOfTransport;
import enitity.asycuda.transport_childs.PlaceOfLoading;

public class Transport {

	private MeansOfTransport Means_of_transport;
	private String Container_flag;
	private DeliveryTerms Delivery_terms;
	private BorderOffice Border_office;
	private PlaceOfLoading Place_of_loading;
	private String Location_of_goods;
	
	public MeansOfTransport getMeans_of_transport() {
		return Means_of_transport;
	}
	@XmlElement(nillable = true, name = "Means_of_transport")
	public void setMeans_of_transport(MeansOfTransport means_of_transport) {
		Means_of_transport = means_of_transport;
	}
	public String getContainer_flag() {
		return Container_flag;
	}
	@XmlElement(nillable = true, name = "Container_flag")
	public void setContainer_flag(String container_flag) {
		Container_flag = container_flag;
	}
	public DeliveryTerms getDelivery_terms() {
		return Delivery_terms;
	}
	@XmlElement(nillable = true, name = "Delivery_terms")
	public void setDelivery_terms(DeliveryTerms delivery_terms) {
		Delivery_terms = delivery_terms;
	}
	public BorderOffice getBorder_office() {
		return Border_office;
	}
	@XmlElement(nillable = true, name = "Border_office")
	public void setBorder_office(BorderOffice border_office) {
		Border_office = border_office;
	}
	public PlaceOfLoading getPlace_of_loading() {
		return Place_of_loading;
	}
	@XmlElement(nillable = true, name = "Place_of_loading")
	public void setPlace_of_loading(PlaceOfLoading place_of_loading) {
		Place_of_loading = place_of_loading;
	}
	public String getLocation_of_goods() {
		return Location_of_goods;
	}
	@XmlElement(nillable = true, name = "Location_of_goods")
	public void setLocation_of_goods(String location_of_goods) {
		Location_of_goods = location_of_goods;
	}
	
	
}
