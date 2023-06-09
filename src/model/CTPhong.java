package model;
import dao.ThietBiDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CTPhong {
    private String maPhong;
    private Map<String,ArrayList<ThietBi>> ct_thietBi;
    
    public CTPhong(){
        
    }
    public CTPhong(String maPhong){
        this.maPhong = maPhong;
        ct_thietBi = new HashMap<>();
        for(ThietBi x : new ThietBiDAO().getAll()){
            if(x.getPhong().equals(this.maPhong)){
                if(!ct_thietBi.containsKey(x.getTenLoai())){
                    ct_thietBi.put(x.getTenLoai(),new ArrayList<>());
                }
                else ct_thietBi.get(x.getTenLoai()).add(x);
            }
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
    public ArrayList<ThietBi> getThietBi_Loai(String loai){
        return ct_thietBi.get(loai);
    } 
}
