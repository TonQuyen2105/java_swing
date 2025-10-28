import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class hello {
    private static boolean isFullScreen = false;
    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello");
        JLabel label = new JLabel("Nhấn F11 để bật/tắt Fullscreen", SwingConstants.CENTER);
        frame.add(label);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // căn giữa
        frame.setVisible(true);

        // Gán phím F11 cho hành động toggle fullscreen
        JRootPane root = frame.getRootPane();
        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F11"), "toggleFullScreen");
        root.getActionMap().put("toggleFullScreen", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleFullScreen(frame);
            }
        });
    }

    // Hàm chuyển đổi giữa 2 chế độ
    private static void toggleFullScreen(JFrame frame) {
        isFullScreen = !isFullScreen;
        frame.dispose(); // Phải dispose trước khi đổi undecorated

        if (isFullScreen) {
            frame.setUndecorated(true);
            device.setFullScreenWindow(frame); // Toàn màn hình thật
        } else {
            device.setFullScreenWindow(null);
            frame.setUndecorated(false);
            frame.setVisible(true);
        }
    }
}
