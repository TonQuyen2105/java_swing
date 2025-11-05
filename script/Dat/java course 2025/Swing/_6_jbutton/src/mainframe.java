import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;


import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.SwingConstants;


public class mainframe {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private String originalText;
    public mainframe() {
    initialize();
    }

    private void initialize() {
        frame = new JFrame("Main Frame");
        panel = new JPanel();
        button = createButton();

        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getRootPane().registerKeyboardAction(
            e -> {
                frame.dispose();
                System.out.println("leaving me for your own good? :("); 
            },
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }

    private JButton createButton() {
        // button = new JButton("Click Me");
        button = new JButton("Sick my duck");
        button.setFocusable(false);
        button.addActionListener(e -> System.out.println("Button clicked!"));

        ImageIcon icon = new ImageIcon("#1 - 56b809f48e5d86f66835876860bf16cd.jpg");
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
        // button.setIcon(icon);

        button.setIconTextGap(10);

        button.setMnemonic(KeyEvent.VK_A); // Alt + A to activate the button only for alt key

        // frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        //     KeyStroke.getKeyStroke('c'), "pressButton");

        // frame.getRootPane().getActionMap().put("pressButton", new AbstractAction() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         button.doClick();
        //     }
        // });

        enterkey('s');

        activekey((char) KeyEvent.VK_ESCAPE, () -> frame.dispose());

        activekey('c', () -> button.doClick());

        activekey('x', () -> System.out.println("Pressed X!"));

        activekey('q', () -> {
            frame.dispose();
            System.err.println("thanks for loving me <3");
        });

        activekey('e', () -> button.setEnabled(!button.isEnabled()));
        activekey('r', () -> {
            boolean state = !button.isEnabled();
            button.setEnabled(state);
            // button.setText(state ? button.getText() : "Disabled");
            System.out.println("Button is now " + (state ? "ENABLED" : "DISABLED"));
        });
        activekey('t', () -> toggleButton(button));

        button.setToolTipText("press c to interact or alt+c");

        button.setFont(new Font("Arial", Font.PLAIN,24));

        button.setMargin(new Insets(10, 10, 10, 10));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Another Action Listener!");
            }
        });

        button.doClick();

        // button.setVerticalTextPosition(SwingConstants.BOTTOM);
        // button.setHorizontalTextPosition(JButton.CENTER);

        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.LEFT);

        button.setPreferredSize(new Dimension(200, 75));

        return button;
    }

    private void enterkey(char key){
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(key), "pressButton");

        frame.getRootPane().getActionMap().put("pressButton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });

    }

    private void activekey(char key, Runnable action) {
        String actionName = "action_" + key;

        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(key), actionName);

        frame.getRootPane().getActionMap().put(actionName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
    }

    private void toggleButton(JButton btn) {
        if (originalText == null) {
            originalText = btn.getText(); // chỉ lưu 1 lần
        }
        boolean state = !btn.isEnabled();
        btn.setEnabled(state);
        btn.setText(state ? originalText : "Disabled");
        System.out.println("Button is now " + (state ? "ENABLED" : "DISABLED"));
    }



    public void show() {
        this.frame.setVisible(true);
    }
}

