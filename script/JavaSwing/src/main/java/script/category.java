/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package script;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acebi
 */
public class category {
    public static void run() {
        try {
            ConnectDB conn = new ConnectDB();
            Connection con = conn.getConnection();
            System.out.println("-----------------------------------------");
            System.out.println("+Table: Category");
            
            String sql = "SELECT COUNT(*) AS total FROM Category";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            int count = 0; 
            if (rs.next()) {
                count = rs.getInt("total");
            }
            
            if (count > 0) {
                System.out.println("    ✅ Bảng Category đã có " + count + " loại, không cần thêm mới.");
            } else {
                System.out.println("    ⚠️ Bảng Category trống. Đang thêm 4 màu mẫu...");
                
                String[] categorys = {
                    "Giày thường", 
                    "Giày cao cấp", 
                    "Giày củ", 
                    "Giày rẻ rách"
                };
                
                String insertsql = "INSERT INTO Category (CategoryName) VALUES (?)";
                PreparedStatement insertstmt = con.prepareStatement( insertsql);
                
                for (String category : categorys) {
                    insertstmt.setString(1, category);
                    insertstmt.addBatch();
                }
                insertstmt.executeBatch();
                System.out.println("    ✅ Đã thêm 4 loại vào bảng Category!");
            }
            System.out.println("-----------------------------------------");
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
