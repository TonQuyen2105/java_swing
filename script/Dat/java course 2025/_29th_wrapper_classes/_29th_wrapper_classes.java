public class _29th_wrapper_classes {
    public static void main(String[] args) {
        int a = 5; //auto boxing
        Integer b = new Integer(5); //manual boxing
        System.out.println(a == b);

        //unboxing
        int c = b; //auto unboxing
        int d = b.intValue(); //manual unboxing

        String s = Integer.toString(5);
        String s2 = b.toString();
        System.out.println(s + " " + s2);

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println("Max: " + max + " Min: " + min);

        int parsed = Integer.parseInt("123");
        System.out.println("Parsed: " + parsed);

        char ch = 'a';
        System.out.println(Character.isDigit(ch));
        System.out.println(Character.isLetter(ch));
        System.out.println(Character.toUpperCase(ch));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toString('a'));
    }
    
}
