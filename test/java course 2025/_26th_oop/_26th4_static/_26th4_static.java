public class _26th4_static {
    public static void main(String[] args) {
        Friend f1 = new Friend("Alice");
        Friend f2 = new Friend("Bob");
        Friend f3 = new Friend("Charlie");

        System.out.println("Friend 1: " + f1.name);
        System.out.println("Friend 2: " + f2.name);
        System.out.println("Friend 3: " + f3.name);

        // Accessing the static field directly
        System.out.println("Total Friends created: " + Friend.count);

        // Accessing the static method to get the count of Friend instances
        System.out.println("Total Friends created: " + Friend.getCount());

        Friend.showFriend(); // Calling the static method to demonstrate static block execution

        Math.round(0.6); // Using a static method from the Math class
        System.out.println(Math.round(0.6)); // Accessing a static field from the Math class
    }
}
