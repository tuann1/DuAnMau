/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IChucVuRepository {
    
    List<ChucVu> getAll();
    
    List<ChucVu> findById(String ma);
    
    ChucVu save(ChucVu chucVu);
    
    ChucVu update(ChucVu chucVu);
    
    String delete(String id);
}
