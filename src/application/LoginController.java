package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import configuration.SetUpFolders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import security.Encrypt;
import security.SerialNumber;

public class LoginController implements Initializable {

	@FXML private TextField tfID;
	@FXML private TextField tfPassword;
	@FXML private Label lblWarning;
	
	SerialNumber sn = null;
	AlertMsg alertMsg = new AlertMsg();

	public void login(ActionEvent event) {

		// Reset 
		lblWarning.setText("");

		if(tfPassword.getText().trim().equals("")) {
			lblWarning.setText("Vendosni password-in");
		} else if(tfPassword.getText().equals("1")) {
		// } else if(tfPassword.getText().equals(catchIt())) {

			try {
				
				/**
				 * Set up all the folders and file if not exist
				 * */
				SetUpFolders suf = new SetUpFolders();
				suf.setUpTheFolders();
				
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage desktop = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/desktop/Desktop.fxml"));
				Scene scene = new Scene(root, 750, 500);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				desktop.setScene(scene);
				desktop.setResizable(false);
				desktop.show();
			} catch (Exception e) {
				alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
			}
			
			tfID.setText("");
			tfPassword.setText("");
			
		} else {
			lblWarning.setText("Password-i i futur gabim. Provoni perseri!");
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Reset 
		lblWarning.setText("");
		
		sn = new SerialNumber();
		String sn = SerialNumber.getSerialNumber("C");
		String snShort = sn;
		if(sn.length() > 5)
			snShort = sn.substring(0, 5);
		
		tfID.setText(snShort);
		tfID.setEditable(false);
	}

	private String catchIt() {
		
		String id = tfID.getText();
		if(id == null || id.trim().equals("")) {
			id = "catchIt";
		}
		
		Encrypt enc = new Encrypt();
		
		return enc.encrypt(id);
	}
	
}
