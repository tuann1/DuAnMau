/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import Repositories.Interface.IDongSPReposiotry;
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
public class DongSPRepository implements IDongSPReposiotry {

    final String SELECT_SQL = "SELECT *FROM DongSP";
    final String SELECT_BY_MA = "SELECT * FROM DongSP WHERE Ma like ?";
    final String INSERT_SQL = """
                              declare @idDongSp uniqueidentifier
                              SET @idDongSp = NEWID()
                              INSERT INTO DongSP VALUES (@idDongSp,?,?)""";
    final String DELETE_SQL = "DELETE FROM DongSP WHERE Id=?";
    final String UPDATE_SQL = "UPDATE DongSP SET Ten=? WHERE Ma=?";

    public DongSPRepository() {
    }

    private List<DongSP> getSelectSql(String sql, Object... args) {
        List<DongSP> lstDongSp = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstDongSp.add(new DongSP(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstDongSp;
    }

    @Override
    public List<DongSP> findAllDongSP() {
        return getSelectSql(SELECT_SQL);
    }

    @Override
    public DongSP save(DongSP dongSp) {
        DBConnection.update(INSERT_SQL, dongSp.getMaDongSP(), dongSp.getTenDongSP());
        return dongSp;
    }

    @Override
    public String deleteDongSp(String id) {
        DBConnection.update(DELETE_SQL, id);
        return id;
    }

    @Override
    public DongSP updateDongSpByID(DongSP dongSp) {
        DBConnection.update(UPDATE_SQL, dongSp.getTenDongSP(),
                dongSp.getMaDongSP());
        return dongSp;
    }

    @Override
    public List<DongSP> getDongSpByMa(String ma) {
        List<DongSP> listDSP = new ArrayList<>();
        try {
            try ( PreparedStatement ps = DBConnection.stmt(SELECT_BY_MA, "%" + ma + "%")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    listDSP.add(new DongSP(rs.getString("Id"), rs.getString("Ma"),
                            rs.getString("Ten")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDSP;
    }

}
