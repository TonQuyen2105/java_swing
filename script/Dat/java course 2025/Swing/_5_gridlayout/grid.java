import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;


public class grid {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10)); // 3 rows, 3 columns, 10px gaps
        JFrame frame = new JFrame("Grid Layout Example");

        panel.setBackground(Color.lightGray);

        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Button " + i));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
    }
    
}
