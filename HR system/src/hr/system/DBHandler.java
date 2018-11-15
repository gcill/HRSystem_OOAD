
package hr.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends DBconfig {
    Connection dbConnection;
    
    public Connection getDBConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection =  DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
}
