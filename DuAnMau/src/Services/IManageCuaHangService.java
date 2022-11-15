/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLCuaHang;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageCuaHangService {
    
    List<QLCuaHang> getAll();
    
    QLCuaHang save(QLCuaHang cuaHang);
    
    QLCuaHang update(QLCuaHang cuaHang);
    
    String delete(String id);
    
    List<QLCuaHang> getCuaHangByMa(String ma);
}
