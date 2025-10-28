/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acebi
 */
public class ConnectDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=APP_sale_giay;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "SQLServer";
    private static final String PASSWORD = "bill599199";

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Kết nối SQL Server thành công!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Lỗi kết nối SQL Server: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Không tìm thấy Driver JDBC!");
        }
        return null;
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.setOut(new PrintStream(System.out, true, "UTF-8"));
//        getConnection(); // test thử
//    
//    }
//    public static void main(String[] args) {
//        getConnection(); // test thử
//    
//    }
//    public static void main(String[] args) {
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=APP_sale_giay;encrypt=false;trustServerCertificate=true;";
//        String user = "SQLServer";
//        String password = "bill599199";  // đổi lại đúng mật khẩu của bạn
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("✅ Kết nối SQL Server thành công!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
