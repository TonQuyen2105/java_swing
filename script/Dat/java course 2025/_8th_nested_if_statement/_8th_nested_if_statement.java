public class _8th_nested_if_statement {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        if (a > b) {
            if (a > c) {
                System.out.println("a is the greatest");
            } else {
                System.out.println("c is the greatest");
            }
        } else {
            if (b > c) {
                System.out.println("b is the greatest");
            } else {
                System.out.println("c is the greatest");
            }
        }

        boolean isRaining = true;
        boolean hasUmbrella = false;

        if (isRaining) {
            if (hasUmbrella) {
                System.out.println("Take an umbrella");
            } else {
                System.out.println("Get an umbrella");
            }
        } else {
            System.out.println("No need for an umbrella");
        }
    }
}
