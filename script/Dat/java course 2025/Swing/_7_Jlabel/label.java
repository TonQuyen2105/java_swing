import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;


public class label {
    public JLabel label;
    public JFrame frame;
    public JPanel panel = new JPanel();

    public void initialize() {
        frame = new JFrame("JLabel Example");
        
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.PINK);
        label = new JLabel("Hello, this is a JLabel!");
        label.setForeground(Color.RED);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));

        ImageIcon labelIcon = new ImageIcon("1.png");
        Image img = labelIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.add(panel, BorderLayout.NORTH);
        panel.add(label);
        frame.setVisible(true); 
    }

    public static void main(String[] args) {
        label myLabel = new label();
        myLabel.initialize();
    }
}




