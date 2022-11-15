/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLSanPham;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageSanPhamService {
    
    List<QLSanPham> getAll();
    
    QLSanPham save(QLSanPham sanPham);
    
    String delete(String id);
    
    QLSanPham updateSanPham(QLSanPham sanPham);
    
    List<QLSanPham> getSanPhamByMa(String ma);
}
