
public class _4th_arithmetic {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Arithmetic Operators
        System.out.println("a + b = " + (a + b)); // Addition
        System.out.println("a - b = " + (a - b)); // Subtraction
        System.out.println("a * b = " + (a * b)); // Multiplication
        System.out.println("b / a = " + (b / a)); // Division
        System.out.println("b % a = " + (b % a)); // Modulus

        // Increment and Decrement Operators
        System.out.println("a before increment: " + a);
        System.out.println("a after increment: " + (++a)); // Pre-increment
        System.out.println("a after decrement: " + (--a)); // Pre-decrement
        System.out.println("b before decrement: " + b);
        System.out.println("b after decrement: " + (--b)); // Pre-decrement
        System.out.println("b after increment: " + (++b)); // Pre-increment
        System.out.println("a++ = " + (a++)); // Post-increment
        System.out.println("a after a++: " + a);
        System.out.println("b-- = " + (b--)); // Post-decrement
        System.out.println("b after b--: " + b);

        // Assignment Operators
        System.out.println("a += b == a = a + b ==> " + (a += b)); // a = a + b
        System.out.println("a -= b == a = a - b ==> " + (a -= b)); // a = a - b
        System.out.println("a *= b == a = a * b ==> " + (a *= b)); // a = a * b
        System.out.println("a /= b == a = a / b ==> " + (a /= b)); // a = a / b
        System.out.println("a %= b == a = a % b ==> " + (a %= b)); // a = a % b

        double x = 5.5;
        double y = 2.0;

        System.out.println("x + y = " + (x + y)); // Addition
        System.out.println("x - y = " + (x - y)); // Subtraction
        System.out.println("x * y = " + (x * y)); // Multiplication
        System.out.println("x / y = " + (x / y)); // Division
    }
}