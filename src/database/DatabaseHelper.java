package database;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
     public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLPM;user=CNPM;password=123;encrypt=false";
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
        
        return conn;
    }

}
