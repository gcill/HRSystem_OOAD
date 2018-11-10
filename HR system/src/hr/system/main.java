 
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
 
// writing test in this class 

public class main extends Application{ 
 
 
    @Override 
    public void start(Stage stage) throws Exception { 
        Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml")); 
        //testfor HR add Employee to databases
        //Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        Scene scene = new Scene(root); 
         
        stage.setScene(scene); 
        stage.show(); 
    } 
     
     public static void main(String[] args) { 
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +
            "?user=root&password=net0802310965");
            if(connect != null){
            System.out.println("Database Connected.");
            } else {
            System.out.println("Database Connect Failed.");
            }
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
            // Close
            try {
            if(connect != null){
            connect.close();
            }
            } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            } 
          launch(args); 
        }
} 
     
     

