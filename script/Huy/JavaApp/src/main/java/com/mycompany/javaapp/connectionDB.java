package com.mycompany.javaapp;
import java.sql.*;

/**
 *
 * @author acebi
 */
public class connectionDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=App_sale_giay;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";
    public Connection getConnection() throws SQLException 
    {
        return getConnection(false);
    }
    
    public static Connection getConnection(boolean silent) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!silent) {
                System.out.println("Ket noi thanh cong!");
            }
            else{
                System.out.println("Ket noi that bai!");
            }
            return conn;
        } catch (ClassNotFoundException e) {
            if (!silent) {
                System.err.println("Khong tim thay Driver JDBC!");
            }
        }
        return null;
    }
}
