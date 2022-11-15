/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Laptop
 */
public class DongSP {

    private String idDongSP, maDongSP, tenDongSP;

    public DongSP() {
    }

    public DongSP(String idDongSP, String maDongSP, String tenDongSP) {
        this.idDongSP = idDongSP;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public DongSP(String maDongSP, String tenDongSP) {
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

}
