/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import Repositories.ChucVuRepository;
import Repositories.Interface.IChucVuRepository;
import ViewModels.QLChucVu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageChucVuService implements IManageChucVuService {

    private final IChucVuRepository chucVuRepository;
    private List<QLChucVu> lst;

    public ManageChucVuService() {
        chucVuRepository = new ChucVuRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLChucVu> getAll() {
        lst = new ArrayList<>();
        List<ChucVu> ds = chucVuRepository.getAll();
        for (ChucVu d : ds) {
            lst.add(new QLChucVu(d.getIdCV(), d.getMaCv(), d.getTenCV()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public QLChucVu save(QLChucVu chucVu) {
        var a = chucVuRepository.save(new ChucVu(chucVu.getMaCV(), chucVu.getTenCv()));
        return new QLChucVu(a.getMaCv(), a.getTenCV());
    }

    @Override
    public QLChucVu update(QLChucVu chucVu) {
        var a = chucVuRepository.update(new ChucVu(chucVu.getMaCV(), chucVu.getTenCv()));
        return new QLChucVu(a.getMaCv(), a.getTenCV());
    }

    @Override
    public String delete(String id) {
        chucVuRepository.delete(id);
        return id;
    }

    @Override
    public List<QLChucVu> findByMa(String ma) {
//        ChucVu cv = chucVuRepository.findById(ma);
//        if (cv == null) {
//            return null;
//        } else {
//            return new QLChucVu(cv.getIdCV(), cv.getMaCv(), cv.getTenCV());
//        }

        lst = new ArrayList<>();
        List<ChucVu> ds = chucVuRepository.findById(ma);
        for (ChucVu d : ds) {
            lst.add(new QLChucVu(d.getIdCV(), d.getMaCv(), d.getTenCV()));
        }
        return Collections.unmodifiableList(lst);
    }

}
