 
package hr.system; 
 
import java.sql.Connection;
import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.StackPane; 
import javafx.stage.Stage; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
 
// writing test in this class 

public class main extends Application{ 
 
 
    @Override 
    public void start(Stage stage) throws Exception { 
        
        Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml")); 
         //Parent root = FXMLLoader.load(getClass().getResource("ManageSchedule.fxml")); 
        //testfor HR add Employee to databases
        //Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
        Scene scene = new Scene(root); 
         
        stage.setScene(scene); 
        stage.show(); 
    } 
     
     public static void main(String[] args) { 
       
          launch(args); 
        }
} 
     
     

