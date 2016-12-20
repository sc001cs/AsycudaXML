package configuration;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.exception.ExceptionUtils;

import enitity.Asycuda;
import javafx.scene.control.Alert.AlertType;

public class ConvertObjectToXMLString {

	/**
	 * @param ASYCUDA
	 * @return String converted by Object
	 */
	public String convertObjectXML(Asycuda ASYCUDA) {
		
		AlertMsg alertMsg = new AlertMsg();
		String finalXML = "";
		
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Asycuda.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);

			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(ASYCUDA, stringWriter);

			String xml = stringWriter.toString();
			String xmlClear = xml.replace(" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
			String nullClear = xmlClear.replace("null", "<null/>");
			String changeStandaloneHeader = nullClear.replace("standalone=\"yes\"", "standalone=\"no\"");
			finalXML = changeStandaloneHeader;

	//		System.out.println( finalXML );

		} catch (JAXBException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		}
		
		return finalXML;
	}
}
