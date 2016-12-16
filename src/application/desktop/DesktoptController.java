package application.desktop;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import configuration.ConfigFileExcel;
import configuration.xml.ConfigXML;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import logic.MyNumber;
import modules.GenerateXMLFINAL;

public class DesktoptController implements Initializable {

	@FXML private Button btnUploadExcel;
	@FXML private ListView listXMLConverted;
	@FXML private Label lblLoading;
	@FXML private ProgressBar progBarLoading;
	
	final MyNumber myNum = new MyNumber();
	private BooleanProperty visibleProgress = new SimpleBooleanProperty(false);
	
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
			
			visibleProgress.set(true);
			
			myNum.setNumber(0);
			myNum.numberProperty().addListener(new ChangeListener<Object>() {
				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					progBarLoading.progressProperty().bind(myNum.numberProperty());
				}
			});
			
			genXML.startGeneration(fileExcel.getAbsolutePath(), pathFolder, myNum);

			myNum.setNumber(0.9);
			
			addItemXMLToList(pathFolder);
			
			myNum.setNumber(1.0);
			
			visibleProgress.set(false);
			
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
		
		visibleProgress.set(false);
		progBarLoading.visibleProperty().bind(visibleProgress);
		
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
