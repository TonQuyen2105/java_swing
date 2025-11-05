// import java.io.File;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.UnsupportedAudioFileException;
// import java.io.IOException;


// public class _31th_music_player {

//     public static void main(String[] args) {

//         File file = new File("music.mp3");

//         try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile())) {
//             Clip clip = AudioSystem.getClip();
//             clip.open(audioInputStream);
//             clip.start();
//         } catch (UnsupportedAudioFileException e) {
//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
       
//     }
    
// }

// import javax.sound.sampled.*;
// import javax.swing.*;
// import java.awt.*;
// import java.io.File;

// public class MusicPlayerFolder extends JFrame {
//     private Clip clip;
//     private String[] playlist;
//     private int currentIndex = 0;
//     private JLabel lblStatus;

//     private final File defaultFolder = new File("music"); // thư mục mặc định

//     public MusicPlayerFolder() {
//         super("Music Player (WAV only)");
//         setSize(500, 200);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new FlowLayout());

//         lblStatus = new JLabel("Status: Idle"); // ✅ tạo trước

//         // kiểm tra và tạo folder mặc định
//         if (!defaultFolder.exists()) {
//             if (defaultFolder.mkdirs()) {
//                 System.out.println("Created default folder: " + defaultFolder.getAbsolutePath());
//             }
//         }

//         // load playlist
//         loadPlaylist(defaultFolder);


//         JButton btnPlay = new JButton("Play Current");
//         JButton btnStop = new JButton("Stop");
//         JButton btnNext = new JButton("Next");
//         JButton btnChooseFolder = new JButton("Choose Folder");

//         add(btnPlay);
//         add(btnStop);
//         add(btnNext);
//         add(btnChooseFolder);
//         add(lblStatus); // ✅ add vào frame sau khi đã tạo

//         // Play current
//         btnPlay.addActionListener(e -> {
//             if (playlist != null && playlist.length > 0) {
//                 playSong(playlist[currentIndex]);
//             } else {
//                 lblStatus.setText("No songs in playlist");
//             }
//         });

//         // Stop
//         btnStop.addActionListener(e -> stopSong());

//         // Next
//         btnNext.addActionListener(e -> {
//             if (playlist != null && playlist.length > 0) {
//                 currentIndex = (currentIndex + 1) % playlist.length;
//                 playSong(playlist[currentIndex]);
//             }
//         });

//         // Choose folder
//         btnChooseFolder.addActionListener(e -> {
//             JFileChooser chooser = new JFileChooser();
//             chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//             int result = chooser.showOpenDialog(this);
//             if (result == JFileChooser.APPROVE_OPTION) {
//                 File folder = chooser.getSelectedFile();
//                 loadPlaylist(folder);
//                 currentIndex = 0;
//                 if (playlist.length > 0) {
//                     playSong(playlist[currentIndex]);
//                 } else {
//                     lblStatus.setText("No valid audio files in folder");
//                 }
//             }
//         });
//     }

//     // Load tất cả file WAV/AIFF/AU trong folder
//     private void loadPlaylist(File folder) {
//         File[] files = folder.listFiles((dir, name) ->
//                 name.toLowerCase().endsWith(".wav") ||
//                 name.toLowerCase().endsWith(".aiff") ||
//                 name.toLowerCase().endsWith(".au"));

//         if (files != null && files.length > 0) {
//             playlist = new String[files.length];
//             for (int i = 0; i < files.length; i++) {
//                 playlist[i] = files[i].getAbsolutePath();
//             }
//             lblStatus.setText("Loaded " + files.length + " songs from " + folder.getName());
//         } else {
//             playlist = new String[0];
//             lblStatus.setText("No songs found in " + folder.getName());
//         }
//     }

//     private void playSong(String path) {
//         stopSong();
//         try {
//             File file = new File(path);
//             AudioInputStream ais = AudioSystem.getAudioInputStream(file);
//             clip = AudioSystem.getClip();
//             clip.open(ais);
//             clip.start();
//             lblStatus.setText("Playing: " + file.getName());
//         } catch (Exception e) {
//             lblStatus.setText("Error playing " + path);
//             e.printStackTrace();
//         }
//     }

