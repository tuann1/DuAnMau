/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Laptop
 */
public class ChucVu {

    private String idCV, maCv, tenCV;

    public ChucVu() {
    }

    public ChucVu(String idCV, String maCv, String tenCV) {
        this.idCV = idCV;
        this.maCv = maCv;
        this.tenCV = tenCV;
    }

    public ChucVu(String maCv, String tenCV) {
        this.maCv = maCv;
        this.tenCV = tenCV;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCv() {
        return maCv;
    }

    public void setMaCv(String maCv) {
        this.maCv = maCv;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

}
