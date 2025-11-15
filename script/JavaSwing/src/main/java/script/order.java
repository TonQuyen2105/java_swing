/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package script;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class order {
    public static void run() {
        try (Connection conn = ConnectDB.getConnection(true)) {
            if (conn == null) {
                System.out.println("-----------------------------------------");
                System.out.println("💀 Không thể kết nối cơ sở dữ liệu.");
                System.out.println("😞 Mission FAIL  We'll Get Em Next Time");
                System.out.println("-----------------------------------------");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("+Table: Orders + OrderDetail");

            // Nếu chưa có user test thì tạo
            String testUserSql = """
                IF NOT EXISTS (SELECT 1 FROM Users WHERE Username = '1' AND Email = '1@g.com')
                INSERT INTO Users (Username, Email, Password, Name )
                VALUES ('1', '1@g.com', '1', 'testsubject');
            """;
            try (PreparedStatement testStmt = conn.prepareStatement(testUserSql)) {
                testStmt.executeUpdate();
            }

            int userId = getUserId(conn, "1"); // lấy ID user vừa tạo
            int addressId = getRandomAddressId(conn); // nếu bạn có bảng Address

            // ✅ Thêm 3 đơn hàng mẫu
            String insertOrderSql = """
                INSERT INTO Orders (UsersID, AddressID, Status, OrderDate)
                VALUES (?, ?, ?, GETDATE());
            """;

            String insertDetailSql = """
                INSERT INTO OrderDetail (OrderID, ProductID, Quantity)
                VALUES (?, ?, ?);
            """;

            Random rand = new Random();
            String[] statusList = {"finish", "shipping", "packed", "order"};

            for (int i = 0; i < 3; i++) {
                String status = statusList[rand.nextInt(statusList.length)];

                try (PreparedStatement orderStmt = conn.prepareStatement(insertOrderSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    orderStmt.setInt(1, userId);
                    orderStmt.setInt(2, addressId);
                    orderStmt.setString(3, status);
                    orderStmt.executeUpdate();

                    // Lấy OrderID vừa thêm
                    try (ResultSet rs = orderStmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            int orderId = rs.getInt(1);

                            // ✅ Thêm 2–4 sản phẩm ngẫu nhiên vào chi tiết đơn hàng
                            for (int j = 0; j < 2 + rand.nextInt(3); j++) {
                                int productId = getRandomProductId(conn);
                                int quantity = 1 + rand.nextInt(3);

                                try (PreparedStatement detailStmt = conn.prepareStatement(insertDetailSql)) {
                                    detailStmt.setInt(1, orderId);
                                    detailStmt.setInt(2, productId);
                                    detailStmt.setInt(3, quantity);
                                    detailStmt.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("✅ Đã thêm 3 đơn hàng mẫu và chi tiết sản phẩm thành công!");
            System.out.println("-----------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Lấy ID user test
    private static int getUserId(Connection conn, String username) throws SQLException {
        String sql = "SELECT UsersID FROM Users WHERE Username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 1;
    }

    // 🔹 Lấy ngẫu nhiên ProductID
    private static int getRandomProductId(Connection conn) throws SQLException {
        String sql = "SELECT TOP 1 ProductID FROM Products ORDER BY NEWID()";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        }
        return 1;
    }

    // 🔹 Lấy ngẫu nhiên AddressID (nếu có bảng Address)
    private static int getRandomAddressId(Connection conn) throws SQLException {
        String sql = "SELECT TOP 1 AddressID FROM Addresses ORDER BY NEWID()";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        }
        return 1; // nếu không có dữ liệu
    }
    
    public static void main (String args[]) {
        run();
    }
}