//     private void stopSong() {
//         try {
//             if (clip != null && clip.isRunning()) {
//                 clip.stop();
//                 clip.close();
//                 lblStatus.setText("Stopped");
//             }
//         } catch (Exception ignored) {}
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new MusicPlayerFolder().setVisible(true);
//         });
//     }
// }


// import javax.swing.*;
// import javax.sound.sampled.*;
// import java.awt.*;
// import java.io.File;
// import java.io.IOException;
// import java.nio.file.*;
// import java.util.ArrayList;
// import java.util.List;

// public class MusicPlayerAutoUpdate extends JFrame {
//     private JLabel lblStatus;
//     private JButton btnPlay, btnNext, btnPrev, btnStop;
//     private List<File> playlist = new ArrayList<>();
//     private int currentIndex = 0;
//     private Clip clip;
//     private AudioInputStream audioStream; // keep reference
//     private File musicFolder;

//     public MusicPlayerAutoUpdate() {
//         setTitle("Music Player Auto Update");
//         setSize(450, 200);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         lblStatus = new JLabel("No music loaded");
//         add(lblStatus, BorderLayout.NORTH);

//         JPanel panel = new JPanel();
//         btnPrev = new JButton("Previous");
//         btnPlay = new JButton("Play/Pause");
//         btnStop = new JButton("Stop");
//         btnNext = new JButton("Next");

//         panel.add(btnPrev);
//         panel.add(btnPlay);
//         panel.add(btnStop);
//         panel.add(btnNext);
//         add(panel, BorderLayout.CENTER);

//         // Default folder
//         musicFolder = new File("music");
//         if (!musicFolder.exists()) {
//             musicFolder.mkdirs();
//             System.out.println("Created default folder: " + musicFolder.getAbsolutePath());
//         }

//         loadPlaylist();

//         // Button actions
//         btnPlay.addActionListener(e -> togglePlayPause());
//         btnStop.addActionListener(e -> stopTrack());
//         btnNext.addActionListener(e -> nextTrack());
//         btnPrev.addActionListener(e -> prevTrack());

//         // Watch folder
//         new Thread(this::watchFolder).start();
//     }

//     private void loadPlaylist() {
//         playlist.clear();
//         File[] files = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));
//         if (files != null) {
//             for (File f : files) playlist.add(f);
//         }
//         if (playlist.isEmpty()) {
//             lblStatus.setText("Folder is empty, add some .wav files");
//         } else {
//             lblStatus.setText("Loaded " + playlist.size() + " tracks");
//         }
//     }

//     private void togglePlayPause() {
//         if (playlist.isEmpty()) return;

//         try {
//             if (clip != null && clip.isRunning()) {
//                 clip.stop();
//                 lblStatus.setText("Paused: " + playlist.get(currentIndex).getName());
//             } else if (clip != null && !clip.isRunning()) {
//                 clip.start();
//                 lblStatus.setText("Playing: " + playlist.get(currentIndex).getName());
//             } else {
//                 playCurrent();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void playCurrent() {
//         try {
//             stopTrack(); // close old resources first
//             File file = playlist.get(currentIndex);
//             audioStream = AudioSystem.getAudioInputStream(file);
//             clip = AudioSystem.getClip();
//             clip.open(audioStream);
//             clip.start();
//             lblStatus.setText("Playing: " + file.getName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void stopTrack() {
//         try {
//             if (clip != null) {
//                 clip.stop();
//                 clip.close();
//                 clip = null;
//             }
//             if (audioStream != null) {
//                 audioStream.close(); // release file handle
//                 audioStream = null;
//             }
//             lblStatus.setText("Stopped");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void nextTrack() {
//         if (playlist.isEmpty()) return;
//         currentIndex = (currentIndex + 1) % playlist.size();
//         playCurrent();
//     }

//     private void prevTrack() {
//         if (playlist.isEmpty()) return;
//         currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
//         playCurrent();
//     }

//     private void watchFolder() {
//         try {
//             WatchService watchService = FileSystems.getDefault().newWatchService();
//             Path path = musicFolder.toPath();
//             path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

