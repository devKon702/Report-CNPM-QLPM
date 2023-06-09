package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhongHoc {
    private String MAPHONG;
    private int MATRANGTHAI;

    public PhongHoc() {
    }

    public PhongHoc(String MAPHONG, int MATRANGTHAI) {
        this.MAPHONG = MAPHONG;
        this.MATRANGTHAI = MATRANGTHAI;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public int getMATRANGTHAI() {
        return MATRANGTHAI;
    }

    public void setMATRANGTHAI(int MATRANGTHAI) {
        this.MATRANGTHAI = MATRANGTHAI;
    }
    public static List<PhongHoc> getAllPhongHoc() throws SQLException{
     List<PhongHoc> list = new ArrayList<>();
    Connection conn = DatabaseHelper.getConnection();
    String sql = "SELECT * FROM PHONGHOC";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String maPhong = rs.getString("MAPHONG");
            int maTrangThai = rs.getInt("TRANGTHAI");
            PhongHoc phongHoc = new PhongHoc(maPhong, maTrangThai);
            list.add(phongHoc);
        }
        rs.close();
        stmt.close();
        conn.close();
    return list;
}
     public static List<PhongHoc> getTimKiem(String str) throws SQLException{
     List<PhongHoc> list = new ArrayList<>();
    Connection conn = DatabaseHelper.getConnection();
    String sql = "SELECT * FROM PHONGHOC WHERE"+ " MAPHONG        like N'%" + str + "%' ";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String maPhong = rs.getString("MAPHONG");
            int maTrangThai = rs.getInt("TRANGTHAI");
            PhongHoc phongHoc = new PhongHoc(maPhong, maTrangThai);
            list.add(phongHoc);
        }
        rs.close();
        stmt.close();
        conn.close();
    return list;
}
     public static boolean checkkey(String str) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
          conn = DatabaseHelper.getConnection();
       stmt = conn.prepareStatement(
         "SELECT COUNT(*) FROM THIETBI " +
         "WHERE MAPHONG = ? AND MALOAI = 'KEY' AND TINHTRANG = 1");
        stmt.setString(1, str);
       rs = stmt.executeQuery();
      rs.next();
      int count = rs.getInt(1);
      rs.close();
      stmt.close();
      conn.close();
      return count > 0;
 
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
public static boolean check(String str) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = DatabaseHelper.getConnection();
        String sql = "SELECT TRANGTHAI FROM PHONGHOC WHERE MAPHONG = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, str);
        rs = stmt.executeQuery();
        if (rs.next()) {
            String maTrangThai = rs.getString("TRANGTHAI");
            return maTrangThai.equals("3");
        } else {
            return false;
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

public static String getTT(String maPH) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = DatabaseHelper.getConnection();
        String sql = "SELECT TRANGTHAI FROM PHONGHOC WHERE MAPHONG = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, maPH);
        rs = stmt.executeQuery();
        if (rs.next()) {
            String maTrangThai = rs.getString("TRANGTHAI");
            return maTrangThai;
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    return null;
}
}