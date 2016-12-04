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
import logic.elaboration.GeneralInfoPositionCell;
import logic.elaboration.GeneralInfoValidation;
import logic.elaboration.ListItemsPositionCell;
import multi_item.GeneralInfoExcel;
import multi_item.ListItemsExcel;

public class GenerateXMLFINAL {

	public static void main(String[] args) {

		ConfigFileExcel configFileExcel = new ConfigFileExcel();
		GeneralInfoExcel genInfoExcel = new GeneralInfoExcel();
		ListItemsExcel listItemsExcel = new ListItemsExcel();
		ConvertObjectToXMLString objToXMLString = new ConvertObjectToXMLString();
		GeneralInfoPositionCell genInfoPosCell = new GeneralInfoPositionCell();
		ListItemsPositionCell listItemsPosCell = new ListItemsPositionCell();
		Asycuda ASYCUDA = new Asycuda();
		String utf8 = "UTF-8";
		String nameFile = "E:\\TemplateAsycudaTempMulti.xlsx";
		String fileOutput = "E:\\asycuda_generated.xml";
		String finalXML = "";
		HashMap<Integer, String> hmGenInfoColsNameAndPosit = genInfoPosCell.hmGenInfoColsName();
		HashMap<Integer, String> hmListItemsColsNameAndPosit = listItemsPosCell.hmListItemsColsName();
		
		byte[] byteExcel = configFileExcel.getByteFromFile(nameFile);
		
		/* ----------------------------------------
		 * ASYCUDA: THE FIRST SHEET -> GENERAL INFO
		 * ----------------------------------------*/
		ASYCUDA = genInfoExcel.writeValueFromGeneralInfoExcel(byteExcel, hmGenInfoColsNameAndPosit);

		/* ----------------------------------------
		 * ASYCUDA: THE SECOND SHEET -> LIST ITEMS
		 * ----------------------------------------*/
		ASYCUDA = listItemsExcel.writeValueListItems(byteExcel, ASYCUDA, hmListItemsColsNameAndPosit);
		
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