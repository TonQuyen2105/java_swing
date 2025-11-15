package Asset;

import DB.ConnectDB;
import java.sql.*;
import java.util.Random;

public class order {

    public static void run() {
        try (Connection conn = ConnectDB.getConnection(true)) {
            if (conn == null) {
                System.out.println("💀 Không thể kết nối DB");
                return;
            }

            System.out.println("----- TẠO ORDERS CHO TẤT CẢ USER -----");

            Random rand = new Random();
            String[] statusList = {"finish", "shipping", "packed", "order"};

            // 1. Lấy danh sách toàn bộ Users
            PreparedStatement getUsers = conn.prepareStatement("SELECT UsersID FROM Users");
            ResultSet rsUsers = getUsers.executeQuery();

            while (rsUsers.next()) {

                int userId = rsUsers.getInt("UsersID");
                System.out.println("→ UserID: " + userId);

                // 2. Lấy địa chỉ đúng của user
                int addressId = getAddressOfUser(conn, userId);

                // Nếu user chưa có address → tự tạo 1 address mới
                if (addressId == -1) {
                    addressId = createAddressForUser(conn, userId);
                }

                // 3. Tạo 2–4 Orders cho từng user
                for (int k = 0; k < 3; k++) {

                    String status = statusList[rand.nextInt(statusList.length)];

                    PreparedStatement orderStmt = conn.prepareStatement(
                            "INSERT INTO Orders (UsersID, AddressID, Status, OrderDate) VALUES (?, ?, ?, GETDATE())",
                            Statement.RETURN_GENERATED_KEYS
                    );

                    orderStmt.setInt(1, userId);
                    orderStmt.setInt(2, addressId);
                    orderStmt.setString(3, status);
                    orderStmt.executeUpdate();

                    ResultSet rsOrder = orderStmt.getGeneratedKeys();
                    rsOrder.next();
                    int orderId = rsOrder.getInt(1);

                    // 4. Thêm sản phẩm vào OrderDetail
                    for (int j = 0; j < 2 + rand.nextInt(3); j++) {
                        int productId = getRandomProductId(conn);
                        int quantity = 1 + rand.nextInt(3);

                        PreparedStatement detailStmt = conn.prepareStatement(
                                "INSERT INTO OrderDetail (OrderID, ProductID, Quantity) VALUES (?, ?, ?)"
                        );
                        detailStmt.setInt(1, orderId);
                        detailStmt.setInt(2, productId);
                        detailStmt.setInt(3, quantity);
                        detailStmt.executeUpdate();
                    }
                }
            }

            System.out.println("🎉 Đã tạo orders cho toàn bộ user thành công!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Lấy địa chỉ đúng của user
    private static int getAddressOfUser(Connection conn, int userId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT TOP 1 AddressID FROM Addresses WHERE UsersID = ?"
        );
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) return rs.getInt(1);
        return -1;
    }

    // Tạo địa chỉ mới cho user
    private static int createAddressForUser(Connection conn, int userId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO Addresses (UsersID, ReceiverName, PhoneNumber, Address) VALUES (?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );
        stmt.setInt(1, userId);
        stmt.setString(2, "User " + userId);
        stmt.setString(3, "090000000" + userId);
        stmt.setString(4, "Địa chỉ mặc định user " + userId);

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    // Lấy random sản phẩm
    private static int getRandomProductId(Connection conn) throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT TOP 1 ProductID FROM Products ORDER BY NEWID()"
        );
        rs.next();
        return rs.getInt(1);
    }

    public static void main(String[] args) {
        run();
    }
}
