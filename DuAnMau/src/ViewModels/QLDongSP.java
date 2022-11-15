/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Laptop
 */
public class QLDongSP {

    private String idDongSP;
    private String maDongSp;
    private String tenDongSp;

    public QLDongSP() {
    }

    public QLDongSP(String idDongSP, String maDongSp, String tenDongSp) {
        this.idDongSP = idDongSP;
        this.maDongSp = maDongSp;
        this.tenDongSp = tenDongSp;
    }

    public QLDongSP(String maDongSP, String tenDongSP) {
        this.maDongSp = maDongSP;
        this.tenDongSp = tenDongSP;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getMaDongSp() {
        return maDongSp;
    }

    public void setMaDongSp(String maDongSp) {
        this.maDongSp = maDongSp;
    }

    public String getTenDongSp() {
        return tenDongSp;
    }

    public void setTenDongSp(String tenDongSp) {
        this.tenDongSp = tenDongSp;
    }

}
