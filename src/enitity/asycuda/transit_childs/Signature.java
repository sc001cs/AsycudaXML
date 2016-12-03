package enitity.asycuda.transit_childs;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Signature {

	private String Place;
	private Date Date;
	
	public String getPlace() {
		return Place;
	}
	@XmlElement(nillable = true, name = "Place")
	public void setPlace(String place) {
		Place = place;
	}
	public Date getDate() {
		return Date;
	}
	@XmlElement(nillable = true, name = "Date")
	public void setDate(Date date) {
		Date = date;
	}
	
	
}
