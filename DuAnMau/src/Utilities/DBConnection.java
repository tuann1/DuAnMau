/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Laptop
 */
public class DBConnection {

    private static final String hostname = "localhost";
    private static final String user = "sa";
    private static final String password = "123456";
    private static final String port = "1433";
    private static final String databaseName = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041";
    private static boolean USSING_SSL = true;
    private static Connection con;

    private static String CONNECT_STRING;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(hostname).append(":").append(port).append(";")
                    .append("databaseName=").append(databaseName).append(";")
                    .append("user=").append(user).append(";")
                    .append("password=").append(password).append(";");
            if (USSING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Mở kết nối
    public static Connection openDbConnection() {
        try {
            return DriverManager.getConnection(CONNECT_STRING);
        } catch (SQLException e) {
            return null;
        }
    }

    //Chuẩn bị câu truy vấn trước khi thực thi
    public static PreparedStatement stmt(String sql, Object... args) {
        try {
            con = openDbConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps;
        } catch (SQLException e) {
            return null;
        }
    }

    //Truy vấn Thêm, Sửa, Xóa
    public static int update(String sql, Object... args) {
        PreparedStatement ps = stmt(sql, args);
        try {
            try {
                return ps.executeUpdate();
            } finally {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Loi Update");
            e.printStackTrace();
            return 0;
        }
    }

    //Trả lại một đối tượng
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = stmt(sql, args);
        return ps.executeQuery();
    }

}
