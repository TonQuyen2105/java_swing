import java.util.Scanner;

public class _2nd_scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, World!");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Your name is: " + name);    
    }
}