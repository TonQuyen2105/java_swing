public class _26th2_overload_constructer_oop {
    User user1 = new User("Alice", 20, "o0V2l@example.com");
    User user2 = new User(25, "o0V2l@example.com");
    User user3 = new User();

    public static void main(String[] args) {
        _26th2_overload_constructer_oop obj = new _26th2_overload_constructer_oop();
        obj.user1.displayInfo();
        System.out.println("-----");
        obj.user2.displayInfo();
        System.out.println("-----");
        obj.user3.displayInfo();
    }
}
