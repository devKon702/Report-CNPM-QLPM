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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

/**
 *
 * @author henry
 */
public class ThietBi {

    private String MATB;
    private String TEN;
    private String TRANG_THAI;
    private String MALOAI;
    private String MAPHONG;

    public ThietBi() {
    }

    public ThietBi(String MATB, String TEN, String TRANG_THAI, String MALOAI, String MAPHONG) {
        this.MATB = MATB;
        this.TEN = TEN;
        this.TRANG_THAI = TRANG_THAI;
        this.MALOAI = MALOAI;
        this.MAPHONG = MAPHONG;
    }

    public String getMATB() {
        return MATB;
    }

    public void setMATB(String MATB) {
        this.MATB = MATB;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(String TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public static List<ThietBi> getAllThietBi() throws Exception {
        List<ThietBi> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM THIETBI";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String maTB = rs.getString("MATB");
            String tenTB = rs.getString("TENTB");
            String trangThai = rs.getString("TINHTRANG");
            String maLoai = rs.getString("MALOAI");
            String maPhong = rs.getString("MAPHONG");
            ThietBi tb = new ThietBi(maTB, tenTB, trangThai, maLoai, maPhong);
            list.add(tb);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    public static List<ThietBi> getThietBiChung(String maloai) {
        List<ThietBi> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM THIETBI WHERE MAPHONG is null AND MALOAI ='" + maloai + "' ";
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maTB = rs.getString("MATB");
                String tenTB = rs.getString("TENTB");
                String trangThai = rs.getString("TINHTRANG");
                String maLoai = rs.getString("MALOAI");
                String maPhong = rs.getString("MAPHONG");
                ThietBi tb = new ThietBi(maTB, tenTB, trangThai, maLoai, maPhong);
                list.add(tb);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<ThietBi> getThietBi(String maphong, String maloai) {
        List<ThietBi> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM THIETBI WHERE MAPHONG = '" + maphong + "' AND MALOAI ='" + maloai + "' ";

        ResultSet rs;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String maTB = rs.getString("MATB");
                String tenTB = rs.getString("TENTB");
                String trangThai = rs.getString("TINHTRANG");
                String maLoai = rs.getString("MALOAI");
                String maPhong = rs.getString("MAPHONG");
                ThietBi tb = new ThietBi(maTB, tenTB, trangThai, maLoai, maPhong);
                list.add(tb);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static List<ThietBi> getThietBiDangMuon(String mapm, String maloai) {
        List<ThietBi> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "Select THIETBI.MATB, TENTB, TINHTRANG, MALOAI, MAPHONG From THIETBI inner join CTPHIEUMUON on THIETBI.MATB = CTPHIEUMUON.MATB "
                + "Where TRANGTHAI = 6 AND CTPHIEUMUON.MAPM = ? AND MALOAI = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mapm);
            stmt.setString(2, maloai);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maTB = rs.getString("MATB");
                String tenTB = rs.getString("TENTB");
                String trangThai = rs.getString("TINHTRANG");
                String maLoai = rs.getString("MALOAI");
                String maPhong = rs.getString("MAPHONG");
                ThietBi tb = new ThietBi(maTB, tenTB, trangThai, maLoai, maPhong);
                list.add(tb);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static ThietBi getThietBi(String matb) throws Exception {
        ThietBi list = new ThietBi();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT * FROM THIETBI WHERE MATB = '" + matb + "' ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String maTB = rs.getString("MATB");
            String tenTB = rs.getString("TENTB");
            String trangThai = rs.getString("TINHTRANG");
            String maLoai = rs.getString("MALOAI");
            String maPhong = rs.getString("MAPHONG");
            ThietBi tb = new ThietBi(maTB, tenTB, trangThai, maLoai, maPhong);
            list = tb;
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

}
