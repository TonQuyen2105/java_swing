import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("Hello");// này là tên của cửa sổ

        JLabel label = new JLabel("Hello, Swing!");// này là nội dung của label
        
        JLabel label2 = new JLabel();
        label2.setText("Hello, Swing 2!");
        ImageIcon image = new ImageIcon("#1 - 56b809f48e5d86f66835876860bf16cd.jpg");
        label2.setIcon(image);
        label2.setHorizontalTextPosition(JLabel.CENTER);// chữ ở giữa
        label2.setVerticalTextPosition(JLabel.TOP);// chữ ở trên
        label2.setForeground(new Color(0,255,0));
        label2.setFont(new Font("MV Boli",Font.PLAIN,20));
        label2.setIconTextGap(-25);
        label2.setBackground(Color.black);
        label2.setOpaque(true);// hiện nền
        
        Border border = BorderFactory.createLineBorder(Color.green,3);
        label2.setBorder(border);
        label2.setVerticalAlignment(JLabel.CENTER);// cả label ở giữa
        label2.setHorizontalAlignment(JLabel.CENTER);// cả label ở giữa
        // label2.setBounds(250,250,500,500);
        // label2.setBounds(0,0,1000,1000);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(1000, 1000);
        // this.setLayout(null);
        this.setVisible(true);
        // this.getContentPane().setBackground(java.awt.Color.CYAN);
        this.getContentPane().setBackground(new Color(0, 255, 255) );
        this.getContentPane().add(label);
        this.getContentPane().add(label2);
        this.pack();
    }
}
