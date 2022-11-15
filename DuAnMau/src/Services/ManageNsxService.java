/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NSX;
import Repositories.Interface.INsxRepository;
import Repositories.NsxRepository;
import ViewModels.QLNsx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageNsxService implements IManageNsxService {

    private final INsxRepository nsxRepository;
    private List<QLNsx> lst;

    public ManageNsxService() {
        nsxRepository = new NsxRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLNsx> getAll() {
        lst = new ArrayList<>();
        List<NSX> ds = nsxRepository.getAll();
        for (NSX d : ds) {
            lst.add(new QLNsx(d.getId(), d.getMaNsx(), d.getTenNsx()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public String delete(String idNsx) {
        nsxRepository.delete(idNsx);
        return idNsx;
    }

    @Override
    public QLNsx insert_Sql(QLNsx nsx) {
        var c = nsxRepository.save(new NSX(nsx.getMaNSx(), nsx.getTenNSx()));
        return new QLNsx(c.getMaNsx(), c.getTenNsx());
    }

    @Override
    public QLNsx updateById(QLNsx nsx) {
        var c = nsxRepository.updateNsx(new NSX(nsx.getMaNSx(), nsx.getTenNSx()));
        return new QLNsx(c.getMaNsx(), c.getTenNsx());
    }

    @Override
    public List<QLNsx> getByMa(String ma) {
        lst = new ArrayList<>();
        List<NSX> ds = nsxRepository.getNsxByMa(ma);
        for (NSX d : ds) {
            lst.add(new QLNsx(d.getId(), d.getMaNsx(), d.getTenNsx()));
        }
        return lst;
    }

}
