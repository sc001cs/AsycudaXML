package modules;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;

import configuration.ConfigFileExcel;
import configuration.ConvertObjectToXMLString;
import enitity.Asycuda;
import logic.elaboration.GeneralInfoPositionCell;
import logic.elaboration.ListItemsPositionCell;
import multi_item.GeneralInfoExcel;

public class GenerateXMLFINAL {

	public static void main(String[] args) {

		ConfigFileExcel configFileExcel = new ConfigFileExcel();
		GeneralInfoExcel genInfoExcel = new GeneralInfoExcel();
		
		ConvertObjectToXMLString objToXMLString = new ConvertObjectToXMLString();
		GeneralInfoPositionCell genInfoPosCell = new GeneralInfoPositionCell();
		ListItemsPositionCell listItemsPosCell = new ListItemsPositionCell();
		Asycuda ASYCUDA = new Asycuda();
		String utf8 = "UTF-8";
		String nameFile = "D:\\TemplateAsycudaTempMulti.xlsx";
		String fileOutput = "D:\\asycuda_generated.xml";
		String finalXML = "";
		HashMap<Integer, String> hmGenInfoColsNameAndPosit = genInfoPosCell.hmGenInfoColsName();
		HashMap<Integer, String> hmListItemsColsNameAndPosit = listItemsPosCell.hmListItemsColsName();
		
		byte[] byteExcel = configFileExcel.getByteFromFile(nameFile);
		
		/* ------------------------------------------
		 * ASYCUDA: THE FIRST SHEET  -> GENERAL INFO
		 *  		THE SECOND SHEET -> LIST ITEMS
		 * -----------------------------------------*/
		ASYCUDA = genInfoExcel.writeValueFromGeneralInfoExcel(byteExcel, hmGenInfoColsNameAndPosit, hmListItemsColsNameAndPosit);


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