//             while (true) {
//                 WatchKey key = watchService.take();
//                 for (WatchEvent<?> event : key.pollEvents()) {
//                     SwingUtilities.invokeLater(this::loadPlaylist);
//                 }
//                 key.reset();
//             }
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MusicPlayerAutoUpdate().setVisible(true));
//     }
// }

// import javax.swing.*;
// import javax.sound.sampled.*;
// import java.awt.*;
// import java.io.File;
// import java.io.IOException;
// import java.nio.file.*;
// import java.util.ArrayList;
// import java.util.List;

// public class MusicPlayerAutoUpdate extends JFrame {
//     private JLabel lblStatus;
//     private JButton btnPlay, btnNext, btnPrev, btnStop, btnShuffle, btnRepeat;
//     private List<File> playlist = new ArrayList<>();
//     private int currentIndex = 0;
//     private Clip clip;
//     private AudioInputStream audioStream;
//     private File musicFolder;
//     private boolean shuffle = false, repeat = false;

//     public MusicPlayerAutoUpdate() {
//         setTitle("Music Player Auto Update");
//         setSize(500, 250);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         lblStatus = new JLabel("No music loaded");
//         add(lblStatus, BorderLayout.NORTH);

//         JPanel panel = new JPanel();
//         btnPrev = new JButton("Previous");
//         btnPlay = new JButton("Play/Pause");
//         btnStop = new JButton("Stop");
//         btnNext = new JButton("Next");
//         btnShuffle = new JButton("Shuffle: OFF");
//         btnRepeat = new JButton("Repeat: OFF");

//         panel.add(btnPrev);
//         panel.add(btnPlay);
//         panel.add(btnStop);
//         panel.add(btnNext);
//         panel.add(btnShuffle);
//         panel.add(btnRepeat);
//         add(panel, BorderLayout.CENTER);

//         // Default folder
//         musicFolder = new File("music");
//         if (!musicFolder.exists()) {
//             musicFolder.mkdirs();
//             System.out.println("Created default folder: " + musicFolder.getAbsolutePath());
//         }

//         loadPlaylist();

//         // Button actions
//         btnPlay.addActionListener(e -> togglePlayPause());
//         btnStop.addActionListener(e -> stopTrack());
//         btnNext.addActionListener(e -> nextTrack());
//         btnPrev.addActionListener(e -> prevTrack());

//         btnShuffle.addActionListener(e -> {
//             shuffle = !shuffle;
//             btnShuffle.setText("Shuffle: " + (shuffle ? "ON" : "OFF"));
//         });

//         btnRepeat.addActionListener(e -> {
//             repeat = !repeat;
//             btnRepeat.setText("Repeat: " + (repeat ? "ON" : "OFF"));
//         });

//         // Watch folder
//         new Thread(this::watchFolder).start();

//         // Drag & drop
//         new FileDrop(this, files -> {
//             for (File file : files) {
//                 if (file.getName().toLowerCase().endsWith(".wav")) {
//                     try {
//                         Path target = musicFolder.toPath().resolve(file.getName());
//                         Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
//                         System.out.println("Added via drag & drop: " + file.getName());
//                     } catch (IOException ex) {
//                         ex.printStackTrace();
//                     }
//                 }
//             }
//             SwingUtilities.invokeLater(this::loadPlaylist);
//         });
//     }

//     private void loadPlaylist() {
//         playlist.clear();
//         File[] files = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));
//         if (files != null) {
//             for (File f : files) playlist.add(f);
//         }
//         if (playlist.isEmpty()) {
//             lblStatus.setText("Folder is empty, add some .wav files");
//         } else {
//             lblStatus.setText("Loaded " + playlist.size() + " tracks");
//         }
//     }

//     private void togglePlayPause() {
//         if (playlist.isEmpty()) return;

