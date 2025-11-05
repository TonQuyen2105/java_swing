import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class alpha {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JButton button = new JButton("Click Me!");
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}
                                                                        