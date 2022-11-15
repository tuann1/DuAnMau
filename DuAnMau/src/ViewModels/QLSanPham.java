/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Laptop
 */
public class QLSanPham {

    private String idSp;
    private String maSp;
    private String tenSp;

    public QLSanPham() {
    }

    public QLSanPham(String idSp, String maSp, String tenSp) {
        this.idSp = idSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
    }

    public QLSanPham(String maSp, String tenSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

}
