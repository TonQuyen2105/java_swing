public class Friend {
    String name;
    static int count = 0; // static variable to keep track of the number of Friend instances

    // Constructor
    public Friend(String name) {
        this.name = name;
        count++; // Increment the count each time a new Friend is created
    }

    // Static method to get the current count of Friend instances
    public static int getCount() {
        return count;
    }

    static void showFriend() {
        System.out.println("Friend class loaded. Static block executed.");
    }
}
