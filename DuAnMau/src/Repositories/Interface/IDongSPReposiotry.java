/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IDongSPReposiotry {

    List<DongSP> findAllDongSP();

    DongSP save(DongSP dongSp);

    String deleteDongSp(String id);

    DongSP updateDongSpByID(DongSP dongSp);

    List<DongSP> getDongSpByMa(String ma);
}
