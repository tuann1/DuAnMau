/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageMauSacService {
    
    List<QLMauSac> getAll();
    
    QLMauSac save(QLMauSac mauSac);
    
    QLMauSac updateMauSacById(QLMauSac mauSac);
    
    String delete(String id);
    
    List<QLMauSac> getMauSacByMa(String ma);
}
