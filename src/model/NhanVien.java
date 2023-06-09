
package model;

import java.util.Date;


public class NhanVien {
    private String ma;
    private String ten;
    private String cccd;
    private String sdt;
    private String email;
    private String ngayLam;
    private String ngayNghi;

    public NhanVien(String ma, String ten, String cccd, String sdt, String email, String ngayLam, String ngayNghi) {
        this.ma = ma;
        this.ten = ten;
        this.cccd = cccd;
        this.sdt = sdt;
        this.email = email;
        this.ngayLam = ngayLam;
        this.ngayNghi = ngayNghi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(String ngayLam) {
        this.ngayLam = ngayLam;
    }

    public String getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(String ngayNghi) {
        this.ngayNghi = ngayNghi;
    }
}
