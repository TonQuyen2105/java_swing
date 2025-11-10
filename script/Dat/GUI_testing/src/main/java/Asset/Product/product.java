/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asset.Product;

import DB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author acebi
 */
public class product {
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
            System.out.println("+Table: Product");
            color.run();
            description.run();
            category.run();
            System.out.println("+Continue...");
            
            String sql = "SELECT COUNT(*) AS total FROM Products";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            int count = 0;
            if (rs.next()) {
                count = rs.getInt("total");
            }
            
            if (count > 0) {
                System.out.println("✅ Bảng Products đã có " + count + " sản phẩm, không cần thêm mới.");
                System.out.println("-----------------------------------------");
                return;
            }
                        
            System.out.println("⚠️ Bảng Products trống. Đang thêm 50 sản phẩm mẫu...");

            // Lấy số lượng Color, Category, Description để random foreign key
            int colorCount = getCount(conn, "Color");
            int categoryCount = getCount(conn, "Category");
            int descriptionCount = getCount(conn, "Description");

            String insertSql = """
                INSERT INTO Products (ProductName, Price, Stock, Size, PicturePath, ColorID, CategoryID, DescriptionID)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            Random random = new Random();

            String[] baseNames = {
                "Air Max", "Jordan", "Yeezy", "Converse", "Vans",
                "Adidas Run", "Nike Zoom", "Puma Street", "New Balance", "Reebok Fit"
            };
//            String[] baseNames = {
//                "Nike Air Max", "Air Jordan", "Puma RS", "Adidas Ultraboost", "Converse Chuck",
//                "Vans Old Skool", "Reebok Classic", "New Balance 574", "ASICS Gel", "Under Armour HOVR"
//            };
            String[] sizeList = {"38", "39", "40", "41", "42"}; // 5 size cho mỗi sản phẩm
            int[] stockOptions = {1, 5, 10, 100};

            int totalProducts = 40;
            for (int i = 1; i <= totalProducts; i++) {
                String productBaseName = baseNames[(i - 1) % baseNames.length] + " #" + i;
                double basePrice = 500_000 + random.nextInt(2_000_000); // 500k - 2.5tr
                int colorID = 1 + random.nextInt(colorCount);
                int categoryID = 1 + random.nextInt(categoryCount);
                int descriptionID = 1 + random.nextInt(descriptionCount);
                
                // Mỗi sản phẩm có 5 size riêng
//                for (String size : sizeList) {
//                    insertStmt.setString(1, productBaseName + " - Size " + size);
//                    insertStmt.setDouble(2, basePrice);
//                    insertStmt.setInt(3, stockOptions[random.nextInt(stockOptions.length)]);
//                    insertStmt.setString(4, size);
//                    insertStmt.setString(5, "nill"); // not null
//                    insertStmt.setInt(6, 1 + random.nextInt(colorCount));
//                    insertStmt.setInt(7, 1 + random.nextInt(categoryCount));
//                    insertStmt.setInt(8, 1 + random.nextInt(descriptionCount));
//                    insertStmt.addBatch();
//                }
                for (String size : sizeList) {
                    insertStmt.setString(1, productBaseName + " - Size " + size);
                    insertStmt.setDouble(2, basePrice);
                    insertStmt.setInt(3, stockOptions[random.nextInt(stockOptions.length)]);
                    insertStmt.setString(4, size);
                    insertStmt.setString(5, "nill"); // not null
                    insertStmt.setInt(6, colorID);
                    insertStmt.setInt(7, categoryID);
                    insertStmt.setInt(8, descriptionID);
                    insertStmt.addBatch();
                }
            }

            insertStmt.executeBatch();
            System.out.println("✅ Đã thêm " + totalProducts + "sản phẩm (mỗi sản phẩm có 5 size).");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    private static int getCount(Connection conn, String tableName) {
        try {
            String sql = "SELECT COUNT(*) AS total FROM " + tableName;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt("total");
        } catch (SQLException ignored) {}
        return 0;
    }
}