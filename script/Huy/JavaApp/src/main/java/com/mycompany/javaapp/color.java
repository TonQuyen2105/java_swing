package com.mycompany.javaapp;

import java.sql.*;

public class color {
    public static void run() {
        try 
        {
            connectionDB conn = new connectionDB();
            Connection connect = conn.getConnection();
            
            System.out.println("-----------------------------------------");
            System.out.println("+Table: Color");
            
            String sql = "SELECT COUNT(*) AS total FROM Color";
            PreparedStatement pstmt = connect.prepareStatement(sql);
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
                PreparedStatement insertstmt = connect.prepareStatement( insertsql);
                
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
