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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LogInpageController extends SQLmapper implements Initializable{
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       id.getText();
       Password.getText();
       
       
    }    


     @FXML
    private TextField id;

    @FXML
    private PasswordField Password;
    
   
    

    @FXML
    void ClickLogin(ActionEvent event) throws IOException {
           int AccountT = getAccount(id.getText(),Password.getText());
           System.out.println(AccountT);
           Connection connect = null;
           //System.out.println(rec1);
            if(AccountT == 1)
            {  
               Parent root = FXMLLoader.load(getClass().getResource("ClockinUiManager.fxml"));
               Scene root_scene = new Scene(root);
               Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               app_stage.hide();
               app_stage.setScene(root_scene);
               app_stage.show();
              }
            else if (AccountT == 2){
               Parent root = FXMLLoader.load(getClass().getResource("ClockinUiHR.fxml"));
               Scene root_scene = new Scene(root);
               Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               app_stage.hide();
               app_stage.setScene(root_scene);
               app_stage.show();}
            else if (AccountT == 3){
               Parent root = FXMLLoader.load(getClass().getResource("ClockinUi.fxml"));
               Scene root_scene = new Scene(root);
               Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               app_stage.hide();
               app_stage.setScene(root_scene);
               app_stage.show();}
             else{ JOptionPane.showMessageDialog(null,"Wrong Username and Password");}
            
            }
           
    }
    
     
      




