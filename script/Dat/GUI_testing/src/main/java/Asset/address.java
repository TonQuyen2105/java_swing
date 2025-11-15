///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Asset;
//
///**
// *
// * @author acebi
// */
//import DB.ConnectDB;
//import com.google.gson.*;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//public class address {
//    public static void run() {
//
//        try (Connection conn = ConnectDB.getConnection(true)) {
//
//            if (conn == null) {
//                System.out.println("❌ Không thể kết nối database");
//                return;
//            }
//
//            System.out.println("-----------------------------------------");
//            System.out.println("+Table: Addresses");
//            System.out.println("🌐 Đang lấy address từ API JSONPlaceholder...");
//
//            String apiUrl = "https://jsonplaceholder.typicode.com/users/";
//            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
//            connection.setRequestMethod("GET");
//
//            StringBuilder response = new StringBuilder();
//            try (BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(connection.getInputStream()))) {
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//            }
//
//            Gson gson = new Gson();
//            JsonArray users = gson.fromJson(response.toString(), JsonArray.class);
//
//            // SQL insert address
//            String sql = """
//                INSERT INTO Addresses (UsersID, ReceiverName, PhoneNumber, Address)
//                VALUES (?, ?, ?, ?);
//            """;
//
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            int userId = 10;  // user test
//
//            for (int i = 0; i < users.size(); i++) {
//                JsonObject u = users.get(i).getAsJsonObject();
//
//                String name = u.get("name").getAsString();
//                String phone = u.get("phone").getAsString();
//
//                JsonObject addr = u.get("address").getAsJsonObject();
//                String fullAddress =
//                        addr.get("street").getAsString() + ", " +
//                        addr.get("suite").getAsString() + ", " +
//                        addr.get("city").getAsString() + ", " +
//                        addr.get("zipcode").getAsString();
//
//                pstmt.setInt(1, userId);
//                pstmt.setString(2, name);
//                pstmt.setString(3, phone);
//                pstmt.setString(4, fullAddress);
//                pstmt.addBatch();
//            }
//
//            pstmt.executeBatch();
//            System.out.println("✅ Đã import " + users.size() + " địa chỉ cho user test (UsersID = 1)");
//            System.out.println("-----------------------------------------");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package Asset;

import DB.ConnectDB;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class address {

    public static void run() {

        try (Connection conn = ConnectDB.getConnection(true)) {

            if (conn == null) {
                System.out.println("❌ Không thể kết nối database");
                return;
            }

            System.out.println("-----------------------------------------");
            System.out.println("+Table: Addresses");
            System.out.println("🌐 Đang kết nối API JSONPlaceholder...");

            // ============================================
            // 1) LẤY DANH SÁCH USER TỪ DATABASE
            // ============================================
            List<Integer> userIds = new ArrayList<>();
            String fetchUsersSql = "SELECT UsersID FROM Users ORDER BY UsersID";

            try (PreparedStatement ps = conn.prepareStatement(fetchUsersSql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    userIds.add(rs.getInt("UsersID"));
                }
            }

            if (userIds.isEmpty()) {
                System.out.println("⚠ Không có user nào trong database!");
                return;
            }

            int userCount = userIds.size();
            System.out.println("🔍 Tìm thấy " + userCount + " user.");

            // ============================================
            // 2) LẤY 9 ĐỊA CHỈ TỪ API JSONPLACEHOLDER
            // ============================================
            String apiUrl = "https://jsonplaceholder.typicode.com/users/";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            Gson gson = new Gson();
            JsonArray jsonUsers = gson.fromJson(response.toString(), JsonArray.class);

            // ============================================
            // 3) INSERT ADDRESS VÀO DATABASE
            // ============================================
            String insertSql = """
                INSERT INTO Addresses (UsersID, ReceiverName, PhoneNumber, Address)
                VALUES (?, ?, ?, ?)
            """;
            PreparedStatement pstmt = conn.prepareStatement(insertSql);

            // -----> Cho User từ 1 → userCount-1: dùng API
            for (int i = 0; i < userCount - 1; i++) {
                JsonObject u = jsonUsers.get(i).getAsJsonObject();

                String receiver = u.get("name").getAsString();
                String phone = u.get("phone").getAsString();

                JsonObject addr = u.get("address").getAsJsonObject();
                String fullAddress =
                        addr.get("street").getAsString() + ", " +
                        addr.get("suite").getAsString() + ", " +
                        addr.get("city").getAsString() + ", " +
                        addr.get("zipcode").getAsString();

                pstmt.setInt(1, userIds.get(i));
                pstmt.setString(2, receiver);
                pstmt.setString(3, phone);
                pstmt.setString(4, fullAddress);
                pstmt.addBatch();
            }

            // -----> User cuối cùng → tạo address custom
            int lastUserId = userIds.get(userCount - 1);

            pstmt.setInt(1, lastUserId);
            pstmt.setString(2, "Custom User");
            pstmt.setString(3, "0900000000");
            pstmt.setString(4, "123 Đường Tự Tạo, Phường Seeder, Thành phố Java");
            pstmt.addBatch();

            pstmt.executeBatch();

            System.out.println("✅ Đã tạo " + userCount + " địa chỉ cho các user!");
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
