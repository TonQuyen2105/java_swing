// import java.time.LocalTime;
// import java.awt.Toolkit;
// import java.io.File;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;
// import javax.sound.sampled.LineUnavailableException;
// import javax.sound.sampled.UnsupportedAudioFileException;
// import java.io.IOException;
// import java.util.Scanner;

// public class AlramClock implements Runnable {

//     private final LocalTime alarmTime;
//     private final String filepath;
//     private Scanner scanner;

//     AlramClock(LocalTime alarmTime, String filepath, Scanner scanner) {
//         this.alarmTime = alarmTime;
//         this.filepath = filepath;
//         this.scanner = scanner;
//     }

//     @Override
//     public void run() {
//         // LocalTime now = LocalTime.now();
//         // System.out.println("Alarm thread started, waiting for alarm time: " + alarmTime);
//         while (LocalTime.now().isBefore(alarmTime)) {
//             try {
//                 Thread.sleep(1000); // Sleep for 1 second

//                 LocalTime now = LocalTime.now();

//                 // int hour = LocalTime.now().getHour();
//                 // int minute = LocalTime.now().getMinute();
//                 // int second = LocalTime.now().getSecond();
//                 // System.out.println("Alarm ringing at: " + hour + ":" + minute + ":" + second);
//                 System.out.printf("\rAlarm ringing at: %02d:%02d:%02d", 
//                 now.getHour(), 
//                 now.getMinute(), 
//                 now.getSecond());
//                 // System.out.println("Current time: " + LocalTime.now());
//             } 
//             catch (InterruptedException e) {
//                 System.out.println("Alarm was interrupted.");
//                 return;
//             }
//             // now = LocalTime.now();
//             // System.out.println("Current time: " + now);
//         }
//         System.out.println("\nAlarm noise");
//         Toolkit.getDefaultToolkit().beep();
//         playSound(filepath, scanner);
//         // try {
//         //     Thread.sleep(5000);
//         //     System.out.println("Alarm ringing at: " + alarmTime);
//         // } 
//         // catch (InterruptedException e) {
//         //     System.out.println("Alarm was interrupted.");
//         //     return;
//         // }
//     }

//     // private void playSound(String filepath) {
//     //     // Implement sound playing logic here
//     //     File audioFile = new File(filepath);
//     //     try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
//     //         System.out.println("Playing sound from: " + filepath);
//     //         Clip clip = AudioSystem.getClip();
//     //         clip.open(audioStream);
//     //         clip.start();
//     //         // Thread.sleep(clip.getMicrosecondLength() / 1000); // Short delay to ensure the clip starts playing
//     //         System.out.println("Press Enter to stop the alarm...");
//     //         scanner.nextLine(); // Wait for user to press Enter
//     //         clip.stop();
//     //         clip.close();
//     //         if (clip.getMicrosecondLength() / 1000 > 0) {
//     //             System.out.println("Sound finished playing.");
//     //             return;
//     //         }
//     //         System.out.println("Alarm stopped.");
//     //     } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//     //         System.err.println("Error playing sound: " + e.getMessage());
//     //     }
//     // }
//     private void playSound(String filepath, Scanner scanner) {
//     File audioFile = new File(filepath);
//     try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
//         System.out.println("Playing sound from: " + filepath);
//         Clip clip = AudioSystem.getClip();
//         clip.open(audioStream);
//         clip.start();

//         System.out.println("Press Enter to stop the alarm...");
//         scanner.nextLine(); // Wait for user to press Enter
//         clip.stop();
//         clip.close();
//         System.out.println("Alarm stopped.");

//     } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//         System.err.println("Error playing sound: " + e.getMessage());
//     }
// }

// }


import java.time.LocalTime;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Scanner;

public class AlramClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filepath;
    private final Scanner scanner;

    AlramClock(LocalTime alarmTime, String filepath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filepath = filepath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\rAlarm waiting... current time: %02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Alarm was interrupted.");
                return;
            }
        }
        System.out.println("\n Alarm time reached!");
        Toolkit.getDefaultToolkit().beep();
        playSound(filepath, scanner);
    }

    private void playSound(String filepath, Scanner scanner) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            final int maxPlays = 3;
            final int[] playCount = {0};

            // Listener để phát lại hoặc thoát khi đủ 3 lần
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    playCount[0]++;
                    if (playCount[0] >= maxPlays) {
                        System.out.println("Audio finished 3 times. Exiting...");
                        System.exit(0);
                    } else {
                        clip.setFramePosition(0);
                        clip.start();
                    }
                }
            });

            System.out.println("Playing sound from: " + filepath);
            clip.start();

            new Thread(() -> {
                System.out.println("Press Enter to stop the alarm...");
                scanner.nextLine();
                clip.stop();
                clip.close();
                System.out.println("Alarm stopped by user. Exiting...");
                System.exit(0);
            }).start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}
