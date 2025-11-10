import javax.swing.*;
import java.awt.*;



public class borderlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border Layout Example");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(10); // Set horizontal gap
        layout.setVgap(10); // Set vertical gap
        frame.setLocationRelativeTo(null);

        // frame.setLayout(new BorderLayout(10, 10)); // 10 pixels horizontal and vertical gaps
        frame.setLayout(layout);

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.add(new JButton("Center"), BorderLayout.CENTER);

        // JPanel panel = new JPanel();
        // panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JLabel label1 = new JLabel("Label 1");
        // panel.add(label1, BorderLayout.NORTH);
        
        // JLabel label2 = new JLabel("Label 2");
        // panel.add(label2, BorderLayout.CENTER);
        
        // JLabel label3 = new JLabel("Label 3");
        // panel.add(label3, BorderLayout.SOUTH);
        
        // frame.add(panel);

        frame.setVisible(true);
    }
}
