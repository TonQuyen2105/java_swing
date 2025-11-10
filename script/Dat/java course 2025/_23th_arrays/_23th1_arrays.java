import java.util.Random;
import java.util.Scanner;

public class _23th1_arrays {
    public static void main(String[] args) {
        Random ran = new Random();
        // Arrays are used to store multiple values in a single variable
        int[] numbers = {1, 2, 3, 4, 5};
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // Accessing array elements
        System.out.println("Random number: " + numbers[ran.nextInt(0,numbers.length)]);
        System.out.println("Random fruit: " + fruits[ran.nextInt(0,fruits.length)]);

        // Looping through an array
        System.out.println("All numbers:");
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("All fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Array input and output
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numbers:");
        int[] userNumbers;
        System.out.print("How many numbers do you want to enter? ");
        int size = sc.nextInt();
        sc.nextLine();
        userNumbers = new int[size];
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            userNumbers[i] = sc.nextInt();
        }
        System.out.println("You entered:");
        for (int number : userNumbers) {
            System.out.println(number);
        }



    }
}
