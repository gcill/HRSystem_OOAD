package hr.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class SQLmapper {
    
    String dbString = "jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=qUvKm3L7WwcG5Rz";
    
    public Staff getStaff(int id) throws IOException{
        
        
        Connection connect = null;
        Staff employee = new Staff();
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection(dbString);
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id + "';";
            System.out.println(sql1);
            ResultSet result = s.executeQuery(sql1);
            System.out.println(result);
            
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String address = result.getString("address");
            String position = result.getString("position");
            String department = result.getString("department");
            int departmentId = result.getInt("departmentId");
            int salary = result.getInt("salary");
            
            employee.setName(name);
            employee.setAddress(address);
            employee.setDepartmentID(departmentId);
            employee.setLastname(lastname);
            employee.setSalary(salary);
            employee.setPosition(position);
            employee.setDepartment(department);
             
           }catch (Exception e) {
            
            }
           return employee;
    }
    

    public Account getAccount(int id) throws IOException{
        
        Connection connect = null;
        Account users = new Account();
       
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection(dbString);
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id + "';";
            System.out.println(sql1);
            ResultSet rec1 = s.executeQuery(sql1);
            
            String username = rec1.getString("username");
            int password = rec1.getInt("password");
            String special = rec1.getString("special");
            
            users.setUsername(username);
            users.setPassword(password);
            users.setSpecial(special);
             
           }catch (Exception e) {
            
            }
           return users;
    }
    public void setAccount(Account account){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect =  DriverManager.getConnection(dbString);
            Statement stmt = connect.createStatement();
            
            
            String query = "insert into account(id,username,special)values('"+account.getId()+"','"+account.getUsername()+"','"+account.getSpecial()+"');";
            System.out.println(query);
           
            stmt.executeUpdate(query);
            
            
         }  catch (Exception e) {    
             
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }
    }
    public void setStaff(Staff staff){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect =  DriverManager.getConnection(dbString);
            Statement stmt = connect.createStatement();
            
            
            String query = "insert into account(id,name,lastname,position,address,department,departmentID,salary)values('"+staff.id+"','"+staff.getName()+"','"+staff.getPosition()+"','"+staff.getAddress()+"','"+staff.getDepartment()+"','"+staff.getDepartmentID()+"','"+staff.getSalary()+"');";
            System.out.println(query);
           
            stmt.executeUpdate(query);
            
            
         }  catch (Exception e) {    
             
            JOptionPane.showMessageDialog(null,"Error AddEmployee"+e);
        }
    }
}
