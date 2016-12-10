package configuration.xml;

import javax.xml.bind.annotation.XmlRootElement;

import configuration.xml.general.GeneralConfig;

@XmlRootElement  
public class ConfigXML {

	private GeneralConfig general;

	public GeneralConfig getGeneral() {
		return general;
	}

	public void setGeneral(GeneralConfig general) {
		this.general = general;
	}
	
}
