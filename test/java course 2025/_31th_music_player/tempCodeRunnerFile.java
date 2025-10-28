import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MusicPlayerFolder extends JFrame {
    private Clip clip;
    private String[] playlist;
    private int currentIndex = 0;
    private JLabel lblStatus;

    private final File defaultFolder = new File("music"); // thư mục mặc định

    public MusicPlayerFolder() {
        super("Music Player (WAV only)");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Kiểm tra và tạo folder mặc định nếu chưa có
        if (!defaultFolder.exists()) {
            if (defaultFolder.mkdirs()) {
                System.out.println("Created default folder: " + defaultFolder.getAbsolutePath());
            }
        }

        // Load playlist từ folder mặc định
        loadPlaylist(defaultFolder);

        // Nút điều khiển
        JButton btnPlay = new JButton("Play Current");
        JButton btnStop = new JButton("Stop");
        JButton btnNext = new JButton("Next");
        JButton btnChooseFolder = new JButton("Choose Folder");
        lblStatus = new JLabel("Status: Idle");

        add(btnPlay);
        add(btnStop);
        add(btnNext);
        add(btnChooseFolder);
        add(lblStatus);

        // Play current
        btnPlay.addActionListener(e -> {
            if (playlist != null && playlist.length > 0) {
                playSong(playlist[currentIndex]);
            } else {
                lblStatus.setText("No songs in playlist");
            }
        });

        // Stop
        btnStop.addActionListener(e -> stopSong());

        // Next
        btnNext.addActionListener(e -> {
            if (playlist != null && playlist.length > 0) {
                currentIndex = (currentIndex + 1) % playlist.length;
                playSong(playlist[currentIndex]);
            }
        });

        // Choose folder
        btnChooseFolder.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File folder = chooser.getSelectedFile();
                loadPlaylist(folder);
                currentIndex = 0;
                if (playlist.length > 0) {
                    playSong(playlist[currentIndex]);
                } else {
                    lblStatus.setText("No valid audio files in folder");
                }
            }
        });
    }

    // Load tất cả file WAV/AIFF/AU trong folder
    private void loadPlaylist(File folder) {
        File[] files = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".wav") ||
                name.toLowerCase().endsWith(".aiff") ||
                name.toLowerCase().endsWith(".au"));

        if (files != null && files.length > 0) {
            playlist = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                playlist[i] = files[i].getAbsolutePath();
            }
            lblStatus.setText("Loaded " + files.length + " songs from " + folder.getName());
        } else {
            playlist = new String[0];
            lblStatus.setText("No songs found in " + folder.getName());
        }
    }

    private void playSong(String path) {
        stopSong();
        try {
            File file = new File(path);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            lblStatus.setText("Playing: " + file.getName());
        } catch (Exception e) {
            lblStatus.setText("Error playing " + path);
            e.printStackTrace();
        }
    }

    private void stopSong() {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
                lblStatus.setText("Stopped");
            }
        } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicPlayerFolder().setVisible(true);
        });
    }
}
