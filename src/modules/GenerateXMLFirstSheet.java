package modules;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.xml.bind.*;

import configuration.ConfigFileExcel;
import configuration.ConvertObjectToXMLString;
import enitity.Asycuda;
import enitity.asycuda.Item;
import enitity.asycuda.item_childs.Tarification;
import multi_item.GeneralInfoExcel;

public class GenerateXMLFirstSheet {

	public static void main(String[] args) {

		ConfigFileExcel configFileExcel = new ConfigFileExcel();
		GeneralInfoExcel genInfoExcel = new GeneralInfoExcel();
		ConvertObjectToXMLString objToXMLString = new ConvertObjectToXMLString();
		Asycuda ASYCUDA = new Asycuda();
		String utf8 = "UTF-8";
		String nameFile = "E:\\TemplateAsycudaTempMulti.xlsx";
		String fileOutput = "E:\\asycuda_first_sheet.xml";
		String finalXML = "";

		byte[] byteExcel = configFileExcel.getByteFromFile(nameFile);
		ASYCUDA = genInfoExcel.writeValueFromGeneralInfoExcel(byteExcel);

		/* --------------------------------------
		 * CONSOLE: PRINT OUT THE ASYCUDA OBJECT
		 * --------------------------------------*/
		finalXML = objToXMLString.convertObjectXML(ASYCUDA);
		
		// Create and write the XML file 
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileOutput), utf8))) {
			writer.write(finalXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



}
