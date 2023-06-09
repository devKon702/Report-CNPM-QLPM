
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TrangThai;

public class TrangThaiDAO implements DAOInterface{
    @Override
    public boolean insert(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public ArrayList<TrangThai> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM TRANGTHAI";
        ArrayList<TrangThai> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ma = rs.getInt("MATRANGTHAI");
                String ten = rs.getString("TENTRANGTHAI");
                String loai = rs.getString("LOAITRANGTHAI");
                ds.add(new TrangThai(ma,ten,loai));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public TrangThai getTrangThai(int ma){
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM TRANGTHAI WHERE MATRANGTHAI=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ten = rs.getString("TENTRANGTHAI");
                String loai = rs.getString("LOAITRANGTHAI");
                return new TrangThai(ma, ten, loai);
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String getTenTrangThai(int ma){
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) TENTRANGTHAI FROM TRANGTHAI WHERE MATRANGTHAI=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("TENTRANGTHAI");
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public int getMaTrangThai(String tenTrangThai, String loaiTrangThai){
        Connection conn = DAO.getConnection();
        String sql = "SELECT MATRANGTHAI FROM TRANGTHAI WHERE TENTRANGTHAI=? AND LOAITRANGTHAI=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenTrangThai);
            ps.setString(2,loaiTrangThai);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("MATRANGTHAI");
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }
    
}
