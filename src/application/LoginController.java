package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML private TextField tfID;
	@FXML private TextField tfPassword;
	@FXML private Label lblWarning;

	public void login(ActionEvent event) {

		// Reset 
		lblWarning.setText("");

		if(tfID.getText().trim().equals("") 
				&& tfPassword.getText().trim().equals("")) {
			lblWarning.setText("Vendosni ID dhe password-in");
		} else if(tfID.getText().trim().equals("")) {
			lblWarning.setText("Vendosni ID");
		} else if(tfPassword.getText().trim().equals("")) {
			lblWarning.setText("Vendosni password-in");
		} else if(tfID.getText().equals("1") 
				&& tfPassword.getText().equals("1")) {

			try {
				
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage desktop = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/desktop/Desktop.fxml"));
				Scene scene = new Scene(root, 550, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				desktop.setScene(scene);
				desktop.setResizable(false);
				desktop.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			tfID.setText("");
			tfPassword.setText("");
			
		} else {
			lblWarning.setText("Password-i i futur gabim. Provoni perseri!");
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
