/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ScheduleController implements Initializable {
      @FXML
    private Label Department;

    @FXML
    private Button settingbtn;

    @FXML
    private TableColumn<?, ?> clockoutcol;

    @FXML
    private Label Date;

    @FXML
    private TableColumn<?, ?> Namecol;

    @FXML
    private TableColumn<?, ?> clockincol;

    private JTable table;
    private DefaultTableModel model;
    

    
    String sq;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
        Department.setText("Marketing");
           
  
         Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            
            sq = " SELECT * FROM employee WHERE department = 'Marketing';";
            System.out.println(sq);
            
            ResultSet rec = s.executeQuery(sq);
            
            


            int row = 0;
            while((rec!=null) && (rec.next()))
            {          
               String n = rec.getString("name"); 
               System.out.println(n);
               
              

            }
   
            rec.close();
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }
    }    

    @FXML
    private void Clicksetting(ActionEvent event) {
    }
    
}
