import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class _32th_dates_times {
    public static void main(String[] args) {
        // Get the current instant
        Instant start = Instant.now();
        System.out.println("Start time: " + start);

        // Pause for a moment to see the difference in time
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the current time
        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);
        // Get the current date 
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);

        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println("Formatted date: " + formattedDate);

        // Create a specific date and time
        LocalDateTime specificDate = LocalDateTime.of(2023, Month.DECEMBER, 25, 10, 30);
        System.out.println("Specific date and time: " + specificDate);

        LocalDateTime specificDate2 = LocalDateTime.of(2024, Month.DECEMBER, 25, 10, 30);
        System.out.println("Specific date and time 2: " + specificDate2);

        if (specificDate2.isAfter(specificDate)) {
            System.out.println(specificDate2 + " is after " + specificDate);
        } else {
            System.out.println(specificDate2 + " is not after " + specificDate);
        }
        if (specificDate2.isBefore(specificDate)) {
            System.out.println(specificDate2 + " is before " + specificDate);
        } else {
            System.out.println(specificDate2 + " is not before " + specificDate);
        }
    }
}
