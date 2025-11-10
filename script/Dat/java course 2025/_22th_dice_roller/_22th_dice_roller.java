import java.util.Random;
import java.util.Scanner;

public class _22th_dice_roller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int diceRoll = ran.nextInt(6) + 1; // Roll the dice (1-6)
        System.out.println("You rolled a " + diceRoll);
        int total;
        int numberOfDice = 2; // Number of dice to roll
        System.out.println("Enter the # of sides on the dice:");
        numberOfDice = sc.nextInt();

        if (numberOfDice < 1) {
            System.out.println("Invalid number of sides. Please enter a positive integer.");
        } else {
            total = 0;
            for (int i = 0; i < numberOfDice; i++) {
                int roll = ran.nextInt(1,7); // Roll the dice
                total += roll;
                System.out.println("Roll " + (i + 1) + ": " + roll);
                printDice(roll);
            }
            System.out.println("Total of rolls: " + total);
        }
    }
    static void printDice(int roll) {
        switch (roll) {
            case 1:
                System.out.println("-----");
                System.out.println("|   |");
                System.out.println("| o |");
                System.out.println("|   |");
                System.out.println("-----");
                break;
            case 2:
                System.out.println("-----");
                System.out.println("|o  |");
                System.out.println("|   |");
                System.out.println("|  o|");
                System.out.println("-----");
                break;
            case 3:
                System.out.println("-----");
                System.out.println("|o  |");
                System.out.println("| o |");
                System.out.println("|  o|");
                System.out.println("-----");
                break;
            case 4:
                System.out.println("-----");
                System.out.println("|o o|");
                System.out.println("|   |");
                System.out.println("|o o|");
                System.out.println("-----");
                break;
            case 5:
                System.out.println("-----");
                System.out.println("|o o|");
                System.out.println("| o |");
                System.out.println("|o o|");
                System.out.println("-----");
                break;
            case 6:
                System.out.println("-----");
                System.out.println("|o o|");
                System.out.println("|o o|");
                System.out.println("|o o|");
                System.out.println("-----");
                break;
            default:
                System.out.println("Invalid roll.");
        }
    }
}
