import java.util.*;

public class _37th_enums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a day: ");

        String response = scanner.nextLine().toUpperCase();

        Day today = Day.valueOf(response);

        System.out.println("Today is: " + today);
        // System.out.println("Day number: " + today.getDayNumber());
        try{

            switch (today) {
                case MONDAY:
                    System.out.println("Start of the work week!, 1st day of the week");
                    break;
                case TUESDAY:
                    System.out.println("2nd day of the week");
                    break;
                case WEDNESDAY:
                    System.out.println("Midweek day, 3rd day of the week");
                    break;
                case THURSDAY:
                    System.out.println("Midweek day, 4th day of the week");
                    break;
                case FRIDAY:
                    System.out.println("Almost the end of the week, 5th day of the week");
                    break;
                case SATURDAY:
                    System.out.println("Weekend day, 6th day of the week");
                    break;
                case SUNDAY:
                    System.out.println("Weekend day, 7th day of the week");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid day, please enter a valid day of the week.");
        }
    }
}
