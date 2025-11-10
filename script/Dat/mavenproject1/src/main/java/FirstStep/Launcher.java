package FirstStep;

import FirstStep.asset.API.ImportUsersFromAPI;
import FirstStep.view.FirstHorizone;
import FirstStep.database.DBConnection;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

//import FirstStep.view.FirstHorizone;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acebi
 */
public class Launcher {
    public static void main(String args[]) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        /* Create and display the form */
        // Gọi kiểm tra bảng trước khi mở app
        DBConnection.checkDB();
        
        // Gọi API để import dữ liệu
        ImportUsersFromAPI.run();
        
        // phần còn lại của code khởi chạy giao diện
        System.out.println("🚀 Ứng dụng đã khởi động!");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new FirstHorizone().setVisible(true);
        });
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FirstHorizone().setVisible(true);
//            }
//        });
    }
}
