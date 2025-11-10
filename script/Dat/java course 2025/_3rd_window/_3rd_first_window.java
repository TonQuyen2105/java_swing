import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.*;

public class _3rd_first_window {
    public static void main(String[] args) {
        // Chạy trên luồng giao diện để tránh lỗi
        SwingUtilities.invokeLater(() -> {
            // Tạo cửa sổ
            JFrame frame = new JFrame("My First Window");
            frame.setSize(400, 200); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon icon = new ImageIcon("3974682-200.png"); // ảnh PNG cùng thư mục
            frame.setIconImage(icon.getImage());


            // Thêm label vào cửa sổ
            JLabel label = new JLabel("Hello, World!", JLabel.CENTER);
            frame.add(label);

            // Hiển thị
            frame.setVisible(true);
        });
    }
}
