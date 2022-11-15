/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Repositories.Interface.ISanPhamRepository;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Laptop
 */
public class SanPhamRepository implements ISanPhamRepository {

    final String SELECT_SQL = "SELECT * FROM SanPham";
    final String SELECT_BY_MA = "SELECT * FROM SanPham WHERE Ma like ?";
    final String INSERT_SQL = """
                         DECLARE @idSanPham uniqueidentifier
                         SET @idSanPham = NEWID()
                         INSERT INTO SanPham VALUES(@idSanPham,?,?)""";
    final String DELETE_SQL = "DELETE FROM SanPham WHERE Id=?";
    final String UPDATE_SQL = "UPDATE SanPham SET Ten=? WHERE Ma=?";

    private List<SanPham> getSelect(String sql, Object... args) {
        List<SanPham> lstSanPham = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstSanPham.add(new SanPham(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstSanPham;
    }

    @Override
    public List<SanPham> getAll() {
        return getSelect(SELECT_SQL);
    }

    @Override
    public SanPham save(SanPham sanPham) {
        DBConnection.update(INSERT_SQL, sanPham.getMaSanPham(), sanPham.getTenSanPham());
        return sanPham;
    }

    @Override
    public String delete(String id) {
        DBConnection.update(DELETE_SQL, id);
        return id;
    }

    @Override
    public SanPham updateSanPham(SanPham sp) {
        DBConnection.update(UPDATE_SQL, sp.getTenSanPham(), sp.getMaSanPham());
        return sp;
    }

    @Override
    public List<SanPham> getSanPhamByMa(String ma) {
        List<SanPham> lstSP = new ArrayList<>();
        try {
            PreparedStatement ps = DBConnection.stmt(SELECT_BY_MA, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstSP.add(new SanPham(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstSP;
    }

}
