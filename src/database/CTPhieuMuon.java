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
/**
 *
 * @author henry
 */
public class CTPhieuMuon {
    private String MAPM;
    private String MATB;
    private String MATRANGTHAI;
    private String MSSV;
    private String SDT;

    public CTPhieuMuon() {
    }

    public CTPhieuMuon(String MAPM, String MATB, String MATRANGTHAI, String MSSV, String SDT) {
        this.MAPM = MAPM;
        this.MATB = MATB;
        this.MATRANGTHAI = MATRANGTHAI;
        this.MSSV = MSSV;
        this.SDT = SDT;
    }


    public String getMAPM() {
        return MAPM;
    }

    public void setMAPM(String MAPM) {
        this.MAPM = MAPM;
    }

    public String getMATB() {
        return MATB;
    }

    public void setMATB(String MATB) {
        this.MATB = MATB;
    }

    public String getMATRANGTHAI() {
        return MATRANGTHAI;
    }

    public void setMATRANGTHAI(String MATRANGTHAI) {
        this.MATRANGTHAI = MATRANGTHAI;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public static List<CTPhieuMuon> getAllCTPhieuMuon() throws SQLException {
        List<CTPhieuMuon> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnection();
        String sql = "SELECT MAPM,MATB,TRANGTHAI,MSSV,SDT FROM CTPHIEUMUON";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            CTPhieuMuon ct = new CTPhieuMuon();
            ct.setMAPM(rs.getString("MAPM"));
            ct.setMATB(rs.getString("MATB"));
            ct.setMATRANGTHAI(rs.getString("TRANGTHAI"));
            ct.setMSSV(rs.getString("MSSV"));
            ct.setSDT(rs.getString("SDT"));
            list.add(ct);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return list;
    }
 
    public static void updatePhieu(int id){
        Connection conn = DatabaseHelper.getConnection();
        String sql = "UPDATE CTPHIEUMUON "
                + "SET CTPHIEUMUON.TRANGTHAI=? "
                + "WHERE CTPHIEUMUON.ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,7);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            conn.close();
            stmt.close();
            System.out.println("Trả thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi");
        }
    }
    public static List<String> getMATBList(String MSSV, String MAPM) {
        List<String> l = new ArrayList<String>();
        try {
            // lấy kết nối tới database
            Connection conn = DatabaseHelper.getConnection();

            // thực hiện truy vấn
            PreparedStatement stmt = conn.prepareStatement("SELECT TENTB FROM THIETBI WHERE MATB IN ( SELECT MATB FROM CTPHIEUMUON WHERE MAPM = ? AND MSSV = ? AND TRANGTHAI = 6)" );
            stmt.setString(1, MAPM); // thay MAPM bằng giá trị của MAPM bạn muốn truy vấn
            stmt.setString(2, MSSV); // thay MSSV bằng giá trị của MSSV bạn muốn truy vấn
            ResultSet rs = stmt.executeQuery();

            // lưu kết quả vào list
            while (rs.next()) {
                String MATB = rs.getString("TENTB");
                l.add(MATB);
            }

            // đóng kết nối
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }
}
