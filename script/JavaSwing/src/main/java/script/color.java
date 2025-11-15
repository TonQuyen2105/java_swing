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
public class color {
    public static void run() {
        try {
            ConnectDB conn = new ConnectDB();
            Connection con = conn.getConnection();
            System.out.println("-----------------------------------------");
            System.out.println("+Table: Color");
            
            String sql = "SELECT COUNT(*) AS total FROM Color";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            int count = 0; 
            if (rs.next()) {
                count = rs.getInt("total");
            }
            
            if (count > 0) {
                System.out.println("    ✅ Bảng Color đã có " + count + " màu, không cần thêm mới.");
            } else {
                System.out.println("    ⚠️ Bảng Color trống. Đang thêm 10 màu mẫu...");
                
                String[] colors = {
                    "Red", "Green", "Blue", "Yellow", "Orange",
                    "Purple", "Black", "White", "Gray", "Pink"
                };
                
                String insertsql = "INSERT INTO Color (ColorName) VALUES (?)";
                PreparedStatement insertstmt = con.prepareStatement( insertsql);
                
                for (String color : colors) {
                    insertstmt.setString(1, color);
                    insertstmt.addBatch();
                }
                insertstmt.executeBatch();
                System.out.println("    ✅ Đã thêm 10 màu vào bảng Color!");
            }
            System.out.println("-----------------------------------------");
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
    }
}