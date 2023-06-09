
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;
import model.TrangThai;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PhongHoc;
public class PhongHocDAO implements DAOInterface<PhongHoc>{

    @Override
    public boolean insert(PhongHoc obj) {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO PHONGHOC(MAPHONG,TRANGTHAI) "
                + "VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getMaPhong());
            ps.setInt(2, 3);
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
    public boolean delete(PhongHoc obj) {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM PHONGHOC WHERE MAPHONG=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getMaPhong());
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
    public boolean update(PhongHoc obj) {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE PHONGHOC "
                    + "SET "
                    + "TRANGTHAI=?"
                    + " WHERE MAPHONG=?";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,obj.getMaTrangThai());
            ps.setString(2,obj.getMaPhong());
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
    public ArrayList<PhongHoc> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM PHONGHOC";
        ArrayList<PhongHoc> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MAPHONG");
                int tt = rs.getInt("TRANGTHAI");
                ds.add(new PhongHoc(ma,tt));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public ArrayList<TrangThai> getTrangThaiPhongHoc(){
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM TRANGTHAI WHERE LOAITRANGTHAI='PH'";
        ArrayList<TrangThai> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ma = rs.getInt("MATRANGTHAI");
                String ten = rs.getString("TENTRANGTHAI");
                ds.add(new TrangThai(ma,ten,"PH"));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public PhongHoc getPhongHoc(String maPhong){
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM PHONGHOC WHERE MAPHONG=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,maPhong);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int maTrangThai = rs.getInt("TRANGTHAI");
                return new PhongHoc(maPhong,maTrangThai);
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<PhongHoc> getPhongHoc_TrangThai(int maTrangThai){
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM PHONGHOC WHERE TRANGTHAI=?";
        ArrayList<PhongHoc> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,maTrangThai);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MAPHONG");
                int tt = rs.getInt("TRANGTHAI");
                ds.add(new PhongHoc(ma,tt));
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
