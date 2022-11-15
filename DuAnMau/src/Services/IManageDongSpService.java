/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IManageDongSpService {
    
    List<QLDongSP> getAll();
    
    QLDongSP save(QLDongSP dongSp);
    
    String delete(String id);
    
    QLDongSP updateDongSpById(QLDongSP dongSp);
    
    List<QLDongSP> getDongSpByMa(String ma);
}
