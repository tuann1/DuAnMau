/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import Repositories.CuaHangRepository;
import Repositories.Interface.ICuaHangRepository;
import ViewModels.QLCuaHang;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ManageCuaHangService implements IManageCuaHangService {

    private final ICuaHangRepository cuaHangRepository;
    private List<QLCuaHang> lst;

    public ManageCuaHangService() {
        cuaHangRepository = new CuaHangRepository();
        lst = new ArrayList<>();
    }

    @Override
    public List<QLCuaHang> getAll() {
        lst = new ArrayList<>();
        List<CuaHang> ds = cuaHangRepository.getAll();
        for (CuaHang d : ds) {
            lst.add(new QLCuaHang(d.getId(),
                    d.getTen(),
                    d.getMa(),
                    d.getDiaChi(),
                    d.getThanhPho(),
                    d.getQuocGia()));
        }
        return Collections.unmodifiableList(lst);
    }

    @Override
    public QLCuaHang save(QLCuaHang cuaHang) {
        var a = cuaHangRepository.save(new CuaHang(cuaHang.getMa(), cuaHang.getTen(), cuaHang.getDiaChi(), cuaHang.getThanhPho(), cuaHang.getQuocGia()));
        return new QLCuaHang(a.getTen(),
                a.getMa(),
                a.getDiaChi(),
                a.getThanhPho(),
                a.getQuocGia());
    }

    @Override
    public QLCuaHang update(QLCuaHang cuaHang) {
        var a = cuaHangRepository.update(new CuaHang(cuaHang.getMa(),
                cuaHang.getTen(),
                cuaHang.getDiaChi(),
                cuaHang.getThanhPho(),
                cuaHang.getQuocGia()));
        return new QLCuaHang(a.getTen(), a.getMa(),
                a.getDiaChi(), a.getThanhPho(), a.getQuocGia());
    }

    @Override
    public String delete(String id) {
        cuaHangRepository.delete(id);
        return id;
    }

    @Override
    public List<QLCuaHang> getCuaHangByMa(String ma) {
        lst = new ArrayList<>();
        List<CuaHang> ds = cuaHangRepository.findByMa(ma);
        for (CuaHang d : ds) {
            lst.add(new QLCuaHang(d.getId(), d.getTen(), d.getMa(),
                    d.getDiaChi(), d.getThanhPho(), d.getQuocGia()));
        }
        return Collections.unmodifiableList(lst);
    }

}
