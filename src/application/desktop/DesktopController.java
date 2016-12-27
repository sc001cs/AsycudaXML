package application.desktop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import configuration.ConfigFileExcel;
import configuration.FileXML;
import configuration.xml.ConfigXML;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import modules.GenerateXMLFINAL;

public class DesktopController implements Initializable {

	@FXML private Button btnUploadExcel;
	@FXML private Button btnSignOut;
	@FXML private TextField tfFilter;
	@FXML private Button btnClearFilter;
	
	@FXML private TableView<FileXML> listXMLTable;
	@FXML private TableColumn<FileXML, String> pathCol;
	@FXML private TableColumn<FileXML, String> dateCol;
//	@FXML private TableColumn<FileXML, String> absPathCol;
	@FXML private TableColumn<FileXML, String> editRowCol;
	@FXML private TableColumn<FileXML, String> deleteRowCol;
	
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
				
				genXML.startGeneration(fileExcel.getAbsolutePath());
				
				addItemXMLToListAndRefresh(pathFolder);
				
				validationProcessCovert();
				
			} catch(Exception e) {
				alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
			}
		} else {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "File nuk u aksesua!", null);
		}
	}

	private void addItemXMLToListAndRefresh(String pathFolder) {

		// Absolute path and Path
		HashMap<String, String> listXMLFilesPath = new HashMap<String, String>();
		if(pathFolder != null && !pathFolder.trim().equals("")) {

			File folder = new File(pathFolder);
			File[] listOfFiles = folder.listFiles();

			if(listOfFiles != null) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						listXMLFilesPath.put(listOfFiles[i].getAbsolutePath(), listOfFiles[i].getName());
					}
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
				alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
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
			
			btnClearFilter.setOnAction(e -> tfFilter.setText(""));
			initFilter(listTableFileXML);
			
			pathCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("path"));
			dateCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("createdDate"));
		//	absPathCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("absPathCol"));
			editRowCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("deleteRowCol"));
			editRowCol.setCellFactory( renderEditFile() );
			
			deleteRowCol.setCellValueFactory(new PropertyValueFactory<FileXML, String>("deleteRowCol"));
			deleteRowCol.setCellFactory( renderDeleteFile() );

			
			//Add click listener
			listXMLTable.setRowFactory( tv -> {
			    TableRow<FileXML> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
			        	FileXML rowData = row.getItem();
			            Path path = Paths.get(rowData.getAbsolutePath());
						try {
							Runtime.getRuntime().exec("explorer.exe /select," + path);
						} catch (IOException e) {
							alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "File " + rowData.getPath() + "nuk gjendet ne folder", null);
						}
			        }
			    });
			    return row ;
			});
			
			listXMLTable.setItems(listTableFileXML);
		} else if(listXML != null && listXML.size() == 0) {
			ObservableList<FileXML> listTableFileXML = FXCollections.observableArrayList(listXML);
			listXMLTable.setItems(listTableFileXML);
			initFilter(listTableFileXML);
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/**
		 * Create the Folder if not exist and add the file generated
		 * */
		String pathTemp = "";
		if(configXML != null && configXML.getGeneral() != null 
				&& configXML.getGeneral().getPath_folder_xml() != null) {
			pathTemp = configXML.getGeneral().getPath_folder_xml();
		}
		File file = new File(pathTemp);
        if (!file.exists()) {
            if (file.mkdir()) {
                // System.out.println("Directory is created!");
            	pathFolder = configXML.getGeneral().getPath_folder_xml();
            } else {
                // System.out.println("Failed to create directory!");
                pathFolder = "C:\\AsycudaConvert";
            }
        } else {
        	pathFolder = pathTemp;
        }
		
        addItemXMLToListAndRefresh(pathFolder);
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
	
	private Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>> renderEditFile() {

		Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>> cellFactory = 
				new Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>>() {
			@Override
			public TableCell call( final TableColumn<FileXML, String> param ) {
				final TableCell<FileXML, String> cell = new TableCell<FileXML, String>() {

					final Button btnEditFile = new Button( "Modifiko" );

					@Override
					public void updateItem( String item, boolean empty )
					{
						super.updateItem( item, empty );
						if ( empty )
						{
							setGraphic( null );
							setText( null );
						}
						else
						{
							btnEditFile.setOnAction( ( ActionEvent event ) ->
							{
								FileXML fileXML = getTableView().getItems().get( getIndex() );
								Path pathXML = Paths.get(fileXML.getAbsolutePath());

//								Alert alertDelete = new Alert(AlertType.CONFIRMATION);
//								alertDelete.setTitle("Deshironi te modifikoni kete file?");
//								alertDelete.setHeaderText("Emri i file: " + pathXML.getFileName());
								
								String[] xmlNameSplit = (pathXML.getFileName().toString()).split("\\.");
								String xmlNameWithoutExtesion = "";
								String xmlExtesion = "";
								if(xmlNameSplit.length == 2) {
									xmlNameWithoutExtesion = xmlNameSplit[0];
									xmlExtesion = xmlNameSplit[1];
								}
								
								TextInputDialog dialog = new TextInputDialog(xmlNameWithoutExtesion);
								dialog.getDialogPane().setPrefSize(450, 250);
								dialog.setTitle("Asycuda Converter");
								dialog.setHeaderText("Deshironi te modifikoni kete file?");
								dialog.setContentText("Modifiko: ");

								// Traditional way to get the response value.
								Optional<String> result = dialog.showAndWait();
								if (result.isPresent()){
									
									File oldfile = new File(fileXML.getAbsolutePath());
									File newfile = new File(configXML.getGeneral().getPath_folder_xml() + "\\" + result.get() + "." + xmlExtesion);
									
									if(oldfile.renameTo(newfile)){
										System.out.println("Rename succesful");
									}else{
										System.out.println("Rename failed");
									}
									
									alertMsg.alertMsg(AlertType.INFORMATION, "Asycuda Converter", "Emri i file u modifikua me sukses", "Emri i file: " + newfile.getName());
									try {
									    //moves mouse to the middle of the screen
									    new Robot().mouseMove((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1.9), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2.53));
									    //remember to use try-catch block (always, and remember to delete this)
									} catch (AWTException e) {
										alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
									}
									
									// Refresh the list
									addItemXMLToListAndRefresh(pathFolder);
								}
							});
							setGraphic( btnEditFile );
							setAlignment(getAlignment().CENTER);
							setText( null );
						}
					}
				};
				return cell;
			}
		};

		return cellFactory;
	}
	
	private Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>> renderDeleteFile() {

		Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>> cellFactory = 
				new Callback<TableColumn<FileXML, String>, TableCell<FileXML, String>>() {
			@Override
			public TableCell call( final TableColumn<FileXML, String> param ) {
				final TableCell<FileXML, String> cell = new TableCell<FileXML, String>() {

					final Button btnDeleteFile = new Button( "X Fshij" );

					@Override
					public void updateItem( String item, boolean empty )
					{
						super.updateItem( item, empty );
						if ( empty )
						{
							setGraphic( null );
							setText( null );
						}
						else
						{
							btnDeleteFile.setOnAction( ( ActionEvent event ) ->
							{
								FileXML fileXML = getTableView().getItems().get( getIndex() );
								Path pathXML = Paths.get(fileXML.getAbsolutePath());

								Alert alertDelete = new Alert(AlertType.CONFIRMATION);
								alertDelete.setTitle("Deshironi te fshini kete file?");
								alertDelete.setHeaderText("Emri i file: " + pathXML.getFileName());
								
								try {
								    //moves mouse to the middle of the screen
								    new Robot().mouseMove((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1.9), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2.53));
								    //remember to use try-catch block (always, and remember to delete this)
								} catch (AWTException e) {
								    e.printStackTrace();
								}
								
								Optional<ButtonType> result = alertDelete.showAndWait();
								if (result.get() == ButtonType.OK){
									// ... user chose OK
								
									try {
									    Files.delete(pathXML);
									} catch (NoSuchFileException x) {
										alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "File: " + pathXML.getFileName() + " nuk ekziston\n" +
														ExceptionUtils.getStackTrace(x), null);
									} catch (DirectoryNotEmptyException x) {
										alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Folderi nuk ekziston\n" +
												ExceptionUtils.getStackTrace(x), null);
									} catch (IOException x) {
									    // File permission problems are caught here.
										alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Nuk keni te drejtat per te fshire kete file: " 
									    + pathXML.getFileName() +"\n" +
												ExceptionUtils.getStackTrace(x), null);
									}
									// Refresh the list
									addItemXMLToListAndRefresh(pathFolder);
									
								} else {}

							} );
							setGraphic( btnDeleteFile );
							setAlignment(getAlignment().CENTER);
							setText( null );
						}
					}
				};
				return cell;
			}
		};

		return cellFactory;
	}
	
	public void signOut(ActionEvent event) {

		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Login.fxml").openStream());

			Scene scene = new Scene(root);
	//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (Exception e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		}
	}
	
	private void initFilter(ObservableList<FileXML> listTableFileXML) {
        tfFilter.textProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable o) {
                if(tfFilter.textProperty().get().isEmpty()) {
                	
                	addItemXMLToListAndRefresh(pathFolder);
                 	
                	listXMLTable.setItems(listTableFileXML);
                    return;
                }
                ObservableList<FileXML> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<FileXML, ?>> cols = listXMLTable.getColumns();
                for(int i=0; i<listTableFileXML.size(); i++) {
                    
                	//for(int j=0; j<cols.size(); j++) {
                    for(int j=0; j<1; j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(listTableFileXML.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(tfFilter.textProperty().get().toLowerCase())) {
                            tableItems.add(listTableFileXML.get(i));
                            break;
                        }                        
                    }

                }
                listXMLTable.setItems(tableItems);
            }
        });
        
        listXMLTable.setItems(listTableFileXML);
        return;
    }
	
}