//         try {
//             if (clip != null && clip.isRunning()) {
//                 clip.stop();
//                 lblStatus.setText("Paused: " + playlist.get(currentIndex).getName());
//             } else if (clip != null && !clip.isRunning()) {
//                 clip.start();
//                 lblStatus.setText("Playing: " + playlist.get(currentIndex).getName());
//             } else {
//                 playCurrent();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void playCurrent() {
//         try {
//             stopTrack();
//             File file = playlist.get(currentIndex);
//             audioStream = AudioSystem.getAudioInputStream(file);
//             clip = AudioSystem.getClip();
//             clip.open(audioStream);
//             clip.start();
//             lblStatus.setText("Playing: " + file.getName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void stopTrack() {
//         try {
//             if (clip != null) {
//                 clip.stop();
//                 clip.close();
//                 clip = null;
//             }
//             if (audioStream != null) {
//                 audioStream.close();
//                 audioStream = null;
//             }
//             lblStatus.setText("Stopped");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void nextTrack() {
//         if (playlist.isEmpty()) return;

//         if (repeat) {
//             playCurrent();
//         } else if (shuffle) {
//             currentIndex = (int) (Math.random() * playlist.size());
//             playCurrent();
//         } else {
//             currentIndex = (currentIndex + 1) % playlist.size();
//             playCurrent();
//         }
//     }

//     private void prevTrack() {
//         if (playlist.isEmpty()) return;
//         currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
//         playCurrent();
//     }

//     private void watchFolder() {
//         try {
//             WatchService watchService = FileSystems.getDefault().newWatchService();
//             Path path = musicFolder.toPath();
//             path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

//             while (true) {
//                 WatchKey key = watchService.take();
//                 for (WatchEvent<?> event : key.pollEvents()) {
//                     SwingUtilities.invokeLater(this::loadPlaylist);
//                 }
//                 key.reset();
//             }
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MusicPlayerAutoUpdate().setVisible(true));
//     }
// }


