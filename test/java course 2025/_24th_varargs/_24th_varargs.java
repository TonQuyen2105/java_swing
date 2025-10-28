public class _24th_varargs {

    static void add(int... numbers) {
        System.out.println("Number of arguments: " + numbers);
    }

    static void printNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    static void sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        System.out.println("Sum: " + total);
    }

    static void average(int... numbers) {
        if (numbers.length == 0) {
            System.out.println("No numbers provided.");
            return;
        }
        double total = 0;
        for (int number : numbers) {
            total += number;
        }
        double average = (double) total / numbers.length;
        System.out.println("Average: " + average);
    }

    public static void main(String[] args) {
        // Varargs (variable-length arguments) allow you to pass a variable number of arguments to a method
        // Syntax: methodName(dataType... parameterName)
        add(1, 2, 3, 4, 5);
        printNumbers(1, 2, 3);
        printNumbers(10, 20, 30, 40, 50);
        printNumbers(); // No arguments
        sum(1, 2, 3, 4, 5);
        average(10, 20, 30);
    }
}
