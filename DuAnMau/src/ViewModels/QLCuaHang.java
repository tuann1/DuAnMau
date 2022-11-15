/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.io.Serializable;

/**
 *
 * @author Laptop
 */
public class QLCuaHang implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String ten;
    private String ma;
    private String diaChi;
    private String thanhPho;
    private String quocGia;

    public QLCuaHang() {
    }

    public QLCuaHang(String id, String ten, String ma, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public QLCuaHang(String ten, String ma, String diaChi, String thanhPho, String quocGia) {
        this.ten = ten;
        this.ma = ma;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

}
