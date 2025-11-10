/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FirstStep.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author acebi
 */
public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/firststep";
    private static final String USER = "postgres";
    private static final String PASSWORD = "bill599199";

    // 🔹 Kết nối cơ sở dữ liệu
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
            return null;
        }
    }

    // 🔹 Hàm đọc file SQL và chạy (tạo bảng)
    public static void checkDB() {
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.out.println("❌ Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            // Đường dẫn đến file SQL (tùy vị trí file của bạn)
//            String sql = Files.readString(Path.of("UsersSchema.sql"));
            String sql = Files.readString(Path.of("C:\\Users\\acebi\\Documents\\Code\\java\\mavenproject1\\src\\main\\java\\FirstStep\\database\\UsersSchema.sql"));

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
                System.out.println("✅ Bảng đã được tạo thành công!");
            }

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi đọc hoặc chạy file SQL:");
//            e.printStackTrace();
        }
    }

    // 🔹 Kiểm tra kết nối và tạo bảng
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("✅ Kết nối PostgreSQL thành công!");
        } else {
            System.out.println("❌ Kết nối thất bại!");
        }

        checkDB();
    }
}