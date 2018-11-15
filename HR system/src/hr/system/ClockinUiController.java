package hr.system;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ClockinUiController extends LogInpageController implements Initializable   {

    @FXML
    private Button ApproveMywbtn;
    @FXML
    private Button Managebtn;
    @FXML
    private Button Approvebtn1;
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Date.setText(dtf.format(now));
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "LogInpage.fxm")
            );
            
            //name.setText(Singleton.getInstance().getName
            
            // singlton class for databus
            UIbus bus = UIbus.getInstance();
            
            Staff staff = getStaff(bus.id);
            name.setText(staff.getName());
            lastname.setText(staff.getLastname());
            Position.setText(staff.getPosition());
            department.setText(staff.getDepartment());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClockinUiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClockinUiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

      @FXML
    private Label Position;


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

    
    
