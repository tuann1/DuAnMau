/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLNsx;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageNsxService {
    
    List<QLNsx> getAll();
    
    QLNsx insert_Sql(QLNsx nsx);
    
    String delete(String idNsx);
    
    QLNsx updateById(QLNsx nsx);
    
    List<QLNsx> getByMa(String ma);
}
