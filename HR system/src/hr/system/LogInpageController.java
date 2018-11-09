/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.io.IOException;
import java.net.URL;
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


public class LogInpageController implements Initializable{
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


     @FXML
    private TextField id;

    @FXML
    private PasswordField Password;

    @FXML
    void ClickLogin(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("ClockinUi.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
    }

}


