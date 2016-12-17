package configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.xml.ConfigXML;
import javafx.scene.control.Alert.AlertType;
import modules.GenerateXMLFINAL;

public class ConfigFileExcel {

	AlertMsg alertMsg = new AlertMsg();

	/**
	 * Convert the file Excel to byte array
	 * @param pathExcel
	 * @return byte array of Excel converted
	 */
	public byte[] getByteFromFile(String pathExcel) {

		if(pathExcel == null && pathExcel.equals(""))
			return null;

		Path path = Paths.get(pathExcel);
		byte[] data = null;

		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Template Excel me emer: " + pathExcel + " nuk u gjen!", null);
		}

		return data;
	}

	
	/**
	 * @param hmGenInfoColsNameAndPosit
	 * @param value
	 * @return get key by value
	 */
	public int getKeyByValueHashMap(HashMap<Integer, String> hmGenInfoColsNameAndPosit, String value) {
		hmGenInfoColsNameAndPosit.get(1);
		int index = 999;
		for (Entry<Integer, String> entry : hmGenInfoColsNameAndPosit.entrySet()) {
            if (entry.getValue().equals(value)) {
            	index = entry.getKey();
            	break;
            }
        }
		
		if(index == 999) {
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", " Posizionimi i vleres: " + value + " nuk u gjen!", null);
		}
		
		return index;
	}
	
	public ConfigXML getConfigXML() {

		try {  
			
			String configLoc = "C:\\config.xml";
			
			File file = new File(configLoc);  
			JAXBContext jaxbContext = JAXBContext.newInstance(ConfigXML.class);  

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			ConfigXML configXML= (ConfigXML) jaxbUnmarshaller.unmarshal(file);  

			return configXML;
		} catch (JAXBException e) {  
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", ExceptionUtils.getStackTrace(e), null);
			
			return null;
		}  

	}  
	
}
