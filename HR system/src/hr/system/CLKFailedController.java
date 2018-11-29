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
 * @author natthanan
 */
public class CLKFailedController implements Initializable {

    @FXML
    private Button Authorizebtn;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ClicktoAuthorizes(ActionEvent event) {
    }

    @FXML
    private void ClicktoCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
    }
    
}
