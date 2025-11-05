public class _21th_variable_scope {
    static int b = 10; // Class variable (static variable)
    public static void main(String[] args) {
        int a = 11; // Local variable
        int b = 23; // Local variable
        System.out.println("Value of a: " + a); // Output: 11
        System.out.println("Value of b: " + b); // Output: 23
        someMethod();
        System.out.println("Value of class variable b: " + _21th_variable_scope.b); // Output: 10
    }

    public static void someMethod() {
        // System.out.println(a); // Error: a cannot be resolved to a variable
        int a = 27; // Local variable
        int b = 20; // Local variable
        System.out.println("Value of a: " + a); // Output: 27
        System.out.println("Value of b: " + b); // Output: 20
    }
}
