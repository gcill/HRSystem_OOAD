/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JFileChooser;


/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ApproveWorkController implements Initializable {

    @FXML
    private Label Date;
    @FXML
    private Button Choosebtn;
    @FXML
    private Label FilesUpload;
    @FXML
    private Button Uploadbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
    }    

    @FXML
    private void ClicktoChoosefiles(ActionEvent event) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Choose file");
        if (ret == JFileChooser.APPROVE_OPTION) {
        FilesUpload.setText(fileopen.getSelectedFile().toString());
        }
}


    

    private Connection ConnectDB() throws SQLException {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection("jdbc:mysql://localhost/mydatabase" +
        "?user=root&password=net0802310965");
        } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } 
         return null;

}
    
    @FXML
    private void ClicktoUpload(ActionEvent event) {
            

            }
    // Save Data

   
}
         

