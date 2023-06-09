
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ThietBi;
import java.sql.ResultSet;
import model.TrangThai;

public class ThietBiDAO implements DAOInterface<ThietBi>{

    @Override
    public boolean insert(ThietBi tb) {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO THIETBI(TENTB,MALOAI,MAPHONG,TINHTRANG)"
                    + "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tb.getTen());
            ps.setString(2,tb.getMaLoai());
            ps.setString(3,tb.getPhong());
            ps.setInt(4,tb.getMaTrangThai());
            ps.executeUpdate();
            conn.close();
            ps.close();
            return true;
        } 
        catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean delete(ThietBi tb) {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM THIETBI WHERE MATB=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tb.getMa());
            ps.executeUpdate();
            conn.close();
            ps.close();
            return true;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ThietBi tb) {
        
        Connection conn = DAO.getConnection();
        String sql = "UPDATE THIETBI "
                    + "SET "
                    + "TENTB=?"
                    + ", MALOAI=?"
                    + ", MAPHONG=?"
                    + ", TINHTRANG=?"
                    + " WHERE MATB=?";
        try {    
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tb.getTen());
            ps.setString(2,tb.getMaLoai());
            ps.setString(3,tb.getPhong());
            ps.setInt(4,tb.getMaTrangThai());
            ps.setString(5,tb.getMa());
            ps.executeUpdate();
            conn.close();
            ps.close();
            return true;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<ThietBi> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM THIETBI";
        ArrayList<ThietBi> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MATB");
                String ten = rs.getString("TENTB");
                String loai = rs.getString("MALOAI");
                String phong = rs.getString("MAPHONG");
                int tt = rs.getInt("TINHTRANG");
                ds.add(new ThietBi(ma,ten,loai,phong,tt));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    
    public ThietBi getThietBi(String ma) {
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM THIETBI WHERE MATB=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ten = rs.getString("TENTB");
                String loai = rs.getString("MALOAI");
                String phong = rs.getString("MAPHONG");
                int tt = rs.getInt("TINHTRANG");
                return new ThietBi(ma,ten,loai,phong,tt);
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ThietBi> getThietBi_PhongHoc(String maPhongHoc){
        Connection conn = DAO.getConnection();
        String sql;
        if (maPhongHoc.length() == 0) sql = "SELECT * FROM THIETBI WHERE MAPHONG IS NULL";
        else sql = "SELECT * FROM THIETBI WHERE MAPHONG=?";
        ArrayList<ThietBi> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPhongHoc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MATB");
                String ten = rs.getString("TENTB");
                String loai = rs.getString("MALOAI");
                String phong = rs.getString("MAPHONG");
                int tt = rs.getInt("TINHTRANG");
                ds.add(new ThietBi(ma,ten,loai,phong,tt));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public ArrayList<TrangThai> getTrangThaiThietBi(){
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM TINHTRANG WHERE LOAITRANGTHAI='TB'";
        ArrayList<TrangThai> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ma = rs.getInt("MATRANGTHAI");
                String ten = rs.getString("TENTRANGTHAI");
                ds.add(new TrangThai(ma,ten,"TB"));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
}
