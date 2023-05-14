/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kartc
 */
public class OwnerDashboardController implements Initializable {

    @FXML
    private Button btnBooks;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnLogout;
    private Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        
        if(event.getSource() == btnBooks)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Books.fxml"));
                    Parent root = loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("ownerDashboard.fxml"));
                    BooksController booksController = loader.getController();
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
        if(event.getSource() == btnCustomers)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerOwner.fxml"));
                    Parent root = loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("ownerDashboard.fxml"));
                    OwnerDashboardController oOwnerDashboardController = loader.getController();
                    BooksController booksController = loader.getController();
                    booksController.
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
        if(event.getSource() == btnLogout)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                    Parent root = loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("ownerDashboard.fxml"));
                    FXMLDocumentController fFXMLDocumentController = loader.getController();
                    //everything above this commend in this if statement i got from this video 
                    //https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
                    // no idea how it works but thank god it does
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle("Bookstore");
                    //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();
        }
    }
    
}