import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class MusicPlayerAutoUpdate extends JFrame {
    private JLabel lblStatus;
    private JButton btnPlay, btnNext, btnPrev, btnStop, btnShuffle, btnRepeat, btnCrossfade;
    private JSlider crossfadeSlider;
    private List<File> playlist = new ArrayList<>();
    private int currentIndex = 0;
    private Clip clip;
    private AudioInputStream audioStream;
    private File musicFolder;

    // Features
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    private boolean isCrossfade = false;
    private int crossfadeDuration = 5; // seconds
    private final Random random = new Random();

    public MusicPlayerAutoUpdate() {
        setTitle("Music Player Auto Update");
        setSize(600, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lblStatus = new JLabel("No music loaded");
        add(lblStatus, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        btnPrev = new JButton("Previous");
        btnPlay = new JButton("Play/Pause");
        btnStop = new JButton("Stop");
        btnNext = new JButton("Next");
        btnShuffle = new JButton("Shuffle: OFF");
        btnRepeat = new JButton("Repeat: OFF");
        btnCrossfade = new JButton("Crossfade: OFF");
        crossfadeSlider = new JSlider(0, 12, crossfadeDuration);

        panel.add(btnPrev);
        panel.add(btnPlay);
        panel.add(btnStop);
        panel.add(btnNext);
        panel.add(btnShuffle);
        panel.add(btnRepeat);
        panel.add(btnCrossfade);
        panel.add(new JLabel("Crossfade (s):"));
        panel.add(crossfadeSlider);

        add(panel, BorderLayout.CENTER);

        // Default folder
        musicFolder = new File("music");
        if (!musicFolder.exists()) {
            musicFolder.mkdirs();
            System.out.println("Created default folder: " + musicFolder.getAbsolutePath());
        }

        loadPlaylist();

        // Button actions
        btnPlay.addActionListener(e -> togglePlayPause());
        btnStop.addActionListener(e -> stopTrack());
        btnNext.addActionListener(e -> nextTrack());
        btnPrev.addActionListener(e -> prevTrack());
        btnShuffle.addActionListener(e -> toggleShuffle());
        btnRepeat.addActionListener(e -> toggleRepeat());
        btnCrossfade.addActionListener(e -> toggleCrossfade());
        crossfadeSlider.addChangeListener(e -> crossfadeDuration = crossfadeSlider.getValue());

        // Watch folder for changes
        new Thread(this::watchFolder).start();
    }

    private void loadPlaylist() {
        playlist.clear();
        File[] files = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));
        if (files != null) {
            for (File f : files) playlist.add(f);
        }
        if (playlist.isEmpty()) {
            lblStatus.setText("Folder is empty, add some .wav files");
        } else {
            lblStatus.setText("Loaded " + playlist.size() + " tracks");
        }
    }

    private void togglePlayPause() {
        if (playlist.isEmpty()) return;
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                lblStatus.setText("Paused: " + playlist.get(currentIndex).getName());
            } else if (clip != null && !clip.isRunning()) {
                clip.start();
                lblStatus.setText("Playing: " + playlist.get(currentIndex).getName());
            } else {
                playCurrent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playCurrent() {
        try {
            stopTrack();
            File file = playlist.get(currentIndex);
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            lblStatus.setText("Playing: " + file.getName());

            if (isCrossfade) {
                scheduleAutoCrossfade(clip);
            }

            // Fallback nếu không bật crossfade
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP && !clip.isRunning()) {
                    if (!isCrossfade) {
                        if (isRepeat) {
                            playCurrent();
                        } else {
                            nextTrack();
                        }
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopTrack() {
        try {
            if (clip != null) {
                clip.stop();
                clip.close();
                clip = null;
            }
            if (audioStream != null) {
                audioStream.close();
                audioStream = null;
            }
            lblStatus.setText("Stopped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nextTrack() {
        if (playlist.isEmpty()) return;
        if (isShuffle) {
            currentIndex = random.nextInt(playlist.size());
        } else {
            currentIndex = (currentIndex + 1) % playlist.size();
        }
        playCurrent();
    }

    private void prevTrack() {
        if (playlist.isEmpty()) return;
        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        playCurrent();
    }

    private void toggleShuffle() {
        isShuffle = !isShuffle;
        btnShuffle.setText("Shuffle: " + (isShuffle ? "ON" : "OFF"));
    }

    private void toggleRepeat() {
        isRepeat = !isRepeat;
        btnRepeat.setText("Repeat: " + (isRepeat ? "ON" : "OFF"));
    }

    private void toggleCrossfade() {
        isCrossfade = !isCrossfade;
        btnCrossfade.setText("Crossfade: " + (isCrossfade ? "ON" : "OFF"));
    }

    private void scheduleAutoCrossfade(Clip currentClip) {
        new Thread(() -> {
            try {
                long totalMicro = currentClip.getMicrosecondLength();
                long fadeStart = totalMicro - (crossfadeDuration * 1_000_000L);

                while (currentClip.getMicrosecondPosition() < fadeStart && currentClip.isRunning()) {
                    Thread.sleep(200);
                }

                if (!currentClip.isRunning()) return;

                // Get next track
                int nextIndex = isShuffle ? random.nextInt(playlist.size())
                                          : (currentIndex + 1) % playlist.size();
                if (isRepeat) nextIndex = currentIndex;

                File nextFile = playlist.get(nextIndex);
                AudioInputStream nextStream = AudioSystem.getAudioInputStream(nextFile);
                Clip nextClip = AudioSystem.getClip();
                nextClip.open(nextStream);

                FloatControl currentVol = (FloatControl) currentClip.getControl(FloatControl.Type.MASTER_GAIN);
                FloatControl nextVol = (FloatControl) nextClip.getControl(FloatControl.Type.MASTER_GAIN);

                float min = currentVol.getMinimum();
                float max = currentVol.getMaximum();
                nextVol.setValue(min);

                nextClip.start();

                int steps = crossfadeDuration * 10;
                float stepCurrent = (currentVol.getValue() - min) / steps;
                float stepNext = (max - min) / steps;

                for (int i = 0; i < steps; i++) {
                    if (!currentClip.isRunning()) break;
                    currentVol.setValue(currentVol.getValue() - stepCurrent);
                    nextVol.setValue(min + stepNext * i);
                    Thread.sleep(100);
                }

                currentClip.stop();
                currentClip.close();
                audioStream.close();

                currentIndex = nextIndex;
                clip = nextClip;
                audioStream = nextStream;
                lblStatus.setText("Playing: " + nextFile.getName());

                scheduleAutoCrossfade(clip);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void watchFolder() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = musicFolder.toPath();
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    SwingUtilities.invokeLater(this::loadPlaylist);
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicPlayerAutoUpdate().setVisible(true));
    }
}
