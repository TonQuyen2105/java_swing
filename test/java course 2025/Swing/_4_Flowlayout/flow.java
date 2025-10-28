import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
public class flow {

    public static void main(String[] args) {
        
        // JPanel panel = new JPanel();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JFrame frame = new JFrame("Flow Layout Example");

        // panel.setLayout(new java.awt.FlowLayout());
        // panel.setToolTipText("This is a panel with FlowLayout");

        panel.setBackground(Color.pink);

        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton("Button " + i));

        }

        // panel.add(new JButton("Button 1"));
        // panel.add(new JButton("Button 2"));
        // panel.add(new JButton("Button 3"));

        // Add components to the panel here if needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel, BorderLayout.NORTH);
    }
}
