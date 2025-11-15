/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package script;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author acebi
 */
public class user {
    public static void run() {
        try {
            ConnectDB conn = new ConnectDB();
            Connection con = conn.getConnection();
            System.out.println("-----------------------------------------");
            System.out.println("+Table: User");
            System.out.println("🌐 Đang đợi API JSONPlaceholder sủa về...");

            String apiUrl = "https://jsonplaceholder.typicode.com/users/";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            Gson gson = new Gson();
            JsonArray users = gson.fromJson(response.toString(), JsonArray.class);

            String sql = """
                         INSERT INTO Users (Username, Email, Password, Name)
                         SELECT ?, ?, ?, ?
                         WHERE NOT EXITS (SELECT 1 FROM Users WHERE Username = ?""";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Random random = new Random();

            for (int i = 0; i < users.size(); i++) {
                JsonObject u = users.get(i).getAsJsonObject();
                String username = u.get("username").getAsString();
                String email = u.get("email").getAsString();
                String password = "pass" + (1000 + random.nextInt(9000));            
                String name = u.get("name").getAsString();
                
                pstmt.setString(1, username);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setString(4, name);
                pstmt.setString(5, username);
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            System.out.println("✅ Đã import tùm lum " + users.size() + " user từ API vào bảng users!");

            String testUserSql = """                           
                IF NOT EXISTS (SELECT 1 FROM Users WHERE Username = '1' AND Email = '1@g.com')
                INSERT INTO Users (Username, Email, Password, Name ) VALUES ('1', '1@g.com', '1', 'testsubject');
            """;

            PreparedStatement testStmt = con.prepareStatement(testUserSql);
            testStmt.executeUpdate();
            System.out.println("👤 Đã thêm người dùng test: user: 1 /pass: 1");
            System.out.println("-----------------------------------------");
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
    }
    public static void main (String args[]) {
        run();
    }
}
