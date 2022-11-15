/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import Repositories.Interface.IMauSacRepository;
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
public class MauSacRepository implements IMauSacRepository {

    final String SELECT_ALL = "SELECT * FROM MauSac";
    final String SELECT_BY_MA = "SELECT * FROM MauSac WHERE Ma like ?";
    final String DELETE = "DELETE FROM MauSac WHERE Id=?";
    final String INSERT = """
                          DECLARE @IdMauSac uniqueidentifier 
                          SET @IdMauSac = NEWID()INSERT INTO MauSac VALUES(@IdMauSac,?,?)""";
    final String UPDATE = "UPDATE MauSac SET Ten=? WHERE Ma=?";

    public MauSacRepository() {
    }

    private List<MauSac> getSelectSql(String sql, Object... args) {
        List<MauSac> lstMauSac = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstMauSac.add(new MauSac(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstMauSac;
    }

    @Override

    public List<MauSac> findAll() {
        return getSelectSql(SELECT_ALL);
    }

    @Override
    public MauSac save(MauSac mauSac) {
        DBConnection.update(INSERT, mauSac.getMa(), mauSac.getTen());
        return mauSac;
    }

    @Override
    public String delete(String id) {
        DBConnection.update(DELETE, id);
        return id;
    }

    @Override
    public MauSac updateMauSacById(MauSac mauSac) {
        DBConnection.update(UPDATE, mauSac.getTen(), mauSac.getMa());
        return mauSac;
    }

    @Override
    public List<MauSac> getMauSacByMa(String ma) {
        List<MauSac> listMS = new ArrayList<>();
        try {
            try ( PreparedStatement ps = DBConnection.stmt(SELECT_BY_MA, "%" + ma + "%")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    listMS.add(new MauSac(rs.getString("Id"), rs.getString("Ma"),
                            rs.getString("Ten")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMS;
    }

}
