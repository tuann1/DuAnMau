/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface INsxRepository {

    List<NSX> getAll();

    NSX save(NSX nsx);

    String delete(String idNsx);

    NSX updateNsx(NSX nsx);

    List<NSX> getNsxByMa(String ma);
}
