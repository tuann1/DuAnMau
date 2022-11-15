/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.CuaHang;
import Repositories.Interface.ICuaHangRepository;
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
public class CuaHangRepository implements ICuaHangRepository {

    final String SELECT_SQL = "SELECT * FROM CuaHang";
    final String SELECT_SQL_BY_MA = "SELECT * FROM CuaHang WHERE Ma like ?";
    final String INSERT_SQL = """
                              DECLARE @IdCuaHang uniqueidentifier
                              SET @IdCuaHang = NEWID()
                              INSERT INTO CuaHang VALUES (@IdCuaHang, ?, ?, ?, ?, ?)""";
    final String UPDATE_SQL = "UPDATE CuaHang SET Ten=?, DiaChi=?, ThanhPho=?,"
            + " QuocGia=? WHERE Ma=?";
    final String DELETE_SQL = "DELETE FROM CuaHang WHERE Id=?";

    private List<CuaHang> getSelect(String sql, Object... args) {
        List<CuaHang> lstCuaHang = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstCuaHang.add(new CuaHang(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"),
                        rs.getString("DiaChi"), rs.getString("ThanhPho"), rs.getString("QuocGia")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstCuaHang;
    }

    @Override

    public List<CuaHang> getAll() {
        return getSelect(SELECT_SQL);
    }

    @Override
    public CuaHang save(CuaHang cuaHang) {
        DBConnection.update(INSERT_SQL, cuaHang.getMa(), cuaHang.getTen(), cuaHang.getDiaChi(),
                cuaHang.getThanhPho(), cuaHang.getQuocGia());
        return cuaHang;
    }

    @Override
    public CuaHang update(CuaHang cuaHang) {
        DBConnection.update(UPDATE_SQL, cuaHang.getTen(), cuaHang.getDiaChi(),
                cuaHang.getThanhPho(), cuaHang.getQuocGia(), cuaHang.getMa());
        return cuaHang;
    }

    @Override
    public String delete(String id) {
        DBConnection.update(DELETE_SQL, id);
        return id;
    }

    @Override
    public List<CuaHang> findByMa(String ma) {
        List<CuaHang> listCH = new ArrayList<>();
        try {
            try ( PreparedStatement ps = DBConnection.stmt(SELECT_SQL_BY_MA, "%" + ma + "%")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    listCH.add(new CuaHang(rs.getString("Id"), rs.getString("Ma"),
                            rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("ThanhPho"),
                            rs.getString("QuocGia")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            return null;
        }
        return listCH;
    }

}
