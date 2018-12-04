package hr.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLmapper {
    
    static private PreparedStatement preparedStatement;
    static private DBHandler dbHandler;
    static private Connection connection;
    
    public Staff getStaff(String username) throws ClassNotFoundException, SQLException{
        
            Staff employee = new Staff();
            dbHandler = new DBHandler();
            connection = dbHandler.getDBConnection();
            
            String query = "SELECT * FROM employee WHERE username = '"+ username + "';";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
        
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
              
                int id = result.getInt("id");
             
                String name = result.getString("name");
                String lastname = result.getString("lastname");
                String address = result.getString("address");
                String position = result.getString("position");
                String department = result.getString("department");
                int departmentId = result.getInt("departmentId");
                int salary = result.getInt("salary");
                System.out.println(id);
                employee.setID(id);
                employee.setUsername(username);
                employee.setName(name);
                employee.setAddress(address);
                employee.setDepartmentID(departmentId);
                employee.setLastname(lastname);
                employee.setSalary(salary);
                employee.setPosition(position);
                employee.setDepartment(department);
                
            }
             
           return employee;
    }
    
     public Session getSession(String username) throws ClassNotFoundException, SQLException{
        
            Session session = new Session();
            dbHandler = new DBHandler();
            connection = dbHandler.getDBConnection();
            
            String query = "SELECT * FROM session WHERE username = '"+ username + "';";
            
            preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            
            System.out.println(query);
            if(result.next()){
              
                String date = result.getString("date");
                String clockintime = result.getString("clkin");
                String clockoutime = result.getString("clkout");
                
               ////set everything in session
                session.setUsername(username);
                session.setDate(date);
                session.setCLKin(clockintime);
                session.setCLKout(clockoutime);
                
            }
             return session;
          
    }
    public void setSession(String username,String date,String CLKin,String CLKout) throws ClassNotFoundException, SQLException{
            System.out.println("kk"); 
            dbHandler = new DBHandler();
            connection = dbHandler.getDBConnection();
            Statement stmt = connection.createStatement();
            //Keep in to session table
            String query = "insert into session(username,date,clkin,clkout)values('"+username+"','"+date+"','"+CLKin+"','"+CLKout+"');";
            System.out.println(query); 
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            
            
    
    }
   
    public Account getAccount(String username)throws ClassNotFoundException, SQLException{
        
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
        Account users = new Account();
       
        String query = "SELECT * FROM employee WHERE username = '"+ username + "';";
        
        preparedStatement = connection.prepareStatement(query);
        
        System.out.println(query);     
        ResultSet result = preparedStatement.executeQuery();
        if(result.next()){
            
            int id = result.getInt("id");
            int password = result.getInt("password");
            String special = result.getString("special");
            
            users.setUsername(username);
            users.setPassword(password);
            users.setSpecial(special);
            users.setId(id);
            
        }
           return users;
    }
    public void setAccount(Account account) throws ClassNotFoundException, SQLException{
        
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
        
                 
        String query = "insert into account(id,username,password,special)values("+account.getId()+",'"+account.getUsername()+"',"+account.getPassword()+",'"+account.getSpecial()+"');";
        System.out.println(query);
           
        preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.executeUpdate();
            
                 
    }
    public void setStaff(Staff staff)throws ClassNotFoundException, SQLException{
        
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
            
            
        String query = "insert into employee(id,name,lastname,position,address,department,departmentID,salary)values("+staff.id+",'"+staff.getName()+"','"+staff.getLastname()+"','"+staff.getPosition()+"','"+staff.getAddress()+"','"+staff.getDepartment()+"',"+staff.getDepartmentID()+","+staff.getSalary()+");";
        System.out.println(query);
           
        preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.executeUpdate();
            
    }
     
}
