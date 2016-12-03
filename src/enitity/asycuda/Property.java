package enitity.asycuda;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import enitity.asycuda.property_childs.Forms;
import enitity.asycuda.property_childs.Nbers;
import enitity.asycuda.property_childs.PlaceOfDeclaration;

public class Property {

	private String Sad_flow;
	private Forms Forms;
	private Nbers Nbers;
	private String Place_of_declaration;
	private Date Date_of_declaration;
	private String Selected_page;
	
	public String getSad_flow() {
		return Sad_flow;
	}
	@XmlElement(nillable = true, name = "Sad_flow")
	public void setSad_flow(String sad_flow) {
		Sad_flow = sad_flow;
	}
	public Forms getForms() {
		return Forms;
	}
	@XmlElement(nillable = true, name = "Forms")
	public void setForms(Forms forms) {
		Forms = forms;
	}
	public Nbers getNbers() {
		return Nbers;
	}
	@XmlElement(nillable = true, name = "Nbers")
	public void setNbers(Nbers nbers) {
		Nbers = nbers;
	}
	public String getPlace_of_declaration() {
		return Place_of_declaration;
	}
	@XmlElement(nillable = true, name = "Place_of_declaration")
	public void setPlace_of_declaration(String place_of_declaration) {
		Place_of_declaration = place_of_declaration;
	}
	public Date getDate_of_declaration() {
		return Date_of_declaration;
	}
	@XmlElement(nillable = true, name = "Date_of_declaration")
	public void setDate_of_declaration(Date date_of_declaration) {
		Date_of_declaration = date_of_declaration;
	}
	public String getSelected_page() {
		return Selected_page;
	}
	@XmlElement(nillable = true, name = "Selected_page")
	public void setSelected_page(String selected_page) {
		Selected_page = selected_page;
	}
	
	
	
}
