/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henry
 */
public class PhieuMuon {

    private String MAPM;
    private String THOIDIEMLAP;
    private String HAN;
    private String MANV;
    private String MAPHONG;
    private String TRANGTHAI;

    public String getMAPM() {
        return MAPM;
    }

    public void setMAPM(String MAPM) {
        this.MAPM = MAPM;
    }

    public String getTHOIDIEMLAP() {
        return THOIDIEMLAP;
    }

    public void setTHOIDIEMLAP(String THOIDIEMLAP) {
        this.THOIDIEMLAP = THOIDIEMLAP;
    }

    public String getHAN() {
        return HAN;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setHAN(String HAN) {
        this.HAN = HAN;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public PhieuMuon(String MAPM, String THOIDIEMLAP, String HAN, String MANV, String MAPHONG, String TRANGTHAI) {
        this.MAPM = MAPM;
        this.THOIDIEMLAP = THOIDIEMLAP;
        this.HAN = HAN;
        this.MANV = MANV;
        this.MAPHONG = MAPHONG;
        this.TRANGTHAI = TRANGTHAI;
    }

    public static PhieuMuon getPhieuMuon(String maPM) {
        PhieuMuon pm = null;
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT MAPM, THOIDIEMLAP, HAN, MANV, MAPHONG, TRANGTHAI FROM PHIEUMUON WHERE MAPM = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maPM);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String THOIDIEMLAP = fmt.format(rs.getTimestamp("THOIDIEMLAP"));
                String HAN = fmt.format(rs.getTimestamp("HAN"));
                String MANV = rs.getString("MANV");
                String MAPHONG = rs.getString("MAPHONG");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                pm = new PhieuMuon(maPM, THOIDIEMLAP, HAN, MANV, MAPHONG, TRANGTHAI);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pm;
    }

    public static List<PhieuMuon> getAllPhieuMuon() {
        List<PhieuMuon> listPhieuMuon = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT MAPM, THOIDIEMLAP, HAN, MANV, MAPHONG, TRANGTHAI FROM PHIEUMUON";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MAPM = rs.getString("MAPM");
                String THOIDIEMLAP = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String MANV = rs.getString("MANV");
                String MAPHONG = rs.getString("MAPHONG");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                PhieuMuon pm = new PhieuMuon(MAPM, THOIDIEMLAP, HAN, MANV, MAPHONG,TRANGTHAI);
                listPhieuMuon.add(pm);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPhieuMuon;
    }

    public static String maPhong(String str) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseHelper.getConnection();
            String sql = "SELECT MAPHONG FROM PHIEUMUON WHERE MAPM = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, str);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String maphong = rs.getString("MAPHONG");
                return maphong;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public static boolean checkMaPM(String MaPM) {
        boolean exists = false;
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT COUNT(*) FROM PHIEUMUON WHERE MAPM = '" + MaPM + "'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    exists = (count > 0);
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;

    }

    public static String laymapm(String maphong) {
        String mapm = null;
        String sql = "SELECT MAPM FROM PHIEUMUON "
                + "WHERE PHIEUMUON.TRANGTHAI = 6 AND MAPHONG = ?";
        try {
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, maphong);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mapm = rs.getString("MAPM");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mapm;
    }
}
