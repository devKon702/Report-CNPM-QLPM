package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henry
 */
public class LoaiTB {
    private String MALOAI;
    private String TENLOAI;

    public LoaiTB() {
    }

    public LoaiTB(String MALOAI, String TENLOAI) {
        this.MALOAI = MALOAI;
        this.TENLOAI = TENLOAI;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }
        public static void themLoai(String Ma,String Ten){
         try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO LOAITHIETBI  (MALOAI,TENLOAI) VALUES ('"+ Ma+"','"+Ten+"')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
         public static void suaLoai(String Ma,String Ten){
         try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE LOAITHIETBI SET TENLOAI = '"+Ten+"'"+" WHERE MALOAI ='"+ Ma+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
         public static void xoaLoai(String Ma){
         try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "DELETE FROM LOAITHIETBI WHERE MALOAI ='"+ Ma+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    public static boolean kiemTraLoai(String Ma) throws SQLException {
    Connection conn = DatabaseHelper.getConnection();
    String sql = "SELECT COUNT(*) FROM THIETBI WHERE MALOAI=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, Ma);
    ResultSet rs = stmt.executeQuery();
    boolean exist = false;
    if (rs.next() && rs.getInt(1) > 0) {
        System.out.println(rs.getInt(1));
        exist = true;
    }
     System.out.println(rs.getInt(1));

    rs.close();
    stmt.close();
    conn.close();
    return exist;
}
    public static boolean kiemTraLoaiTB(String Ma) throws SQLException {
    Connection conn = DatabaseHelper.getConnection();
    String sql = "SELECT COUNT(*) FROM LOAITHIETBI WHERE MALOAI=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, Ma);
    ResultSet rs = stmt.executeQuery();
    boolean exist = false;
    if (rs.next() && rs.getInt(1) > 0) {
        System.out.println(rs.getInt(1));
        exist = true;
    }
     System.out.println(rs.getInt(1));

    rs.close();
    stmt.close();
    conn.close();
    return exist;
}
}
