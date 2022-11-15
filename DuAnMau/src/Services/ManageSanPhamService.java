/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repositories.Interface.ISanPhamRepository;
import Repositories.SanPhamRepository;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageSanPhamService implements IManageSanPhamService {

    private final ISanPhamRepository sanPhamRepository;
    private List<QLSanPham> lst;

    public ManageSanPhamService() {
        this.sanPhamRepository = new SanPhamRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLSanPham> getAll() {
        lst = new ArrayList<>();
        List<SanPham> ds = sanPhamRepository.getAll();
        for (SanPham d : ds) {
            lst.add(new QLSanPham(d.getId(),
                    d.getMaSanPham(), d.getTenSanPham()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public QLSanPham save(QLSanPham sanPham) {
        var sp = sanPhamRepository.save(new SanPham(sanPham.getMaSp(), sanPham.getTenSp()));
        return new QLSanPham(sp.getMaSanPham(), sp.getTenSanPham());
    }

    @Override
    public String delete(String id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public QLSanPham updateSanPham(QLSanPham sanPham) {
        var sp = sanPhamRepository.updateSanPham(new SanPham(sanPham.getMaSp(), sanPham.getTenSp()));
        return new QLSanPham(sp.getMaSanPham(), sp.getTenSanPham());
    }

    @Override
    public List<QLSanPham> getSanPhamByMa(String ma) {
        lst = new ArrayList<>();
        List<SanPham> ds = sanPhamRepository.getSanPhamByMa(ma);
        for (SanPham d : ds) {
            lst.add(new QLSanPham(d.getId(), d.getMaSanPham(), d.getTenSanPham()));
        }
        return Collections.unmodifiableList(lst);
    }

}
