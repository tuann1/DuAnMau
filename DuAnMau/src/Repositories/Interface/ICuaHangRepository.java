/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface ICuaHangRepository {
    
    List<CuaHang> getAll();
    
    List<CuaHang> findByMa(String ma);
    
    CuaHang save(CuaHang cuaHang);
    
    CuaHang update(CuaHang cuaHang);
    
    String delete(String id);
}
