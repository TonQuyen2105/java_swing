public class _14th_logical_operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // Logical AND (&&)
        if (a < b && b < c) {
            System.out.println("a is less than b AND b is less than c");
        }

        // Logical OR (||)
        if (a > b || b < c) {
            System.out.println("a is greater than b OR b is less than c");
        }

        // Logical NOT (!)
        if (!(a > b)) {
            System.out.println("a is NOT greater than b");
        }

        // Combining logical operators
        if ((a < b && b < c) || (a == 10)) {
            System.out.println("Complex condition met");
        }
    }
}
