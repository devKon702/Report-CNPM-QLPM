/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.TrangThai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 
 *
 * @author henry
 */
public class TrangThai {
    private int MATRANGTHAI;
    private String TENTRANGTHAI;

    public TrangThai() {
    }

    public TrangThai(int MATRANGTHAI, String TENTRANGTHAI) {
        this.MATRANGTHAI = MATRANGTHAI;
        this.TENTRANGTHAI = TENTRANGTHAI;
    }

    public int getMATRANGTHAI() {
        return MATRANGTHAI;
    }

    public void setMATRANGTHAI(int MATRANGTHAI) {
        this.MATRANGTHAI = MATRANGTHAI;
    }

    public String getTENTRANGTHAI() {
        return TENTRANGTHAI;
    }

    public void setTENTRANGTHAI(String TENTRANGTHAI) {
        this.TENTRANGTHAI = TENTRANGTHAI;
    }
    
    public static List<TrangThai> getTrangThaiList() throws SQLException {
        List<TrangThai> trangThaiList = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection(); // assuming you have implemented getConnection() method in your code

        String sql = "SELECT MATRANGTHAI, TENTRANGTHAI FROM TRANGTHAI";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int maTrangThai = rs.getInt("MATRANGTHAI");
            String tenTrangThai = rs.getString("TENTRANGTHAI");
            TrangThai trangThai = new TrangThai(maTrangThai, tenTrangThai);
            trangThaiList.add(trangThai);
        }

        rs.close();
        stmt.close();
        conn.close();

        return trangThaiList;
    }
}
