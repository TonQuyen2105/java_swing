public class _18th_nested_loops {
    public static void main(String[] args) {
        // Nested loops are loops inside loops
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration: " + i);
            for (int j = 1; j <= 2; j++) {
                System.out.println("  Inner loop iteration: " + j);
            }
        }
    }
}
