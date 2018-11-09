 
package hr.system; 
 
import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.StackPane; 
import javafx.stage.Stage; 
 
// writing test in this class 
public class main extends Application{ 
 
 
    @Override 
    public void start(Stage stage) throws Exception { 
        Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml")); 
        
        Scene scene = new Scene(root); 
         
        stage.setScene(scene); 
        stage.show(); 
    } 
     
     public static void main(String[] args) { 
        launch(args); 
    } 
     
} 
