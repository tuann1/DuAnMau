/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Laptop
 */
public class QLNsx {

    private String id;
    private String maNSx;
    private String tenNSx;

    public QLNsx() {
    }

    public QLNsx(String id, String maNSx, String tenNSx) {
        this.id = id;
        this.maNSx = maNSx;
        this.tenNSx = tenNSx;
    }

    public QLNsx(String maNsx, String tenNsx) {
        this.maNSx = maNsx;
        this.tenNSx = tenNsx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNSx() {
        return maNSx;
    }

    public void setMaNSx(String maNSx) {
        this.maNSx = maNSx;
    }

    public String getTenNSx() {
        return tenNSx;
    }

    public void setTenNSx(String tenNSx) {
        this.tenNSx = tenNSx;
    }
}
