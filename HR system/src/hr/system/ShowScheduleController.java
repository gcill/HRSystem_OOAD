/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ShowScheduleController implements Initializable {
    @FXML
    private TableView<ManageSchedule> ShowSch;
    @FXML
    private TableColumn<ManageSchedule, String> UsernameCol;
    @FXML
    private TableColumn<ManageSchedule, String> CLKinCol;
    @FXML
    private TableColumn<ManageSchedule, String> CLKoutCol;
    @FXML
    private TableColumn<ManageSchedule, String> StateCol;
    @FXML
    private Button Loginbtn;
    @FXML
    private Label Date;
    @FXML
    private Label Time;
       public ObservableList<ManageSchedule> getData() 
    {
        ObservableList<ManageSchedule> data = FXCollections.observableArrayList();
        return data;
    } 
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ////set current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        
        ///set current Time
         ////set current date
        DateTimeFormatter Timee = DateTimeFormatter.ofPattern("HH.mm");  
        LocalDateTime current = LocalDateTime.now();  
        Time.setText(Timee.format(current));
        
       float currenttime = Float.parseFloat(Timee.format(current)); ////Convert String -> float(Time)
       
         Connection connect = null;
         
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            
            /////setTable
            UsernameCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("Username"));
            CLKinCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKin"));
            CLKoutCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKout"));
            
            
            /////search Today Schedule on databases
            String sq = " SELECT * FROM session WHERE date = '"+ dtf.format(now)   + "' ;";
            System.out.println(sq);
            ResultSet rs = s.executeQuery(sq);
            
            while((rs!=null) && (rs.next()))
            {          
                 
                ManageSchedule newData = new ManageSchedule(rs.getString("Username"), rs.getString("clkin"),rs.getString("clkout"));
               
                float clockintime=Float.parseFloat(rs.getString("clkin"));////convert CLK in Time to float
                float clockouttime=Float.parseFloat(rs.getString("clkout"));////convert CLK out Time to float
                System.out.println("username = "+rs.getString("Username"));
                System.out.println("current time = "+currenttime);
                System.out.println("clockintime = "+clockintime);
                System.out.println("clockouttime = "+clockouttime);
                if(currenttime >=  clockintime && currenttime <  clockouttime)
                {  ShowSch.getItems().add(newData);} ////Between CLK in CLKout Time
                     
            }
            
            rs.close();
            ////set table view
           
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }  
    }    
   

    @FXML
    private void ClickLogIn(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("LogInpage.fxml"));
           Scene root_scene = new Scene(root);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(root_scene);
           app_stage.show();
    }
   
      
}
