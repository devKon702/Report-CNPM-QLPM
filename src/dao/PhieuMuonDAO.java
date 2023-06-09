
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import model.PhieuMuon;

public class PhieuMuonDAO implements DAOInterface<PhieuMuon>{

    @Override
    public boolean insert(PhieuMuon obj) {
        PreparedStatement stmt;
        Connection conn = DAO.getConnection();;
        String sql = "INSERT INTO PHIEUMUON (MAPM, THOIDIEMLAP, HAN, MALTC, MANV, MAPHONG) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            
            // Tạo đối tượng PreparedStatement để thực hiện câu lệnh SQL
            stmt = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL INSERT
            stmt.setString(1, obj.getMAPM());
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            java.sql.Timestamp timestampThoiDiemLap = new java.sql.Timestamp(formatter.parse(obj.getTHOIDIEMLAP()).getTime());
            
            java.sql.Timestamp timestampHan = new java.sql.Timestamp(formatter.parse(obj.getHAN()).getTime());
            
            stmt.setTimestamp(2, timestampThoiDiemLap);
            stmt.setTimestamp(3, timestampHan);
            stmt.setString(4,obj.getMALTC());
            stmt.setString(5, obj.getMANV());
            stmt.setString(6, obj.getMAPHONG());

            // Thực hiện câu lệnh SQL INSERT
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(PhieuMuon obj) {
        return false;
    }

    @Override
    public boolean update(PhieuMuon obj) {
        return false;
    }

    @Override
    public ArrayList<PhieuMuon> getAll() {
        ArrayList<PhieuMuon> listPhieuMuon = new ArrayList<>();
        Connection conn = DAO.getConnection();
        String sql = "SELECT * FROM PHIEUMUON";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MAPM = rs.getString("MAPM");
                String THOIDIEMLAP = rs.getString("THOIDIEMLAP");
                String HAN = rs.getString("HAN");
                String MALTC = rs.getString("MALTC");
                String MANV = rs.getString("MANV");
                String MAPHONG = rs.getString("MAPHONG");
                PhieuMuon pm = new PhieuMuon(MAPM, THOIDIEMLAP, HAN, MALTC, MANV, MAPHONG);
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
    
    public boolean checkExist(String maPM){
        Connection conn = DAO.getConnection();
        String sql = "SELECT TOP(1) * FROM PHIEUMUON WHERE MAPM=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,maPM);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
}
