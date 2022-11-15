/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import Repositories.Interface.IChucVuRepository;
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
public class ChucVuRepository implements IChucVuRepository {

    final String SELECT_SQL = "SELECT * FROM ChucVu";
    final String SELECT_SQL_BY_MA = "SELECT * FROM ChucVu WHERE Ma=?";
    final String SELECT_SQL_BY_MA1 = "SELECT * FROM ChucVu WHERE Ma like ?";
    final String INSERT_SQL = """
                              DECLARE @idCV uniqueidentifier
                              SET @idCV = NEWID()
                              INSERT INTO ChucVu VALUES (@idCV,?,?)""";
    final String UPDATE_SQL = "UPDATE ChucVu SET Ten=? WHERE Ma=?";
    final String DELETE_SQL = "DELETE FROM ChucVu WHERE Id=?";

    private List<ChucVu> getSelect(String sql, Object... args) {
        List<ChucVu> lstChucVu = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstChucVu.add(new ChucVu(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstChucVu;
    }

    @Override
    public List<ChucVu> getAll() {
        return getSelect(SELECT_SQL);
    }

    @Override
    public ChucVu save(ChucVu chucVu) {
        DBConnection.update(INSERT_SQL, chucVu.getMaCv(), chucVu.getTenCV());
        return chucVu;
    }

    @Override
    public ChucVu update(ChucVu chucVu) {
        DBConnection.update(UPDATE_SQL, chucVu.getTenCV(), chucVu.getMaCv());
        return chucVu;
    }

    @Override
    public String delete(String id) {
        DBConnection.update(DELETE_SQL, id);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ChucVu> findById(String ma) {
        List<ChucVu> listTK = new ArrayList<>();
        try {
            try ( PreparedStatement ps = DBConnection.stmt(SELECT_SQL_BY_MA1, "%" + ma + "%")) {
                ResultSet rs = ps.executeQuery();
                System.out.println(ma);
                while (rs.next()) {
                    listTK.add(new ChucVu(rs.getString("Id"), rs.getString("Ma"),
                            rs.getString("Ten")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi lấy dữ liệu Select");
            return null;
        }
        return listTK;
    }
}
