/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ClockinUiController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
        //name.setText(Singleton.getInstance().getName());
        
         name.setText("Bruno");
         lastname.setText("Mars");
         Position.setText("Developer");
         department.setText("IT Support");
    }    

      @FXML
    private Label Position;

    @FXML
    private Button Approvebtn;

    @FXML
    private Label name;

    @FXML
    private Label department;

    @FXML
    private Button Clockinbtn;

    @FXML
    private Label Date;

    @FXML
    private Label lastname;

    @FXML
    void ClicktoClockin(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("CLKinSuccess.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
           
           /*clockinfailed not match with schedule
           Parent root = FXMLLoader.load(getClass().getResource("Clockinfailed.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();*/
    }

    @FXML
    void ClicktoApprove(ActionEvent event)throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("ApproveWork.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
    }

}

   
    
