/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Laptop
 */
public class ChiTietSanPham {

    private String id, idSP, idNsx, idMauSac, idDongSp, moTa;
    private int namBh, soLuongTon;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id, String idSP, String idNsx, String idMauSac, String idDongSp, String moTa, int namBh, int soLuongTon) {
        this.id = id;
        this.idSP = idSP;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSp = idDongSp;
        this.moTa = moTa;
        this.namBh = namBh;
        this.soLuongTon = soLuongTon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(String idNsx) {
        this.idNsx = idNsx;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSp() {
        return idDongSp;
    }

    public void setIdDongSp(String idDongSp) {
        this.idDongSp = idDongSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getNamBh() {
        return namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

}
