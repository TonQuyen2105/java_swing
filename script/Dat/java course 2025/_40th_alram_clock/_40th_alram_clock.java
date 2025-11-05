import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class _40th_alram_clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath="auughhh.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:mm:ss): ");
                String input = scanner.nextLine();
        
                alarmTime = LocalTime.parse(input, formatter);
                System.out.println("Alarm set for: " + alarmTime.format(formatter));
        
                System.out.println("Current time: " + LocalTime.now().format(formatter));
    
            }
            catch(DateTimeParseException e){
                System.out.println("Invalid time format. Please use HH:mm:ss");
            }
        }
        
        AlramClock alarmClock = new AlramClock(alarmTime, filepath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();



        // scanner.close();
    }
}
