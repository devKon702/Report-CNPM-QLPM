/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class TaiKhoan {
    private String tk;
    private String mk;
    private int quyen;

    public TaiKhoan(){
        
    }
    public TaiKhoan(String tk, String mk, int quyen){
        this.tk = tk;
        this.mk = mk;
        this.quyen = quyen;
    }
    public String getTk() {
        return tk;
    }

    public String getMk() {
        return mk;
    }


    public void setMk(String mk) {
        this.mk = mk;
    }


    public int getQuyen() {
        return quyen;
    }
    
    public void setQuyen(int quyen){
        this.quyen = quyen;
    }
    
}
