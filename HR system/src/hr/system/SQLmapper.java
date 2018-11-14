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
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            
            String sql1 = "SELECT * FROM employee WHERE id = '"+ id + "';";
            System.out.println(sql1);
            ResultSet rec1 = s.executeQuery(sql1);
            
            String username = rec1.getString("username");
            int password = rec1.getInt("password");
            boolean isManager = rec1.getBoolean("isManager");
        
        Connection connect = null;
        Account users = new Account();
      
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem" +"?user=root&password=net0802310965");
            Statement s = connect.createStatement();
            users.setUsername(username);
            users.setPassword(password);
            users.setIsManager(isManager);
                   
            }catch (Exception e) {
            
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
