package modules;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;

import configuration.ConfigFileExcel;
import configuration.ConvertObjectToXMLString;
import configuration.xml.ConfigXML;
import enitity.Asycuda;
import javafx.scene.control.ProgressBar;
import logic.GetCurrencyAndAmount;
import logic.MyNumber;
import logic.elaboration.GeneralInfoPositionCell;
import logic.elaboration.ListItemsPositionCell;
import multi_item.GeneralInfoExcel;

public class GenerateXMLFINAL {

	public void startGeneration(String nameFile, String pathFolder) {

		ConfigFileExcel configFileExcel = new ConfigFileExcel();
		ConfigXML configXML = configFileExcel.getConfigXML();
		
		if(configXML == null) {
			System.err.println("File config xml not found!");
			System.exit(0);
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(configXML.getGeneral().getData_format_file());
		String sCertDate = dateFormat.format(new Date());
		
		
		GeneralInfoExcel genInfoExcel = new GeneralInfoExcel();
		GetCurrencyAndAmount currAndAmount = new GetCurrencyAndAmount();
		String currencyExchange = currAndAmount.getCurrencyExchangeBSH();
		
		ConvertObjectToXMLString objToXMLString = new ConvertObjectToXMLString();
		GeneralInfoPositionCell genInfoPosCell = new GeneralInfoPositionCell();
		ListItemsPositionCell listItemsPosCell = new ListItemsPositionCell();
		Asycuda ASYCUDA = new Asycuda();
		String utf8 = configXML.getGeneral().getUtf8();
	//	String nameFile = configXML.getGeneral().getName_file_excel();
		String fileOutput = configXML.getGeneral().getName_file_output() + sCertDate +".xml";
		String finalXML = "";
		HashMap<Integer, String> hmGenInfoColsNameAndPosit = genInfoPosCell.hmGenInfoColsName();
		HashMap<Integer, String> hmListItemsColsNameAndPosit = listItemsPosCell.hmListItemsColsName();
		
		byte[] byteExcel = configFileExcel.getByteFromFile(nameFile);
		
		/* ------------------------------------------
		 * ASYCUDA: THE FIRST SHEET  -> GENERAL INFO
		 *  		THE SECOND SHEET -> LIST ITEMS
		 * -----------------------------------------*/
		ASYCUDA = genInfoExcel.writeValueFromGeneralInfoExcel(byteExcel, currencyExchange, hmGenInfoColsNameAndPosit, hmListItemsColsNameAndPosit);


		/* --------------------------------------
		 * CONSOLE: PRINT OUT THE ASYCUDA OBJECT
		 * --------------------------------------*/
		finalXML = objToXMLString.convertObjectXML(ASYCUDA);
		
		// Create and write the XML file 
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(pathFolder + "\\" +fileOutput), utf8))) {
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
