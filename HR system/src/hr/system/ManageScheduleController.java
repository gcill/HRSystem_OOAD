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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author natthanan
 */
public class ManageScheduleController extends ClockinUiManagerController implements Initializable {
    @FXML private TableView<ManageSchedule> TableSch;
    @FXML private Label Date;
    @FXML private Label Department;
    @FXML private TableColumn<ManageSchedule, String> idCol;
    @FXML private TableColumn<ManageSchedule, String> DateCol;
    @FXML private TableColumn<ManageSchedule, String> CLKinCol;
    @FXML private TableColumn<ManageSchedule, String> CLKoutCol;
    @FXML private Button Submitbtn;
    @FXML private ChoiceBox<String> idchoice;
    @FXML private TextField CLKoutSec;
    @FXML private DatePicker DateField;
    @FXML private TextField CLKoutHour;
    @FXML private TextField CLKinSec;
    @FXML private TextField CLKinHour;
    @FXML private Button datebtn;
    @FXML private Button CLKinbtn;
    @FXML private Button CLKoutbtn;
    private DatePicker checkInDatePicker;
    private Stage stage;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        Date.setText(dtf.format(now));
        try{
                UIbus bus = UIbus.getInstance();
                Staff staff = getStaff(bus.username);
                Department.setText(staff.getDepartment());
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClockinUiManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClockinUiManagerController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        idCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("Username"));
        DateCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("Date"));
        CLKinCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKin"));
        CLKoutCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKout"));
        
        TableSch.setItems(getData());
    
        TableSch.setEditable(true);
        
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        DateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        CLKinCol.setCellFactory(TextFieldTableCell.forTableColumn());
        CLKoutCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        Connection connect = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            UIbus bus = UIbus.getInstance();
            Staff staff = getStaff(bus.username);
            
            
            String sq = " SELECT * FROM employee WHERE department = '"+ staff.getDepartment()  + "' AND special IS NULL;";
            System.out.println(sq);
            
            ResultSet rec = s.executeQuery(sq);
            
            while((rec!=null) && (rec.next()))
            {          
               String n = rec.getString("username"); 
               System.out.println(n);
               idchoice.getItems().addAll(n);

            }
            rec.close();
         }  catch (Exception e) {    
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }  
         
       
    }
      public ObservableList<ManageSchedule> getData() 
    {
        ObservableList<ManageSchedule> data = FXCollections.observableArrayList();
        return data;
    } 
    
    @FXML
    void TableSch(ActionEvent event) {

    }

    @FXML
    private void ClicktoSubmit(ActionEvent event) throws ClassNotFoundException, SQLException {
        ////set to class session
         System.out.print("nnn");
         
         ManageSchedule m = new ManageSchedule();
        
         
         /////เก็บข้อมูลในตารางเป็น Arraylist
         List <List<String>> arrList = new ArrayList<>();
         System.out.print("\n");
        
         for(int i=0;i<TableSch.getItems().size();i++)
         {
             System.out.println("nnn");
             m = TableSch.getItems().get(i);
             arrList.add(new ArrayList<>());
             arrList.get(i).add(""+m.getUsername());
             arrList.get(i).add(""+m.getDate());
             arrList.get(i).add(""+m.getCLKin());
             arrList.get(i).add(""+m.getCLKout());
         }
         ////////set ข้อมูลเข้าดาต้าเบส วนทีละแถวของตาราง
         for(int i=0;i < arrList.size();i++){
                 ////set everything in session ///username             ///date             //clocjin            //clockout
                 Session session = new Session(arrList.get(i).get(0),arrList.get(i).get(1),arrList.get(i).get(2),arrList.get(i).get(3));
                 //session.setUsername(arrList.get(i).get(0)); //// username
                 //session.setDate(arrList.get(i).get(1));     //// date
                 //session.setCLKin(arrList.get(i).get(2));     //// clockintime
                 //session.setCLKout(arrList.get(i).get(3));   //// clockouttime
                 

                /////(SQLmapper)
                 setSession(arrList.get(i).get(0),arrList.get(i).get(1),arrList.get(i).get(2),arrList.get(i).get(3));
                 
            }
          JOptionPane.showMessageDialog(null,"Sucsessfull");
         
         
       
    }


   
    @FXML
    private void Clicktoadd(ActionEvent event) {
        
        /*ObservableList<ManageSchedule> dataCol = FXCollections.observableArrayList();
        
        for(ManageSchedule bean : getData())
        {
            if(! bean.getRemark())
        }
        
        TableSch.setEditable(true);
        idCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("id"));
        DateCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("Date"));
        CLKinCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKin"));
        CLKoutCol.setCellValueFactory(new PropertyValueFactory<ManageSchedule, String>("CLKout"));
        
        TableSch.setItems(getData());

        
        */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        String date1 = dtf.format(DateField.getValue());
        ManageSchedule newData = new ManageSchedule(idchoice.getValue(),date1,CLKinHour.getText(),CLKinSec.getText(),CLKoutHour.getText(),CLKoutSec.getText());
        //System.out.print(idchoice.getValue());
        TableSch.getItems().add(newData);
        
}
    public void changeIdCellEvent(CellEditEvent edittedCell)
    {
       ManageSchedule Idselect = TableSch.getSelectionModel().getSelectedItem();
        Idselect.setUsername(edittedCell.getNewValue().toString());
    }
    public void changeDateCellEvent(CellEditEvent edittedCell)
    {
        ManageSchedule Dateselect = TableSch.getSelectionModel().getSelectedItem();
        Dateselect.setDate(edittedCell.getNewValue().toString());
    }
    public void changeCLKinCellEvent(CellEditEvent edittedCell)
    {
        ManageSchedule CLKinselect = TableSch.getSelectionModel().getSelectedItem();
        CLKinselect.setCLKin(edittedCell.getNewValue().toString());
    }
    public void changeCLKoutCellEvent(CellEditEvent edittedCell)
    {
        ManageSchedule CLKoutselect = TableSch.getSelectionModel().getSelectedItem();
        CLKoutselect.setCLKout(edittedCell.getNewValue().toString());
        System.out.print(CLKoutselect);
    }
       @FXML
    void SelectDate(ActionEvent event) {
    
        String formattedDate = DateField.getValue().toString();
        //System.out.print(formattedDate);
     
     }

    
        
    @FXML
    void SelectCLKin(ActionEvent event) {

    }

    @FXML
    void SelectCLKout(ActionEvent event) {

    }

    
}
