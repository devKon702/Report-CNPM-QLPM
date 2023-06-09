
package model;


public class TrangThai {
    private int ma;
    private String ten;
    private String loai;
    
    public TrangThai(){
    }
    public TrangThai(int ma, String ten,String loai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    public String getLoai(){
        return loai;
    }
    
}
