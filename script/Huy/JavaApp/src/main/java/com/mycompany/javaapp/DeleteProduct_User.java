/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapp;

//import DBConnectDB;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 *
 * @author acebi
 */
public class DeleteProduct_User {

    public static void deleteAllProducts() {
        try 
        {   
            connectionDB conn = new connectionDB();
            Connection connect = conn.getConnection();
            
            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Product...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {"DELETE FROM Products"};

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = connect.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Products', RESEED, 0)";
            try (PreparedStatement stmt = connect.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại ProductID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Products!");
            System.out.println("-----------------------------------------");

        } 
        catch (Exception e) 
        {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
    public static void deleteAllUsers() {
        try {
            connectionDB conn = new connectionDB();
            Connection connect = conn.getConnection();

            System.out.println("-----------------------------------------");
            System.out.println("🗑️ Đang xóa toàn bộ dữ liệu Product...");

            // Xóa dữ liệu ở các bảng phụ thuộc trước (nếu có)
            String[] deleteSQLs = {
                    "DELETE FROM Users"
            };

            for (String sql : deleteSQLs) {
                try (PreparedStatement stmt = connect.prepareStatement(sql)) {
                    int rows = stmt.executeUpdate();
                    System.out.println("   ✅ Đã xóa " + rows + " dòng trong bảng: " + sql.split(" ")[2]);
                }
            }

            // Đặt lại IDENTITY về 1
            String resetSQL = "DBCC CHECKIDENT ('Users', RESEED, 0)";
            try (PreparedStatement stmt = connect.prepareStatement(resetSQL)) {
                stmt.executeUpdate();
                System.out.println("   🔁 Đã đặt lại UsersID về 1.");
            }

            System.out.println("✅ Hoàn tất xóa toàn bộ bảng Users!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }
    
    public static void main(String args[]) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        deleteAllProducts();
        deleteAllUsers();
    }

}