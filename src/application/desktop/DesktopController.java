package application.desktop;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import configuration.FileXML;
import configuration.xml.ConfigXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import modules.GenerateXMLFINAL;

public class DesktopController implements Initializable {

	@FXML private Button btnUploadExcel;
	@FXML private Label lblConverting;
	
	@FXML private TableView<FileXML> listXMLTable;
	@FXML private TableColumn<FileXML, String> pathCol;
	@FXML private TableColumn<FileXML, String> dateCol;
	@FXML private TableColumn<FileXML, String> absPathCol;
	
	GenerateXMLFINAL genXML = new GenerateXMLFINAL();
	ConfigFileExcel configFileExcel = new ConfigFileExcel();
	ConfigXML configXML = configFileExcel.getConfigXML();
	AlertMsg alertMsg = new AlertMsg();
	
	public static HashMap<String, List<String>> alerts = new HashMap<String, List<String>>();
	
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

			try {
				alerts = new HashMap<String, List<String>>();
				
				genXML.startGeneration(fileExcel.getAbsolutePath(), pathFolder);
				
				addItemXMLToList(pathFolder);
				
				validationProcessCovert();
				
			} catch(Exception e) {
				alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", ExceptionUtils.getStackTrace(e), null);
			}
		} else {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "File nuk u aksesua!", null);
		}
	}

	private void addItemXMLToList(String pathFolder) {

		// Absolute path and Path
		HashMap<String, String> listXMLFilesPath = new HashMap<String, String>();
		if(pathFolder != null && !pathFolder.trim().equals("")) {

			File folder = new File(pathFolder);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					listXMLFilesPath.put(listOfFiles[i].getAbsolutePath(), listOfFiles[i].getName());
				}
			}

		} else {
			System.err.println("ERROR FOLDER NOT FOUND");
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Sistemi nuk mund te krijoje folderin " + pathFolder, null);
		}

		List<FileXML> listXML = new ArrayList<FileXML>();
		
		for (String absPathXMLStr : listXMLFilesPath.keySet()) {
			
			Path pathXML = Paths.get(absPathXMLStr);
			
			BasicFileAttributes attr = null;
			try {
				attr = Files.readAttributes(pathXML, BasicFileAttributes.class);
				
				FileXML xml = new FileXML(listXMLFilesPath.get(absPathXMLStr), absPathXMLStr, convertFiletimeToDate(attr.creationTime()) );
				listXML.add(xml);
				
			} catch (IOException e) {
				alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", ExceptionUtils.getStackTrace(e), null);
			}
			
		}

		if(listXML != null && listXML.size() > 0) {

			Collections.sort(listXML, new Comparator<FileXML>() {
				@Override
				public int compare(final FileXML object1, final FileXML object2) {
					return object2.getCreatedDate().compareTo(object1.getCreatedDate());
				}
			});
			
			ObservableList<FileXML> listTableFileXML = FXCollections.observableArrayList(listXML);
			pathCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("path"));
			dateCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("createdDate"));
			absPathCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("absPathCol"));
			listXMLTable.setItems(listTableFileXML);
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

	private String convertFiletimeToDate(FileTime fileTime) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy kk:mm");
		String dateCreatedStr = df.format(fileTime.toMillis());

		return dateCreatedStr;
	}
	
	private void validationProcessCovert() {
		
		if(alerts.isEmpty()) {
			alertMsg.alertMsg(AlertType.INFORMATION, "Asycuda Converter", "File i konvertuar me sukses!", null);
		} else if(alerts.containsKey(AlertMsg.WARNING)) {
			
			String alertMessage = "File i konvertuar me sukses!\n";
			for (String msg : alerts.get(AlertMsg.WARNING)) {
				alertMessage += msg + "\n"; 
			}
			alertMsg.alertMsg(AlertType.INFORMATION, "Asycuda Converter", alertMessage, null);
		}
	}
	
}
