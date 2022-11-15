/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import Repositories.Interface.INsxRepository;
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
public class NsxRepository implements INsxRepository {

    final String SELECT_SQL = "SELECT * FROM NSX";
    final String SELECT_BY_MA = "SELECT * FROM NSX WHERE Ma like ?";
    final String INSERT_SQL = """
                       DECLARE @idNsx uniqueidentifier 
                       SET @idNsx = NEWID()
                       INSERT INTO NSX VALUES(@idNsx,?,?)""";
    final String DELETE_SQL = "DELETE FROM NSX WHERE Id=?";
    final String UPDATE_SQL = "UPDATE NSX SET Ten=? WHERE Ma=?";

    private List<NSX> selectSql(String sql, Object... args) {
        List<NSX> lstNsx = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.query(sql, args);
            while (rs.next()) {
                lstNsx.add(new NSX(rs.getString("Id"), rs.getString("Ma"),
                        rs.getString("Ten")));
            }
        } catch (SQLException e) {
            return null;
        }
        return lstNsx;
    }

    @Override
    public List<NSX> getAll() {
        return selectSql(SELECT_SQL);
    }

    @Override
    public NSX save(NSX nsx) {
        DBConnection.update(INSERT_SQL, nsx.getMaNsx(), nsx.getTenNsx());
        return nsx;
    }

    @Override
    public String delete(String idNsx) {
        DBConnection.update(DELETE_SQL, idNsx);
        return idNsx;
    }

    @Override
    public NSX updateNsx(NSX nsx) {
        DBConnection.update(UPDATE_SQL, nsx.getTenNsx(), nsx.getMaNsx());
        return nsx;
    }

    @Override
    public List<NSX> getNsxByMa(String ma) {
        List<NSX> lst = new ArrayList<>();
        try {
            try ( PreparedStatement ps = DBConnection.stmt(SELECT_BY_MA, "%" + ma + "%")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    lst.add(new NSX(rs.getString("Id"), rs.getString("Ma"),
                            rs.getString("Ten")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }

}
