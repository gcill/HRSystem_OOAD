package hr.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLmapper {
    
    static private PreparedStatement preparedStatement;
    static private DBHandler dbHandler;
    static private Connection connection;
    
    public Staff getStaff(int id) throws ClassNotFoundException, SQLException{
        
            Staff employee = new Staff();
            dbHandler = new DBHandler();
            connection = dbHandler.getDBConnection();
            
            String query = "SELECT * FROM employee WHERE id = "+ id + ";";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
        
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
        
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
                
            }
             
           return employee;
    }
    
    public Account getAccount(int id)throws ClassNotFoundException, SQLException{
        
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
        Account users = new Account();
       
        String query = "SELECT * FROM account WHERE id = "+ id + ";";
        System.out.println(query);
        preparedStatement = connection.prepareStatement(query);
            
        ResultSet result = preparedStatement.executeQuery();
        if(result.next()){
            
            String username = result.getString("username");
            int password = result.getInt("password");
            String special = result.getString("special");
            
            users.setUsername(username);
            users.setPassword(password);
            users.setSpecial(special);
            
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
