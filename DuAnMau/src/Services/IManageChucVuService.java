/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLChucVu;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageChucVuService {
    
    List<QLChucVu> getAll();
    
    QLChucVu save(QLChucVu chucVu);
    
    QLChucVu update(QLChucVu chucVu);
    
    String delete(String id);
    
    List<QLChucVu> findByMa(String ma);
}
