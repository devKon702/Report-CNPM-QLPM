package model;

public class PhieuMuon {

    private String MAPM;
    private String THOIDIEMLAP;
    private String HAN;
    private String MALTC;
    private String MANV;
    private String MAPHONG;

    public PhieuMuon(String MAPM, String THOIDIEMLAP, String HAN, String MALTC, String MANV, String MAPHONG) {
        this.MAPM = MAPM;
        this.THOIDIEMLAP = THOIDIEMLAP;
        this.HAN = HAN;
        this.MALTC = MALTC;
        this.MANV = MANV;
        this.MAPHONG = MAPHONG;
    }

    public String getMAPM() {
        return MAPM;
    }

    public void setMAPM(String MAPM) {
        this.MAPM = MAPM;
    }

    public String getTHOIDIEMLAP() {
        return THOIDIEMLAP;
    }

    public void setTHOIDIEMLAP(String THOIDIEMLAP) {
        this.THOIDIEMLAP = THOIDIEMLAP;
    }

    public String getHAN() {
        return HAN;
    }

    public void setHAN(String HAN) {
        this.HAN = HAN;
    }

    public String getMALTC() {
        return MALTC;
    }

    public void setMALTC(String MALTC) {
        this.MALTC = MALTC;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }
}
