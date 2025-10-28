import java.util.ArrayList;
import java.util.Collections;

public class _30th_arraylists {
    public static void main(String[] args) {
        System.out.println("ArrayLists in Java");
        // ArrayList is a part of Java's collection framework
        // It is used to store dynamically sized collection of elements
        // Unlike arrays, ArrayLists can grow and shrink in size as needed
        // To use ArrayList, we need to import it from java.util package
        // Syntax to declare an ArrayList: ArrayList<dataType> name = new ArrayList<>();
        // Example:
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10); // Adding elements
        numbers.add(20);
        numbers.add(30);
        System.out.println("ArrayList: " + numbers);
        // Accessing elements
        System.out.println("First element: " + numbers.get(0));
        System.out.println("Second element: " + numbers.get(1));
        System.out.println("Third element: " + numbers.get(2));

        // Modifying elements
        numbers.set(1, 25); // Changing second element to 25
        System.out.println("Modified ArrayList: " + numbers);
        // Removing elements
        numbers.remove(0); // Removing first element
        System.out.println("ArrayList after removing first element: " + numbers);
        // Size of the ArrayList
        System.out.println("Size of ArrayList: " + numbers.size());
        // Looping through ArrayList
        System.out.println("Elements in ArrayList:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        Collections.sort(numbers); // Sorting the ArrayList
        System.out.println("Sorted ArrayList: " + numbers);

        // Checking if an element exists
        System.out.println("Does ArrayList contain 25? " + numbers.contains(25));


    }
}
