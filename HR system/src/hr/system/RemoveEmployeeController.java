/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class RemoveEmployeeController implements Initializable {

    @FXML
    private Button selectbtn;
    @FXML
    private ComboBox<String> Department;
    @FXML
    private ComboBox<String> Employee;
    String n;
    String l;
    String idEm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Department.getItems().addAll("Marketing","IT Support");
         
         
    }    

   
    @FXML
    private void ChooseDepart(ActionEvent event) {
       Employee.getItems().clear();
        Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            
            String sq = " SELECT * FROM employee WHERE department = '"+ Department.getValue() + "';";
            System.out.println(sq);
            
            ResultSet rec = s.executeQuery(sq);
            
                while((rec!=null) && (rec.next()))
                {          
                   n = rec.getString("name"); 
                   System.out.println(n);
                   Employee.getItems().addAll(n);
                }
            
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }  
    }

    @FXML
    private void ChooseEmployee(ActionEvent event) {
        System.out.println(Employee.getValue());
        
        String sq2 = " SELECT * FROM employee WHERE name = '"+ Employee.getValue()+ "' ;";
        System.out.println(sq2);
         
        
    }
     @FXML
    private void ClicktoSelect(ActionEvent event) throws IOException {
        Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            
            String sq3 = "DELETE FROM employee WHERE name = '"+ Employee.getValue()+ "' ;";
            System.out.println(sq3);
           
            s.executeUpdate(sq3);
            
            JOptionPane.showMessageDialog(null,"Successfully RemoveEmployee");
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error RemoveEmployee"+e);
        }  
        
    }

    
}
