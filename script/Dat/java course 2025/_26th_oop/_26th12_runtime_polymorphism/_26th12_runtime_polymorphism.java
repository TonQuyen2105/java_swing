import java.util.Scanner;

public class _26th12_runtime_polymorphism {
    public static void main(String[] args) {
        Animal1 animal1;

        Scanner sca = new Scanner(System.in);

        System.out.println("Enter 1 for Cat or 2 for Dog: ");
        int choice = sca.nextInt();



        if (choice == 1) {
            animal1 = new Cat1();
            animal1.makeSound();
        } else if (choice == 2) {
            animal1 = new Dog1();
            animal1.makeSound();
        }
    }
}
