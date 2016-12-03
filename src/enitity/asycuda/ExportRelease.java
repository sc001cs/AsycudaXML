package enitity.asycuda;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

public class ExportRelease {

	private Date Date_of_exit;
	private Date Time_of_exit;
	private String Actual_office_of_exit_code;
	private String Actual_office_of_exit_name;
	private String Exit_reference;
	private String Comments;
	
	public Date getDate_of_exit() {
		return Date_of_exit;
	}
	@XmlElement(nillable = true, name = "Date_of_exit")
	public void setDate_of_exit(Date date_of_exit) {
		Date_of_exit = date_of_exit;
	}
	public Date getTime_of_exit() {
		return Time_of_exit;
	}
	@XmlElement(nillable = true, name = "Time_of_exit")
	public void setTime_of_exit(Date time_of_exit) {
		Time_of_exit = time_of_exit;
	}
	public String getActual_office_of_exit_code() {
		return Actual_office_of_exit_code;
	}
	@XmlElement(nillable = true, name = "Actual_office_of_exit_code")
	public void setActual_office_of_exit_code(String actual_office_of_exit_code) {
		Actual_office_of_exit_code = actual_office_of_exit_code;
	}
	public String getActual_office_of_exit_name() {
		return Actual_office_of_exit_name;
	}
	@XmlElement(nillable = true, name = "Actual_office_of_exit_name")
	public void setActual_office_of_exit_name(String actual_office_of_exit_name) {
		Actual_office_of_exit_name = actual_office_of_exit_name;
	}
	public String getExit_reference() {
		return Exit_reference;
	}
	@XmlElement(nillable = true, name = "Exit_reference")
	public void setExit_reference(String exit_reference) {
		Exit_reference = exit_reference;
	}
	public String getComments() {
		return Comments;
	}
	@XmlElement(nillable = true, name = "Comments")
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
}
