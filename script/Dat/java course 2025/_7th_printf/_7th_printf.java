public class _7th_printf {
    public static void main(String[] args) {
        int a = 10;
        double b = 5.6789;
        String name = "John";

        // Using printf for formatted output
        System.out.printf("Integer: %d%n", a); // %d for integers
        System.out.printf("Floating-point: %.2f%n", b); // %.2f for floating-point with 2 decimal places
        System.out.printf("String: %s%n", name); // %s for strings
        System.out.printf("Multiple values: Name: %s, Age: %d, Score: %.2f%n", name, a, b);
        
        // Formatting with width and alignment
        System.out.printf("Right aligned: |%10s|%n", name); // Right aligned within 10 spaces
        System.out.printf("Left aligned: |%-10s|%n", name); // Left aligned within 10 spaces
        System.out.printf("Padded number: |%05d|%n", a); // Padded with zeros to width of 5
    }
    
}
