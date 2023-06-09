package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Loai;

public class LoaiDAO implements DAOInterface<Loai> {

    @Override
    public boolean insert(Loai obj) {
//        Connection conn = DAO.getConnection();
//        String sql = "INSERT INTO LOAI(MA_LOAI,TEN_LOAI) "
//                + "VALUES (?,?)";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, obj.getMaLoai());
//            ps.setString(2, obj.getTenLoai());
//            ps.executeUpdate();
//            conn.close();
//            ps.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
        return false;
    }

    @Override
    public boolean delete(Loai obj) {
//        try {
//            Connection conn = DAO.getConnection();
//            String sql = "DELETE FROM LOAI WHERE MA_LOAI=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, obj.getMaLoai());
//            ps.executeUpdate();
//            conn.close();
//            ps.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
        return false;
    }

    @Override
    public boolean update(Loai obj) {
//        try {
//            Connection conn = DAO.getConnection();
//            String sql = "UPDATE LOAI "
//                    + "SET "
//                    + "TEN_LOAI=? "
//                    + "WHERE MA_TB=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.executeUpdate();
//            conn.close();
//            ps.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
        return false;
    }

    @Override
    public ArrayList<Loai> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM LOAITHIETBI";
        ArrayList<Loai> ds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MALOAI");
                String ten = rs.getString("TENLOAI");
                ds.add(new Loai(ma, ten));
            }
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }

    public String[] getTenLoai() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT TENLOAI FROM LOAITHIETBI";
        ArrayList<String> ds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("TENLOAI");
                ds.add(ten);
            }
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] a = new String[ds.size()];
        for (int i = 0; i < ds.size(); i++) {
            a[i] = ds.get(i);
        }
        return a;
    }

    public String getLoai(String ma) {
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) TENLOAI FROM LOAITHIETBI WHERE MALOAI=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("TENLOAI");
            }
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getMaLoai(String tenLoai){
        Connection conn = DAO.getConnection();
        String sql = "SELECT MALOAI FROM LOAITHIETBI WHERE TENLOAI=N'" + tenLoai + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("MALOAI");
            }
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
