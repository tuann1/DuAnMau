/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import Repositories.Interface.IMauSacRepository;
import Repositories.MauSacRepository;
import ViewModels.QLMauSac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageMauSacService implements IManageMauSacService {

    private final IMauSacRepository mauSacRepository;
    private List<QLMauSac> lst;

    public ManageMauSacService() {
        mauSacRepository = new MauSacRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLMauSac> getAll() {
        lst = new ArrayList<>();
        List<MauSac> ds = mauSacRepository.findAll();
        for (MauSac d : ds) {
            lst.add(new QLMauSac(d.getId(), d.getMa(), d.getTen()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public QLMauSac save(QLMauSac mauSac) {
        var a = mauSacRepository.save(new MauSac(mauSac.getMaMau(), mauSac.getTenMau()));
        return new QLMauSac(a.getMa(), a.getTen());
    }

    @Override
    public String delete(String id) {
        return mauSacRepository.delete(id);
    }

    @Override
    public QLMauSac updateMauSacById(QLMauSac mauSac) {
        var x = mauSacRepository.updateMauSacById(new MauSac(mauSac.getMaMau(), mauSac.getTenMau()));
        return new QLMauSac(x.getMa(), x.getTen());
    }

    @Override
    public List<QLMauSac> getMauSacByMa(String ma) {
        lst = new ArrayList<>();
        List<MauSac> ds = mauSacRepository.getMauSacByMa(ma);
        for (MauSac d : ds) {
            lst.add(new QLMauSac(d.getId(), d.getMa(), d.getTen()));
        }
        return Collections.unmodifiableList(lst);
    }

}
