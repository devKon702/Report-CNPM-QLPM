package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLPM;user=CNPM;password=123;encrypt=false";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                return DriverManager.getConnection(url);
            } catch (SQLException ex) {
            }
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }

    public static ResultSet executeSelectSp(String sql) {
        ResultSet res = null;
        try {
            CallableStatement cs;
            Connection conn = DAO.getConnection();
            cs = conn.prepareCall(sql);
            res = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static void executeUpdateSp(String sql) throws SQLException {
        CallableStatement cs;
        Connection conn = DAO.getConnection();
        cs = conn.prepareCall(sql);
        cs.executeUpdate();
        cs.close();
        conn.close();
    }
}
