 
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import javax.swing.JOptionPane;
 
// writing test in this class 

public class main extends Application{ 
 
    static private PreparedStatement preparedStatement;
    static private DBHandler dbHandler;
    static private Connection connection;
    
    @Override 
    public void start(Stage stage) throws Exception { 
        
        //Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml")); 
        Parent root = FXMLLoader.load(getClass().getResource("ShowSchedule.fxml"));
         //Parent root = FXMLLoader.load(getClass().getResource("ManageSchedule.fxml")); 
        //testfor HR add Employee to databases
        //Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
        Scene scene = new Scene(root); 
         
        stage.setScene(scene); 
        stage.show(); 
        
    } 
     
     public static void main(String[] args) throws ClassNotFoundException, SQLException { 
         
          /*SQLmapper mapper = new SQLmapper();
           Staff staff = new Staff();
           Account account = new Account();
           staff.setName("prayut");
           staff.setLastname("chanocha");
           staff.setPosition("nayok");
           staff.setDepartment("GGEZ");
           staff.setAddress("thailand");
           staff.setDepartmentID(1);
           staff.setSalary(0);
           
           account.setUsername("prayut");
           account.setPassword(123456);
           
           
           //mapper.setStaff(staff);
           //mapper.setAccount(account);
           
           account = mapper.getAccount(10);
           System.out.println(account.getUsername());*/
          
           launch(args);
     }
} 
     
     

