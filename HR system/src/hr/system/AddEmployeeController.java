/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class AddEmployeeController implements Initializable {

    @FXML
    private TextField createposition;

    @FXML
    private TextField createsalary;

    @FXML
    private TextField createdepartment;

    @FXML
    private TextField createid;

    @FXML
    private TextField createpassword;

    @FXML
    private TextField createlastname;

    @FXML
    private Button addbtn;

    @FXML
    private TextField createtype;

    @FXML
    private TextField createname;
    
    String query;
  
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         createname.getText();
         createlastname.getText();
         createdepartment.getText();
         createposition.getText();
         createtype.getText();
         createsalary.getText();
         createid.getText();
         createpassword.getText();
        
        
        
    }

    @FXML
    private void ClickAdd(ActionEvent event) {
        Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement stmt = connect.createStatement();
            
            
            query = "insert into employee(id,password,name,lastname,department,position,type,salary)values('"+createid.getText()+"','"+createpassword.getText()+"','"+createname.getText()+"','"+createlastname.getText()+"','"+createdepartment.getText()+"','"+createposition.getText()+"','"+createtype.getText()+"','"+createsalary.getText()+"');";
            System.out.println(query);
           
            stmt.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Successfully AddEmployee");
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }
        
        
    }
    
}
