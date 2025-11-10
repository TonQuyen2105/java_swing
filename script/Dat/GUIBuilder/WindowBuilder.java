import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(986, 533);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JPasswordField element1 = new JPasswordField("");
     element1.setBounds(340, 313, 270, 21);
     element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element1.setBackground(Color.decode("#B2B2B2"));
     element1.setForeground(Color.decode("#656565"));
     element1.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element1, "Your Password!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element1);

     JButton element2 = new JButton("Click Me");
     element2.setBounds(424, 358, 118, 29);
     element2.setBackground(Color.decode("#2e2e2e"));
     element2.setForeground(Color.decode("#D9D9D9"));
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element2.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     element2.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element2, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(element2);

     JTextField element3 = new JTextField("");
     element3.setBounds(340, 197, 271, 21);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element3.setBackground(Color.decode("#B2B2B2"));
     element3.setForeground(Color.decode("#656565"));
     element3.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element3, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element3);

     JLabel element4 = new JLabel("Your account");
     element4.setBounds(350, 149, 106, 17);
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element4.setForeground(Color.decode("#D9D9D9"));
     panel.add(element4);

     JLabel element5 = new JLabel("Your Text");
     element5.setBounds(347, 257, 106, 17);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element5.setForeground(Color.decode("#D9D9D9"));
     panel.add(element5);

     frame.add(panel);
     frame.setVisible(true);

  }
}