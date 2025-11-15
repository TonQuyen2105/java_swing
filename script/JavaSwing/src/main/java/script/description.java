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
public class description {
    public static void run() {
        try {
            ConnectDB conn = new ConnectDB();
            Connection con = conn.getConnection();
            System.out.println("-----------------------------------------");
            System.out.println("+Table: Description");
            
            String sql = "SELECT COUNT(*) AS total FROM Description";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            int count = 0; 
            if (rs.next()) {
                count = rs.getInt("total");
            }
            
            if (count > 0) {
                System.out.println("    ✅ Bảng Description đã có " + count + " mô tả, không cần thêm mới.");
            } else {
                System.out.println("    ⚠️ Bảng Description trống. Đang thêm 2 màu mẫu...");
                
                String[] descriptions = {
                    "test với lại xem rằng ta có cố ý làm trái gì không với những điều mà đó giờ ta phạm phải", 
                    "hãy gia nhập vào làng sóng lớn để có thể là một thành viên của một khối đoàn kết lớn"
                };
                
                String insertsql = "INSERT INTO Description (Content) VALUES (?)";
                PreparedStatement insertstmt = con.prepareStatement( insertsql);
                
                for (String description : descriptions) {
                    insertstmt.setString(1, description);
                    insertstmt.addBatch();
                }
                insertstmt.executeBatch();
                System.out.println("    ✅ Đã thêm 2 mô tả vào bảng Desciption!");
            }
            System.out.println("-----------------------------------------");
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
    }
}