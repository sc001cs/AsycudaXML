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
			e.printStackTrace();
		}
		
		return finalXML;
	}
}
