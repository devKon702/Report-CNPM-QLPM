
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.ArrayList;

import model.NhanVien;

public class NhanVienDAO implements DAOInterface<NhanVien>{

    @Override
    public boolean insert(NhanVien obj) {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO NHANVIEN(TEN,CCCD,NGAY_LAM,NGAY_NGHI,EMAIL,SDT)"
                    + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTen());
            ps.setString(2, obj.getCccd());
            ps.setString(3, obj.getNgayLam());
            ps.setString(4, obj.getNgayNghi());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getSdt());
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
    public boolean delete(NhanVien obj) {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM NHANVIEN WHERE MANV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getMa());
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
    public boolean update(NhanVien obj) {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE NHANVIEN "
                    + "SET "
                    + "TEN=?"
                    + ", CCCD=?"
                    + ", NGAY_LAM=?"
                    + ", NGAY_NGHI=?"
                    + ", EMAIL=?"
                    + ", SDT=?"
                    + " WHERE MANV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTen());
            ps.setString(2, obj.getCccd());
            ps.setString(3, obj.getNgayLam());
            ps.setString(4, obj.getNgayNghi());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getSdt());
            ps.setString(7, obj.getMa());
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
    public ArrayList<NhanVien> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM NHANVIEN";
        ArrayList<NhanVien> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MANV");
                String ten = rs.getString("TEN");
                String cccd = rs.getString("CCCD");
                String ngayLam = rs.getString("NGAY_LAM");
                String ngayNghi = rs.getString("NGAY_NGHI");
                String email = rs.getString("EMAIL");
                String sdt = rs.getString("SDT");
                ds.add(new NhanVien(ma, ten, cccd, sdt, email, ngayLam,ngayNghi));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    
    public NhanVien get(String ma) {
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM NHANVIEN WHERE MANV=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ten = rs.getString("TEN");
                String cccd = rs.getString("CCCD");
                String ngayLam = rs.getString("NGAY_LAM");
                String ngayNghi = rs.getString("NGAY_NGHI");
                String email = rs.getString("EMAIL");
                String sdt = rs.getString("SDT");
                conn.close();
                ps.close();
                return new NhanVien(ma, ten, cccd, sdt, email, ngayLam, ngayNghi);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public NhanVien getNhanVien_CCCD(String cccd){
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM NHANVIEN WHERE CCCD=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cccd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ma = rs.getString("MANV");
                String ten = rs.getString("TEN");
                String ngayLam = rs.getString("NGAY_LAM");
                String ngayNghi = rs.getString("NGAY_NGHI");
                String email = rs.getString("EMAIL");
                String sdt = rs.getString("SDT");
                return new NhanVien(ma, ten, cccd, sdt, email, ngayLam, ngayNghi);
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
