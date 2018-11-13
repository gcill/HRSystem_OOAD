package hr.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SQLmapper {
    
    public Staff getStaff(int id) throws IOException{
        
        Connection connect = null;
        Staff employee = new Staff();
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=qUvKm3L7WwcG5Rz");
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id;
            System.out.println(sql1);
            ResultSet result = s.executeQuery(sql1);
            System.out.println(result);
            
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String address = result.getString("address");
            String position = result.getString("position");
            int departmentID = result.getInt("departmentID");
            int salary = result.getInt("salary");
            
            employee.setName(name);
            employee.setAddress(address);
            employee.setDepartmentID(departmentID);
            employee.setLastname(lastname);
            employee.setSalary(salary);
            employee.setPosition(position);          
             
           }catch (Exception e) {
            
            }
           return employee;
    }
    
    public Account getUsers(int username) throws IOException{
        
        Connection connect = null;
        Account users = new Account();
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=qUvKm3L7WwcG5Rz");
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM users WHERE username = '"+ username;
            System.out.println(sql1);
            ResultSet result = s.executeQuery(sql1);
            System.out.println(result);
            
            
            int id = result.getInt("id");
            users.setId(id);
            String usersname = result.getString("username");
            users.setUsername(usersname);
            int password = result.getInt("password");
            users.setId(password);
             
           }catch (Exception e) {
            
            }
           return users;
    }
}
