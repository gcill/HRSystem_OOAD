/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ClockinUiHRController implements Initializable {

    @FXML
    private Button RemoveEmbtn;
    @FXML
    private Button AddEmbtn;
    @FXML
    private Label Position;
    @FXML
    private Label lastname;
    @FXML
    private Label department;
    @FXML
    private Label name;
    @FXML
    private Label Date;
    @FXML
    private Button Clockinbtn;

    /**
     * Initializes the controller class.
     */
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
    private void ClicktoRemoveEm(ActionEvent event) {
    }

    @FXML
    private void ClicktoAddEmployee(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
    }

    @FXML
    private void ClicktoClockin(ActionEvent event) {
    }
    
}
