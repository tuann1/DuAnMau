/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface ISanPhamRepository {
    
    List<SanPham> getAll();
    
    SanPham save(SanPham sanPham);
    
    String delete(String id);
    
    SanPham updateSanPham(SanPham sp);
    
    List<SanPham> getSanPhamByMa(String ma);
}
