/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FirstStep.asset.API;

import FirstStep.database.DBConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 *
 * @author acebi
 */
public class ImportUsersFromAPI {
    public static void run() {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Không thể kết nối cơ sở dữ liệu.");
                return;
            }

            System.out.println("🌐 Đang gọi API JSONPlaceholder...");

            // 1️⃣ Gọi API
            String apiUrl = "https://jsonplaceholder.typicode.com/users/";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) response.append(line);
            }

            // 2️⃣ Parse JSON
            Gson gson = new Gson();
            JsonArray users = gson.fromJson(response.toString(), JsonArray.class);

            // 3️⃣ Insert vào bảng users
            String sql = """
                INSERT INTO users (username, password, role)
                VALUES (?, ?, ?)
                ON CONFLICT (username) DO NOTHING
            """;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Random random = new Random();
            String[] roles = {"admin", "staff", "customer"};

            for (int i = 0; i < users.size(); i++) {
                JsonObject u = users.get(i).getAsJsonObject();
                String username = u.get("username").getAsString();
                String password = "pass" + (1000 + random.nextInt(9000));
                String role = roles[random.nextInt(roles.length)];

                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, role);
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            System.out.println("✅ Đã import " + users.size() + " user từ API vào bảng users!");
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
