package modules;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import javax.xml.bind.*;

import enitity.Asycuda;
import enitity.asycuda.Item;
import enitity.asycuda.item_childs.Tarification;
import multi_item.GetDataFromExcelFirstSheetMultiLines;

public class GenerateXMLFirstSheet {

	public static void main(String[] args) throws IOException {

		byte[] byteExcel = GetDataFromExcelFirstSheetMultiLines.getByteFromFile("C:\\TemplateAsycudaTempMulti.xlsx");
		
		Asycuda ASYCUDA = GetDataFromExcelFirstSheetMultiLines.readValueFormExcel(byteExcel);

		try {

			File file = new File("D:\\file_first_sheet.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Asycuda.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(ASYCUDA, file);
			jaxbMarshaller.marshal(ASYCUDA, stringWriter);

			String xml = stringWriter.toString();
			String xmlClear = xml.replace(" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
			String nullClear = xmlClear.replace("null", "<null/>");

			System.out.println( nullClear );

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public List<Item> getListItems() {
		
		List<Item> listItems = new ArrayList<Item>();
		
		Item item1 = new Item();
		Item item2 = new Item();
		
		Tarification tarification = new Tarification();
		tarification.setExtended_customs_procedure("4000");
		tarification.setNational_customs_procedure("000");
		item1.setTarification(tarification);
		
		listItems.add(item1);
		listItems.add(item2);
		
		return listItems;
	}
	
}
