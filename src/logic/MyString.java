package logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyString {

	// Define a variable to store the property
	private StringProperty strProp = new SimpleStringProperty();

	// Define a getter for the property's value
	public final String getStrProp(){
		return strProp.getValue();
	}

	// Define a setter for the property's value
	public final void setStrProp(String value){
		strProp.set(value);
	}

	// Define a getter for the property itself
	public StringProperty strProperty() {
		return strProp;
	}

}
