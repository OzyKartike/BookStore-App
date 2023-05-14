/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kartc
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField textUsername;
    @FXML
    private PasswordField textPassword;
    @FXML
    private Label errorMessage;
    private Stage stage;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        if(event.getSource() == button)
        {
            String username = textUsername.getText();
            String password = textPassword.getText();
            if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
            {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerDashboard.fxml"));
                    Parent root = loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("ownerDashboard.fxml"));
                    OwnerDashboardController oOwnerDashboardController = loader.getController();
                    //everything above this commend in this if statement i got from this video 
                    //https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
                    // no idea how it works but thank god it does
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle("Bookstore");
                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();
            }
            else 
                errorMessage.setText("Error with Username/Password");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
