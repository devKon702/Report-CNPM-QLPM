package model;

import dao.LoaiDAO;
import dao.TrangThaiDAO;

public class ThietBi {
    private String ma;
    private String ten;
    private String maLoai;
    private String tenLoai;
    private String phong;
    private int maTrangThai;
    private String tenTrangThai;

    public ThietBi() {

    }

    public ThietBi(String ma, String ten, String maLoai, String phong, int maTrangThai) {
        this.ma = ma;
        this.ten = ten;
        this.maLoai = maLoai;
        this.tenLoai = new LoaiDAO().getLoai(maLoai);
        this.phong = phong;
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = new TrangThaiDAO().getTenTrangThai(maTrangThai);
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

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
        this.tenLoai = new LoaiDAO().getLoai(maLoai);
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
        this.maLoai = new LoaiDAO().getMaLoai(tenLoai);
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = new TrangThaiDAO().getTenTrangThai(maTrangThai);
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String trangThai) {
        this.tenTrangThai = trangThai;
        this.maTrangThai = new TrangThaiDAO().getMaTrangThai(tenTrangThai,"TB");
    }

}
