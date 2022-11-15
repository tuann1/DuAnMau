/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Laptop
 */
public class NSX {

    private String id, maNsx, tenNsx;

    public NSX() {
    }

    public NSX(String id, String maNsx, String tenNsx) {
        this.id = id;
        this.maNsx = maNsx;
        this.tenNsx = tenNsx;
    }

    public NSX(String maNsx, String tenNsx) {
        this.maNsx = maNsx;
        this.tenNsx = tenNsx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNsx() {
        return maNsx;
    }

    public void setMaNsx(String maNsx) {
        this.maNsx = maNsx;
    }

    public String getTenNsx() {
        return tenNsx;
    }

    public void setTenNsx(String tenNsx) {
        this.tenNsx = tenNsx;
    }

}
