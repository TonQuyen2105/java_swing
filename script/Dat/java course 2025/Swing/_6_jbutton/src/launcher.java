import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class launcher {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainframe frame = new mainframe();
                frame.show();
            }
        });
    }
}
