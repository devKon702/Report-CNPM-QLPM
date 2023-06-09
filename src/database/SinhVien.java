/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author henry
 */
public class SinhVien {
    private String MSSV;
    private String TEN;
    private String LOP;
    private String EMAIL;
    
    public SinhVien() {
    }

    public SinhVien(String MSSV, String TEN, String LOP, String EMAIL) {
        this.MSSV = MSSV;
        this.TEN = TEN;
        this.LOP = LOP;
        this.EMAIL = EMAIL;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTEN() {
        return TEN;
    }
    
    public String getEMAIL(){
        return EMAIL;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getLOP() {
        return LOP;
    }

    public void setLOP(String LOP) {
        this.LOP = LOP;
    }


    public static SinhVien getSinhVien(String mssv){
        SinhVien sv = null;
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM SINHVIEN WHERE MSSV = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mssv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String ten = rs.getString("TENSV");
                String lop = rs.getString("LOP");
                String email = rs.getString("EMAIL");
                sv = new SinhVien(mssv, ten, lop, email);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
     public static List<SinhVien> getAllSinhVien() throws SQLException {
        List<SinhVien> list = new ArrayList<>();

        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM SINHVIEN";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String mssv = rs.getString("MSSV");
            String ten = rs.getString("TENSV");
            String lop = rs.getString("LOP");
            String email = rs.getString("EMAIL");
            SinhVien sv = new SinhVien(mssv, ten, lop, email);
            list.add(sv);
        }

        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
public static String getNameByMSSV(String mssv) throws SQLException {
    String name = null;
    
    String sql = "SELECT TENSV FROM SINHVIEN WHERE MSSV = ?";
    try (Connection conn = DatabaseHelper.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, mssv);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                name = rs.getString("TENSV");
            }
        }
    }
    
    return name;
}
 public static boolean kiemTraSV(String Mssv) throws SQLException {
    Connection conn = DatabaseHelper.getConnection();
    String sql = "SELECT COUNT(*) FROM SINHVIEN WHERE MSSV=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, Mssv);
    ResultSet rs = stmt.executeQuery();
    boolean exist = false;
    if (rs.next() && rs.getInt(1) > 0) {
        exist = true;
    }
    rs.close();
    stmt.close();
    conn.close();
    return exist;
}
}
