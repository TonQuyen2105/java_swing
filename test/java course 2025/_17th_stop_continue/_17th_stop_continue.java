public class _17th_stop_continue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Skipping number 5");
                continue; // Skip the rest of the loop when i is 5
            }
            if (i == 8) {
                System.out.println("Stopping at number 8");
                break; // Exit the loop when i is 8
            }
            System.out.println("Count is: " + i);
        }
    }
}
