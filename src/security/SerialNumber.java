package security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import javafx.scene.control.Alert.AlertType;

public class SerialNumber {

	public static String getSerialNumber(String drive) {
		  AlertMsg alertMsg = new AlertMsg();
		  String result = "";
		    try {
		      File file = File.createTempFile("realhowto",".vbs");
		      file.deleteOnExit();
		      FileWriter fw = new java.io.FileWriter(file);

		      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
		                  +"Set colDrives = objFSO.Drives\n"
		                  +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
		                  +"Wscript.Echo objDrive.SerialNumber";  // see note
		      fw.write(vbs);
		      fw.close();
		      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
		      BufferedReader input =
		        new BufferedReader
		          (new InputStreamReader(p.getInputStream()));
		      String line;
		      while ((line = input.readLine()) != null) {
		         result += line;
		      }
		      input.close();
		    }
		    catch(Exception e){
		    	alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		    }
		    return result.trim();
		  }
	
}
