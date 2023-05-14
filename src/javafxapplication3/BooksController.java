/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TablePosition;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author kartc
 */
public class BooksController implements Initializable {

    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, String> bookName;
    @FXML
    private TableColumn<Book, Double> bookPrice;
    @FXML
    private TextField txtfieldName;
    @FXML
    private TextField txtFieldPrice;
    @FXML
    private Button buttonAdd;
    @FXML
    private Label errorMessage;
    Stage stage;
    /**
     * Initializes the controller class.
     * File oldFile = new File("temp.txt");
        File newFile = new File("books.txt");
        if (oldFile.renameTo(newFile))
        {
            System.out.println("renamed");
        }
     */
    private static ArrayList<Book> books = new ArrayList<>();
    int count =0;
    private double priceness;
    private String stringess;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button backBTN;
    TableColumn numberCol = new TableColumn( "Number" );
    public Book tempCreate(String name, double price)
    {
        Book book = new Book(name,price);
        return book;
    }
    public static void fileDeleted(String fileName)
    {
        File fileObj = new File(fileName);
        try
        {
            fileObj.delete();
        }catch(Exception e)
                {
                    System.out.println("didnt delete");
                }
            fileObj.delete();
    }
    public void bookFileWrite(String name, double price) throws IOException
    {
        FileWriter bookFile = new FileWriter("books.txt", true);
            String bookInfo = name + ", " + price + "\n";
            bookFile.write(bookInfo);
        bookFile.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Filer allFile = new Filer();
        String tempBooks[][];
        try
        {
            tempBooks = allFile.readBookFile();
            count = allFile.getCount();
        } catch (IOException ex)
        {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            tempBooks = null;
        }
        for(int x = 0; x<count; x++)
        {
            System.out.println("GOT TILL 1");
            stringess = tempBooks[x][0];
            System.out.println("GOT TILL 2");
            priceness = Double.parseDouble(tempBooks[x][1]);
            System.out.println("GOT TILL 3");
            Book newNewNewBook = tempCreate(stringess, priceness);
            System.out.println("GOT TILL 4");
            table.getItems().add(newNewNewBook );
            System.out.println("GOT TILL 5");
        }
    }    

    @FXML
    private void errorMessage(ActionEvent event) throws IOException 
    {
        String newBookName = txtfieldName.getText();
        String stringNewBookPrice = txtFieldPrice.getText();
        boolean check = true;
        
        try
        {
            Double.parseDouble(stringNewBookPrice);
        }
        catch(NumberFormatException e)
        {
            errorMessage.setText("Please enter a number");
            check = false;
        }
        if (check)
        {
            errorMessage.setText("");
            Double newBookPrice = Double.valueOf(stringNewBookPrice);
            if(event.getSource() == buttonAdd)
            {
                Book book = new Book(newBookName, newBookPrice);
                table.getItems().add(book);
                bookFileWrite(newBookName, newBookPrice);
            }
        }
    }

    @FXML
    private void deleteCMD(ActionEvent event) 
    {
        int index;
        ObservableList<Book> allBook, singleBook;
        allBook = table.getItems();
        singleBook = table.getSelectionModel().getSelectedItems();
        singleBook.forEach(allBook::remove);
        index = table.getSelectionModel().getSelectedIndex();
        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        TableColumn col = pos.getTableColumn();
        Filer fileIndexDeleter = new Filer();
        fileIndexDeleter.removeRecord("books.txt",3);
        
        
        
        
        
        
        
        
        
      numberCol.setCellFactory( new Callback<TableColumn, TableCell>()
    {
    @Override
    public TableCell call( TableColumn p )
    {
        return new TableCell()
        {
            @Override
            public void updateItem( Object item, boolean empty )
            {
                super.updateItem( item, empty );
                setGraphic( null );
                setText( empty ? null : getIndex() + 1 + "" );
            }
        };
    }
});
    }

    @FXML
    private void backCMD(ActionEvent event) throws IOException 
    {
        if(event.getSource() == backBTN)
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
    }
    
}
