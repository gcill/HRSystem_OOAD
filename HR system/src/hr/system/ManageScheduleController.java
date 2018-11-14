/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ManageScheduleController implements Initializable {
    @FXML private TableView<String> TableSch;
    @FXML private Label Date;
    @FXML private Label Department;
    @FXML private TableColumn<String, String> idCol;
    @FXML private TableColumn<String, String> DateCol;
    @FXML private TableColumn<String, String> CLKinCol;
    @FXML private TableColumn<String, String> CLKoutCol;
    @FXML private Button Submitbtn;
    @FXML private ChoiceBox<String> idchoice;
    @FXML private TextField CLKinfield;
    @FXML private TextField DateField;
    @FXML private TextField CLKoutfield;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
        Department.setText("Marketing");
        DateField.getText();
        CLKinfield.getText();
        CLKoutfield.getText();
        

          Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            
            String sq = " SELECT * FROM employee WHERE department = 'Marketing';";
            System.out.println(sq);
            
            ResultSet rec = s.executeQuery(sq);
            
            while((rec!=null) && (rec.next()))
            {          
               String n = rec.getString("id"); 
               System.out.println(n);
               idchoice.getItems().addAll(n);
            }
            rec.close();
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }  
    }
      public ObservableList<String> data = FXCollections.observableArrayList(
            "1","1","1","1");
     @FXML
    void TableSch(ActionEvent event) {

    }

    @FXML
    private void ClicktoSubmit(ActionEvent event) {
        
    
    }


   
    @FXML
    private void Clicktoadd(ActionEvent event) {
        TableSch.setEditable(true);
        idCol.setCellValueFactory(new PropertyValueFactory<String, String>(idchoice.getValue()));
        DateCol.setCellValueFactory(new PropertyValueFactory<String, String>(DateField.getText()));
        CLKinCol.setCellValueFactory(new PropertyValueFactory<String, String>(CLKinfield.getText()));
        CLKoutCol.setCellValueFactory(new PropertyValueFactory<String, String>(CLKoutfield.getText()));
        
        TableSch.setItems(data);
        
        System.out.println(idchoice.getValue());
        System.out.println(DateField.getText());
        System.out.println(CLKinfield.getText());
        System.out.println(CLKoutfield.getText());
    }
    
}
