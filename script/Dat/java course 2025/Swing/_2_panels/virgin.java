import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class virgin {
    public static void main(String[] args) {
        JLabel label = new JLabel();// này là nội dung của label
        label.setText("Hello, Swing!");// này là nội dung của label
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        label.setForeground(new Color(255,255,255));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        JLabel label2 = new JLabel();
        label2.setText("Hello, Swing 2!");
        label2.setFont(new Font("MV Boli",Font.PLAIN,20));
        label2.setForeground(new Color(255,255,255));
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setBounds(0, 100, 200, 100);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 0, 200, 200);
        greenPanel.setLayout(new BorderLayout());

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 200, 200, 200);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(200, 0, 200, 200);
        bluePanel.setLayout(null);

        JFrame frame = new JFrame("Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null); 
        
        greenPanel.add(label);
        frame.add(greenPanel);
        
        redPanel.add(label2);
        frame.add(redPanel);

        // bluePanel.add(label);
        frame.add(bluePanel);


        
        
    }
}
