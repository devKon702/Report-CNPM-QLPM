/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author henry
 */
public class TablePhieuMuon {

    private String ID;
    private String MAPM;
    private String MATB;

    private String MSSV;
    private String TEN;
    private String THOIDIEMMUON;
    private String HAN;
    private String TRANGTHAI;

    public TablePhieuMuon() {
    }

    public String getMATB() {
        return MATB;
    }

    public void setMATB(String MATB) {
        this.MATB = MATB;
    }

    public TablePhieuMuon(String ID, String MAPM, String MATB, String MSSV, String TEN, String THOIDIEMMUON, String HAN, String TRANGTHAI) {
        this.ID = ID;
        this.MAPM = MAPM;
        this.MATB = MATB;
        this.MSSV = MSSV;
        this.TEN = TEN;
        this.THOIDIEMMUON = THOIDIEMMUON;
        this.HAN = HAN;
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMAPM() {
        return MAPM;
    }

    public void setMAPM(String MAPM) {
        this.MAPM = MAPM;
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

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getTHOIDIEMMUON() {
        return THOIDIEMMUON;
    }

    public void setTHOIDIEMMUON(String THOIDIEMMUON) {
        this.THOIDIEMMUON = THOIDIEMMUON;
    }

    public String getHAN() {
        return HAN;
    }

    public void setHAN(String HAN) {
        this.HAN = HAN;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public static List<TablePhieuMuon> getPhieuMuonList() {
        List<TablePhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();

            String sql = "SELECT CTPHIEUMUON.ID, CTPHIEUMUON.MAPM,CTPHIEUMUON.MATB, CTPHIEUMUON.MSSV, "
                    + "SINHVIEN.TENSV, PHIEUMUON.THOIDIEMLAP, PHIEUMUON.HAN, CTPHIEUMUON.TRANGTHAI FROM "
                    + "CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV JOIN PHIEUMUON "
                    + "ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String MAPM = rs.getString("MAPM");
                String MATB = rs.getString("MATB");
                String MSSV = rs.getString("MSSV");
                String TEN = rs.getString("TENSV");
                String THOIDIEMMUON = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TablePhieuMuon pm = new TablePhieuMuon(ID, MAPM, MATB, MSSV, TEN, THOIDIEMMUON, HAN, TRANGTHAI);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return list;
    }

    public static List<TablePhieuMuon> shortTable(String str) {
        List<TablePhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();

            String sql = "SELECT CTPHIEUMUON.ID, CTPHIEUMUON.MAPM,CTPHIEUMUON.MATB, CTPHIEUMUON.MSSV, SINHVIEN.TENSV, PHIEUMUON.THOIDIEMLAP, PHIEUMUON.HAN, CTPHIEUMUON.TRANGTHAI FROM "
                    + "CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV "
                    + "JOIN PHIEUMUON ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM WHERE CTPHIEUMUON.ID LIKE N'%" + str + "%'"
                    + "OR CTPHIEUMUON.MAPM LIKE N'%" + str + "%'"
                    + "OR CTPHIEUMUON.MATB LIKE N'%" + str + "%'"
                    + "OR CTPHIEUMUON.MSSV LIKE N'%" + str + "%'"
                    + "OR SINHVIEN.TENSV LIKE N'%" + str + "%'"
                    + "OR PHIEUMUON.THOIDIEMLAP LIKE N'%" + str + "%'"
                    + "OR PHIEUMUON.HAN LIKE N'%" + str + "%'"
                    + "OR CTPHIEUMUON.TRANGTHAI LIKE N'%" + str + "%'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String MAPM = rs.getString("MAPM");
                String MATB = rs.getString("MATB");
                String MSSV = rs.getString("MSSV");
                String TEN = rs.getString("TENSV");
                String THOIDIEMMUON = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TablePhieuMuon pm = new TablePhieuMuon(ID, MAPM, MATB, MSSV, TEN, THOIDIEMMUON, HAN, TRANGTHAI);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<TablePhieuMuon> findTable(String kieu, String ten) {
        List<TablePhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();

            String sql = "SELECT CTPHIEUMUON.ID, CTPHIEUMUON.MAPM,CTPHIEUMUON.MATB, CTPHIEUMUON.MSSV, SINHVIEN.TENSV, PHIEUMUON.THOIDIEMLAP, PHIEUMUON.HAN, CTPHIEUMUON.TRANGTHAI FROM "
                    + "CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV JOIN PHIEUMUON ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM  ORDER BY " + ten + " " + kieu;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String MAPM = rs.getString("MAPM");
                String MATB = rs.getString("MATB");
                String MSSV = rs.getString("MSSV");
                String TEN = rs.getString("TENSV");
                String THOIDIEMMUON = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TablePhieuMuon pm = new TablePhieuMuon(ID, MAPM, MATB, MSSV, TEN, THOIDIEMMUON, HAN, TRANGTHAI);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<TablePhieuMuon> quaHan() {
        List<TablePhieuMuon> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnection();

            String sql = "SELECT CTPHIEUMUON.ID, CTPHIEUMUON.MAPM,CTPHIEUMUON.MATB, CTPHIEUMUON.MSSV, SINHVIEN.TENSV, PHIEUMUON.THOIDIEMLAP, PHIEUMUON.HAN, CTPHIEUMUON.TRANGTHAI FROM "
                    + "CTPHIEUMUON JOIN SINHVIEN ON CTPHIEUMUON.MSSV = SINHVIEN.MSSV JOIN PHIEUMUON ON CTPHIEUMUON.MAPM = PHIEUMUON.MAPM WHERE PHIEUMUON.HAN < NOW() AND CTPHIEUMUON.TRANGTHAI= 6 ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String MAPM = rs.getString("MAPM");
                String MATB = rs.getString("MATB");
                String MSSV = rs.getString("MSSV");
                String TEN = rs.getString("TENSV");
                String THOIDIEMMUON = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String TRANGTHAI = rs.getString("TRANGTHAI");
                // Tạo đối tượng TablePhieuMuon từ dữ liệu truy vấn được
                TablePhieuMuon pm = new TablePhieuMuon(ID, MAPM, MATB, MSSV, TEN, THOIDIEMMUON, HAN, TRANGTHAI);
                // Thêm đối tượng vào danh sách
                list.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
