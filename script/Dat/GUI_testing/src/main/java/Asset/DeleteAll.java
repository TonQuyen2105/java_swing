/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asset;

import DB.ConnectDB;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author acebi
 */
public class DeleteAll {

    public static void deleteAllProducts() {
        try (Connection conn = ConnectDB.getConnection()) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Product...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
//                    "DELETE FROM Cart",
//                    "DELETE FROM OrderDetail",
                    "DELETE FROM Products"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Products', RESEED, 0)";
            try (PreparedStatement stmt = conn.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại ProductID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Products!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
    public static void deleteAllUsers() {
        try (Connection conn = ConnectDB.getConnection()) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Users...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
                    "DELETE FROM Users"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Users', RESEED, 0)";
            try (PreparedStatement stmt = conn.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại UsersID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Users!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
        public static void deleteAllAddress() {
        try (Connection conn = ConnectDB.getConnection()) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Addresses...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
                    "DELETE FROM Addresses"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Addresses', RESEED, 0)";
            try (PreparedStatement stmt = conn.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại UsersID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Addresses!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
        
        public static void deleteAllOrders() {
        try (Connection conn = ConnectDB.getConnection()) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Orders...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
                    "DELETE FROM Orders"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Orders', RESEED, 0)";
            try (PreparedStatement stmt = conn.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại UsersID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Orders!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
        
        public static void deleteAllDetailOrders() {
        try (Connection conn = ConnectDB.getConnection()) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Detail Orders...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
                    "DELETE FROM OrderDetail"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('OrderDetail', RESEED, 0)";
            try (PreparedStatement stmt = conn.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại UsersID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Detail Orders!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
        
        
        
    public static void main(String args[]) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
//        deleteAllProducts();
        deleteAllDetailOrders();
        deleteAllOrders();
        deleteAllAddress();
        deleteAllUsers();
        
    }

}
