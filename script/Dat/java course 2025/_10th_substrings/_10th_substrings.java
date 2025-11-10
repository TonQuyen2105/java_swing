import java.util.Scanner;

public class _10th_substrings {
    public static void main(String[] args) {
        String str = "Hello, welcome to the world of Java programming!";
        
        // Extracting substrings
        String sub1 = str.substring(0, 5); // "Hello"
        String sub2 = str.substring(7, 14); // "welcome"
        String sub3 = str.substring(15); // "to the world of Java programming!"
        
        System.out.println("Original String: " + str);
        System.out.println("Substring 1: " + sub1);
        System.out.println("Substring 2: " + sub2);
        System.out.println("Substring 3: " + sub3);
        
        // Finding the index of a substring
        int index = str.indexOf("Java");
        System.out.println("Index of 'Java': " + index);
        
        // Checking if a substring exists
        boolean contains = str.contains("world");
        System.out.println("Contains 'world': " + contains);

        String email = "exampleusername@domainname";
        String username = email.substring(0, email.indexOf('@'));
        String localPart = email.substring(email.indexOf('@'));
        String domain = email.substring(email.indexOf('@') + 1);
        System.out.println("Username: " + username);
        System.out.println("Local Part: " + localPart);
        System.out.println("Domain: " + domain);

        String Email;
        String UserName;
        String Domain;

        System.out.print("Enter your email: ");
        Scanner scanner = new Scanner(System.in);

        Email = scanner.nextLine();

        if(Email.contains("@")){
            System.out.println("Valid email format.");
            UserName = Email.substring(0, Email.indexOf('@'));
            Domain = Email.substring(Email.indexOf('@') + 1);
            System.out.println("Username: " + UserName);
            System.out.println("Domain: " + Domain);
        }else{
            System.out.println("Invalid email format. Please include '@' in the email.");
            return;
        }
    }
}
