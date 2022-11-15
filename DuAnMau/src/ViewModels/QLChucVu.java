/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Laptop
 */
public class QLChucVu {

    private String idCV;
    private String maCV;
    private String tenCv;

    public QLChucVu() {
    }

    public QLChucVu(String idCV, String maCV, String tenCv) {
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCv = tenCv;
    }

    public QLChucVu(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCv = tenCV;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCv() {
        return tenCv;
    }

    public void setTenCv(String tenCv) {
        this.tenCv = tenCv;
    }

}
