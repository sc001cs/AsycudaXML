package application.desktop;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import configuration.ConfigFileExcel;
import configuration.xml.ConfigXML;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import logic.MyString;
import modules.GenerateXMLFINAL;

public class DesktoptController implements Initializable {

	@FXML private Button btnUploadExcel;
	@FXML private ListView listXMLConverted;
	@FXML private Label lblConverting;
	
	GenerateXMLFINAL genXML = new GenerateXMLFINAL();
	ConfigFileExcel configFileExcel = new ConfigFileExcel();
	ConfigXML configXML = configFileExcel.getConfigXML();
	
	String pathFolder = "";
	
	public void uploadExcel(ActionEvent event) {
		
		FileChooser fileChooser  = new FileChooser();
		
		//Extention filter
		FileChooser.ExtensionFilter extentionFilter = new FileChooser.ExtensionFilter("Excel file", "*.xlsm", "*.xlsx", "*.xls");
		fileChooser.getExtensionFilters().add(extentionFilter);
		
		//Set to user directory or go to default if cannot access
		String userDirectoryString = System.getProperty("user.home");
		File userDirectory = new File(userDirectoryString);
		if(userDirectory == null && !userDirectory.canRead()) {
		    userDirectory = new File("C:/");
		}
		fileChooser.setInitialDirectory(userDirectory);
		
		File fileExcel = fileChooser.showOpenDialog(null);
		
		if(fileExcel != null) {

			genXML.startGeneration(fileExcel.getAbsolutePath(), pathFolder);

			addItemXMLToList(pathFolder);
			
		} else {
			// the file is wrong
		}
	}

	private void addItemXMLToList(String pathFolder) {

		List<String> listXMLFiles = new ArrayList<String>();
		if(pathFolder != null && !pathFolder.trim().equals("")) {

			File folder = new File(pathFolder);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					listXMLFiles.add(listOfFiles[i].getAbsolutePath());
				}
			}

		} else {
			System.err.println("ERROR FOLDER NOT FOUND");
		}

		Collections.reverse(listXMLFiles);

		if(listXMLFiles != null && listXMLFiles.size() > 0) {
			listXMLConverted.getItems().clear();
			listXMLConverted.getItems().addAll(listXMLFiles);
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/**
		 * Create the Folder if not exist and add the file generated
		 * */
		String pathTemp = "";
		if(configXML != null && configXML.getGeneral() != null 
				&& configXML.getGeneral().getPath_folder() != null) {
			pathTemp = configXML.getGeneral().getPath_folder();
		}
		File file = new File(pathTemp);
        if (!file.exists()) {
            if (file.mkdir()) {
                // System.out.println("Directory is created!");
            	pathFolder = configXML.getGeneral().getPath_folder();
            } else {
                // System.out.println("Failed to create directory!");
                pathFolder = "C:\\AsycudaConvert";
            }
        } else {
        	pathFolder = pathTemp;
        }
		
        addItemXMLToList(pathFolder);
	}

}
