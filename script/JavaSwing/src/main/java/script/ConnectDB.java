 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package script;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acebi
 */
public class ConnectDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=APP_sale_giay;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";
    
    public static Connection getConnection() {
        return getConnection(false); // mặc định có log
    }
    
    public static Connection getConnection(boolean silent) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!silent) {
                System.out.println("✅ Kết nối SQL Server thành công!");
            }
            return conn;
        } catch (SQLException e) {
            if (!silent) {
                System.err.println("❌ Lỗi kết nối SQL Server: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            if (!silent) {
                System.err.println("❌ Không tìm thấy Driver JDBC!");
            }
        }
        return null;
    }
}