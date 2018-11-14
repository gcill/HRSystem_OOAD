package hr.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SQLmapper {
    String A ;
    String B = "Manager" ;
    int AccountType;
    public Staff getStaff(String id) throws IOException{
        
        Connection connect = null;
        Staff employee = new Staff();
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id;
            System.out.println(sql1);
            ResultSet result = s.executeQuery(sql1);
            System.out.println(result);
            
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String address = result.getString("address");
            String position = result.getString("position");
            String department = result.getString("department");
            String salary = result.getString("salary");
            
            employee.setName(name);
            employee.setAddress(address);
            employee.setDepartment(department);
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
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=net0802310965");
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
     public int getAccount(String id,String Password) throws IOException{
        
        Connection connect = null;
        Account users = new Account();
      
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id +"' AND password = '"+ Password +"';";
            System.out.println(sql1);
            ResultSet rec1 = s.executeQuery(sql1);
            if (rec1.isBeforeFirst())
            {
             while((rec1!=null)&& (rec1.next())){
                A = rec1.getString("Special");
             }
             
             if ("Manager".equals(A)){AccountType = 1;}
             else if ("HR".equals(A)){AccountType = 2;}
             else AccountType = 3;
            }
            else AccountType = 4;
             
           }catch (Exception e) {
            
            }
           return AccountType;
    }
}
