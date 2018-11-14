/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ApproveEmployeeWorkController implements Initializable {

    @FXML
    private Label Date;
    @FXML
    private Label Department;
    @FXML
    private TableColumn<?, ?> checkboxcol;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> lastnameCol;
    @FXML
    private TableColumn<?, ?> WorkCol;
    @FXML
    private Button Approvebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
        Department.setText("Marketing");
        
    }    

    @FXML
    private void ClicktoApprove(ActionEvent event) {
    }
    
}
