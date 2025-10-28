public class _9th_string_methods {
    public static void main(String[] args) {
        String text = "Welcome to Java programming. This is my first program. 2025";

        int length = text.length();
        System.out.println("Length of the string: " + length);

        char firstChar = text.charAt(0);
        System.out.println("First character: " + firstChar);

        int index = text.indexOf("Java");
        System.out.println("Index of 'Java': " + index);

        int lastIndex = text.lastIndexOf("Java");
        System.out.println("Last index of 'Java': " + lastIndex);

        boolean contains = text.contains("Java");
        System.out.println("Contains 'Java': " + contains);

        char lastChar = text.charAt(length - 1);
        System.out.println("Last character: " + lastChar);

        text = text.toUpperCase();
        System.out.println("Uppercase: " + text);

        text = text.toLowerCase();
        System.out.println("Lowercase: " + text);

        String text1 = "   Hello, World!   ";
        System.out.println("Trimmed: '" + text1.trim() + "'");

        text = text.replace("java", "Python");
        System.out.println("Replaced 'Java' with 'Python': " + text);


        System.out.println(text.isEmpty());
        if (!text.isEmpty()) {
            System.out.println("The string is not empty.");
        } else {
            System.out.println("The string is empty.");
        }
        
        if (text.contains("programming")) {
            System.out.println("The string contains 'programming'.");
        } else {
            System.out.println("The string does not contain 'programming'.");
        }

        if (text.equals(text1)) {
            System.out.println("The strings are equal.");
        } else {
            System.out.println("The strings are not equal.");
        }

        if (text.equalsIgnoreCase(text1)) {
            System.out.println("The strings are equal.");
        } else {
            System.out.println("The strings are not equal.");
        }

        if (text.startsWith("Welcome")) {
            System.out.println("The string starts with 'Welcome'.");
        } else {
            System.out.println("The string does not start with 'Welcome'.");
        }

        if (text.endsWith("2025")) {
            System.out.println("The string ends with '2025'.");
        } else {
            System.out.println("The string does not end with '2025'.");
        }
    }
    
}
