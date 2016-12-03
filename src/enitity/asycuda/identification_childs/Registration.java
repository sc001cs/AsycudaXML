package enitity.asycuda.identification_childs;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Registration {

	private String Serial_number;
	private String Number;
	private Date Date;
	
	public String getSerial_number() {
		return Serial_number;
	}
	@XmlElement(nillable = true, name = "Serial_number")
	public void setSerial_number(String serial_number) {
		Serial_number = serial_number;
	}
	public String getNumber() {
		return Number;
	}
	@XmlElement(nillable = true, name = "Number")
	public void setNumber(String number) {
		Number = number;
	}
	public Date getDate() {
		return Date;
	}
	@XmlElement(nillable = true, name = "Date")
	public void setDate(Date date) {
		Date = date;
	}
	
	
}
