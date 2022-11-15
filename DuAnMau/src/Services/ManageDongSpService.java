/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import Repositories.DongSPRepository;
import Repositories.Interface.IDongSPReposiotry;
import ViewModels.QLDongSP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageDongSpService implements IManageDongSpService {

    private final IDongSPReposiotry dongSpRepository;
    private List<QLDongSP> lst;

    public ManageDongSpService() {
        dongSpRepository = new DongSPRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLDongSP> getAll() {
        lst = new ArrayList<>();
        List<DongSP> ds = dongSpRepository.findAllDongSP();
        for (DongSP d : ds) {
            lst.add(new QLDongSP(d.getIdDongSP(), d.getMaDongSP(), d.getTenDongSP()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public QLDongSP save(QLDongSP dongSp) {
        var a = dongSpRepository.save(new DongSP(dongSp.getMaDongSp(), dongSp.getTenDongSp()));
        return new QLDongSP(a.getMaDongSP(), a.getTenDongSP());
    }

    @Override
    public String delete(String id) {
        return dongSpRepository.deleteDongSp(id);
    }

    @Override
    public QLDongSP updateDongSpById(QLDongSP dongSp) {
        var x = dongSpRepository.updateDongSpByID(new DongSP(dongSp.getMaDongSp(),
                dongSp.getTenDongSp()));
        return new QLDongSP(x.getMaDongSP(), x.getTenDongSP());
    }

    @Override
    public List<QLDongSP> getDongSpByMa(String ma) {
        lst = new ArrayList<>();
        List<DongSP> ds = dongSpRepository.getDongSpByMa(ma);
        for (DongSP d : ds) {
            lst.add(new QLDongSP(d.getIdDongSP(), d.getMaDongSP(), d.getTenDongSP()));
        }
        return Collections.unmodifiableList(lst);
    }

}
