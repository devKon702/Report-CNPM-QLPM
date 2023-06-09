
package model;

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
}
