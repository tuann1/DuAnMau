/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interface;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IMauSacRepository {

    List<MauSac> findAll();

    MauSac save(MauSac mauSac);

    MauSac updateMauSacById(MauSac mauSac);

    String delete(String id);

    List<MauSac> getMauSacByMa(String ma);
}
