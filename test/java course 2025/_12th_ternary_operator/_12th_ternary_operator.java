public class _12th_ternary_operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Using if-else
        String result;
        if (a > b) {
            result = "a is greater than b";
        } else {
            result = "a is less than or equal to b";
        }
        System.out.println(result);

        // Using ternary operator
        String ternaryResult = (a > b) ? "a is greater than b" : "a is less than or equal to b";
        System.out.println(ternaryResult);

        // Another example
        int max = (a > b) ? a : b;
        System.out.println("The maximum value is: " + max);
    }
}
