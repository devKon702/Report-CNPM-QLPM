
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CTPhieuMuon;

import dao.ThietBiDAO;

public class CTPhieuMuonDAO implements DAOInterface<CTPhieuMuon>{

    @Override
    public boolean insert(CTPhieuMuon obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(CTPhieuMuon obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(CTPhieuMuon obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CTPhieuMuon> getAll() {
        ArrayList<CTPhieuMuon> list = new ArrayList<>();
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM CTPHIEUMUON";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CTPhieuMuon ct = new CTPhieuMuon();
                ct.setMAPM(rs.getString("MAPM"));
                ct.setMATB(rs.getString("MATB"));
                ct.setMATRANGTHAI(rs.getString("MATRANGTHAI"));
                ct.setMSSV(rs.getString("MSSV"));
                ct.setSDT(rs.getString("SDT"));
                list.add(ct);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    public CTPhieuMuon get(int id){
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM CTPHIEUMUON WHERE ID = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            CTPhieuMuon ct = new CTPhieuMuon();
            if (rs.next()) {
                ct.setMAPM(rs.getString("MAPM"));
                ct.setMATB(rs.getString("MATB"));
                ct.setMATRANGTHAI(rs.getString("MATRANGTHAI"));
                ct.setMSSV(rs.getString("MSSV"));
                ct.setSDT(rs.getString("SDT"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ct;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean traCT_PhieuMuon(int id){
        Connection conn = DAO.getConnection();
        String sql = "UPDATE CTPHIEUMUON "
                + "SET CTPHIEUMUON.TRANGTHAI=7 "
                + "WHERE CTPHIEUMUON.ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            conn.close();
            stmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
