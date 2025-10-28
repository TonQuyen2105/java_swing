import java.util.Random;


public class _5th_if_statement {


    public static void main(String[] args) {

        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);

        if (a > b) {
            System.out.println("a is greater than b");
        } else if (a < b) {
            System.out.println("a is less than b");
        } else {
            System.out.println("a is equal to b");
        }
    }


}