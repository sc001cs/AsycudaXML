package configuration;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import enitity.Asycuda;

public class ConvertObjectToXMLString {

	/**
	 * @param ASYCUDA
	 * @return String converted by Object
	 */
	public String convertObjectXML(Asycuda ASYCUDA) {
		
		String finalXML = "";
		
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Asycuda.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(ASYCUDA, stringWriter);

			String xml = stringWriter.toString();
			String xmlClear = xml.replace(" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
			String nullClear = xmlClear.replace("null", "<null/>");
			finalXML = nullClear;

			System.out.println( nullClear );

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return finalXML;
	}
}
