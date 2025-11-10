import java.util.Scanner;

public class _38th_threading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello from the main thread!");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true); // Set the thread as a daemon thread
        thread.start();
        // System.out.println("Main thread is still running...");
        System.out.println("You have 5 seconds to type something.");
        System.out.print("Type something and press Enter: ");
        String userInput = scanner.nextLine();
        System.out.println("You typed: " + userInput);
        scanner.close();
    }
}
