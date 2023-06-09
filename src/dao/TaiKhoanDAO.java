
package dao;

import java.util.ArrayList;
import java.sql.Connection;
import model.TaiKhoan;
import java.sql.*;
public class TaiKhoanDAO implements DAOInterface<TaiKhoan> {
    @Override
    public boolean insert(TaiKhoan tk) {
        try {
            Connection conn = DAO.getConnection();
            String sql = "INSERT INTO TAIKHOAN (TENTK,MATKHAU,QUYEN) "
                    + "VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getTk());
            ps.setString(2, tk.getMk());
            ps.setInt(3, tk.getQuyen());
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
    public boolean delete(TaiKhoan tk) {
        if(tk.getQuyen() == 0) return false;
        try{
            Connection conn = DAO.getConnection();
            String sql = "DELETE FROM TAIKHOAN WHERE TENTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tk.getTk());
            ps.executeUpdate();
            conn.close();
            ps.close();
            return true;
        }
        catch(SQLException ex){
            return false;
        }
    }

    @Override
    public boolean update(TaiKhoan tk) {
        try{
            Connection conn = DAO.getConnection();
            String sql = "UPDATE TAIKHOAN SET MATKHAU=ENCRYPTBYPASSPHRASE('sa','"+tk.getMk()+"'), QUYEN=? WHERE TENTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tk.getQuyen());
            ps.setString(2, tk.getTk());
            ps.executeUpdate();
            conn.close();
            ps.close();
            return true;
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<TaiKhoan> getAll() {
        Connection conn = DAO.getConnection();
        String sql = "SELECT TENTK, cast(DECRYPTBYPASSPHARSE('sa',MATKHAU) as varchar(50)) mk, QUYEN FROM TAIKHOAN";
        ArrayList<TaiKhoan> ds = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tenTk = rs.getString("TENTK");
                String mk = rs.getString("mk");
                int loai = rs.getInt("QUYEN");
                ds.add(new TaiKhoan(tenTk,mk,loai));
            }
            conn.close();
            ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public TaiKhoan get(String tenTk) {
        try{
            Connection conn = DAO.getConnection();
            String sql = "SELECT TENTK, cast(DECRYPTBYPASSPHRASE('sa', MATKHAU) as varchar(50)) mk, QUYEN from TAIKHOAN where TAIKHOAN.TENTK = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenTk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString("TENTK"),rs.getString("mk"),rs.getInt("QUYEN"));
                conn.close();
                ps.close();
                return tk;
            }
            else return null;
        }
        catch(SQLException ex){
            return null;
        }
    }
    public int getLoai(String tenTk){
        try{
            Connection conn = DAO.getConnection();
            String sql = "SELECT QUYEN FROM TAIKHOAN WHERE TENTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tenTk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conn.close();
                ps.close();
                return rs.getInt("QUYEN");
            }
            else return -1;
        }
        catch(SQLException ex){
            return -1;
        }
    }
//    public boolean checkLogin(String tenTk, String mk){
//        try{
//            Connection conn = DAO.getConnection();
//            String sql = "SELECT cast(DECRYPTBYPASSPHRASE('sa', MATKHAU) as varchar(50)) mk from TAIKHOAN where TAIKHOAN.TENTK = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,tenTk);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                return rs.getString("mk").equals(mk);
//            }
//        }
//        catch(SQLException ex){
//            ex.printStackTrace();
//        }
//        return false;
//    }
}
