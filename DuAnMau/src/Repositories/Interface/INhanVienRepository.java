/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();
}
