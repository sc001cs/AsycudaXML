package modules;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import configuration.ConvertObjectToXMLString;
import configuration.xml.ConfigXML;
import enitity.Asycuda;
import javafx.scene.control.Alert.AlertType;
import logic.GetCurrencyAndAmount;
import logic.elaboration.GeneralInfoPositionCell;
import logic.elaboration.ListItemsPositionCell;
import multi_item.GeneralInfoExcel;

public class GenerateXMLFINAL {

	AlertMsg alertMsg = new AlertMsg();
	
	public HashMap<String, List<String>> startGeneration(String nameFile, String pathFolder) {

		
		
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
		Asycuda ASYCUDA = new Asycuda();
		String utf8 = configXML.getGeneral().getUtf8();
		String fileOutput = configXML.getGeneral().getName_file_output() + sCertDate +".xml";
		String finalXML = "";
		GeneralInfoPositionCell genInfoPosCell = new GeneralInfoPositionCell();
		HashMap<Integer, String> hmGenInfoColsNameAndPosit = genInfoPosCell.hmGenInfoColsName();
		ListItemsPositionCell listItemsPosCell = new ListItemsPositionCell();
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
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		} catch (FileNotFoundException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		} catch (IOException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		}
		
		return null;
	}
}
