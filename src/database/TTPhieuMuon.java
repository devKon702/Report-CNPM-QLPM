/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henry
 */
public class TTPhieuMuon {
    private String ID;
    private String TEN;
    private String MSSV;
    private String EMAIL;
    private String SDT;
    private String MATB;
    private String TRANGTHAI;
    private String MAPHONG;

    public TTPhieuMuon(String ID, String TEN, String MSSV, String SDT, String MATB, String TRANGTHAI, String MAPHONG) {
        this.ID = ID;
        this.TEN = TEN;
        this.MSSV = MSSV;
        this.EMAIL = MSSV.toLowerCase() + "@student.ptithcm.edu.vn";
        this.SDT = SDT;
        this.MATB = MATB;
        this.TRANGTHAI = TRANGTHAI;
        this.MAPHONG = MAPHONG;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public TTPhieuMuon() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMATB() {
        return MATB;
    }

    public void setMATB(String MATB) {
        this.MATB = MATB;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
            public static List<TTPhieuMuon> getPhieuMuonList(String str) {
        List<TTPhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();
            
            String sql = "SELECT CTPHIEUMUON.ID , SINHVIEN.TENSV, CTPHIEUMUON.MSSV, CTPHIEUMUON.SDT, CTPHIEUMUON.MATB, CTPHIEUMUON.TRANGTHAI,PHIEUMUON.MAPHONG FROM CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV JOIN PHIEUMUON ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM WHERE CTPHIEUMUON.MAPM ='"+ str+"'" ;
            PreparedStatement stmt = conn.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String TEN = rs.getString("TENSV");
                String MSSV = rs.getString("MSSV");
                String SDT = rs.getString("SDT");
                String MATB = rs.getString("MATB");
                String MATRANGTHAI = rs.getString("TRANGTHAI");
                String MAPHONG = rs.getString("MAPHONG");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TTPhieuMuon pm = new TTPhieuMuon(ID, TEN, MSSV, SDT, MATB, MATRANGTHAI,MAPHONG);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       public static List<TTPhieuMuon> getPhieuMuonListTB(String MP, String ML) {
        List<TTPhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();
            
            String sql = "SELECT CTPHIEUMUON.ID , SINHVIEN.TENSV, CTPHIEUMUON.MSSV, CTPHIEUMUON.SDT, CTPHIEUMUON.MATB, CTPHIEUMUON.TRANGTHAI,PHIEUMUON.MAPHONG "
                    + "FROM CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV JOIN PHIEUMUON ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM "
                    + "JOIN THIETBI ON CTPHIEUMUON.MATB=THIETBI.MATB WHERE PHIEUMUON.MAPM ='"+ MP +"' AND THIETBI.MALOAI='"+ML+"'" ;
            PreparedStatement stmt = conn.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String TEN = rs.getString("TENSV");
                String MSSV = rs.getString("MSSV");
                String SDT = rs.getString("SDT");
                String MATB = rs.getString("MATB");
                String MATRANGTHAI = rs.getString("TRANGTHAI");
                String MAPHONG = rs.getString("MAPHONG");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TTPhieuMuon pm = new TTPhieuMuon(ID, TEN, MSSV, SDT, MATB, MATRANGTHAI,MAPHONG);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       public static String updateTb(String Matb, String Mapm) {
           String a="";
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT ID FROM CTPHIEUMUON WHERE MAPM = ? AND MATB = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, Mapm);
        stmt.setString(2, Matb);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            a = rs.getString("ID");
        }
        conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}
