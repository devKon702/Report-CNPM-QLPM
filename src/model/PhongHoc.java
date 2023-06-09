
package model;

import dao.ThietBiDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhongHoc {
    private String maPhong;
    private Map<String,ArrayList<ThietBi>> ct_thietBi;
    private int maTrangThai;

    public PhongHoc(String maPhong, int maTrangThai) {
        this.maPhong = maPhong;
        this.maTrangThai = maTrangThai;
        ct_thietBi = new HashMap<>();
        for(ThietBi x : new ThietBiDAO().getThietBi_PhongHoc(maPhong)){
            if(!ct_thietBi.containsKey(x.getTenLoai())){
                ct_thietBi.put(x.getTenLoai(),new ArrayList<>());
                ct_thietBi.get(x.getTenLoai()).add(x);
            }
            else ct_thietBi.get(x.getTenLoai()).add(x);
        }
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public Map<String, ArrayList<ThietBi>> getMapLoai_ThietBi() {
        return ct_thietBi;
    }

    public void setCt_thietBi(Map<String, ArrayList<ThietBi>> ct_thietBi) {
        this.ct_thietBi = ct_thietBi;
    }
    
    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }
    
    public ArrayList<ThietBi> getThietBi_Loai(String loai){
        return ct_thietBi.get(loai);
    } 
    
}
