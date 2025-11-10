import java.util.HashMap;
import java.util.Scanner;
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();

        phoneBook.put("An", "0901");
        phoneBook.put("Bình", "0932");
        phoneBook.put("Cao", "0987");

        System.out.println("Số của An: " + phoneBook.get("An"));

        for (String name : phoneBook.keySet()) {
            System.out.println(name + " → " + phoneBook.get(name));
        }

        phoneBook.remove("Bình");
    }
}
