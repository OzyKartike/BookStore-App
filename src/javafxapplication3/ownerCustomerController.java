/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kartc
 */
public class ownerCustomerController implements Initializable {

    @FXML
    private TableView<Customer> table;
    @FXML
    private TableColumn<Customer, String> username;
    @FXML
    private TableColumn<Customer, String> password;
    @FXML
    private TableColumn<Customer, Double> points;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private TextField txtFieldPassword;
    @FXML
    private Button buttonAdd;
    @FXML
    private Label errorMessage;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button backBTN;
    private static ArrayList<Customer> customers = new ArrayList<>();
    int count =0;
    private double pointness;
    private String stringess;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void errorMessage(ActionEvent event) {
    }

    @FXML
    private void deleteCMD(ActionEvent event) {
    }

    @FXML
    private void backCMD(ActionEvent event) {
    }
    
}
