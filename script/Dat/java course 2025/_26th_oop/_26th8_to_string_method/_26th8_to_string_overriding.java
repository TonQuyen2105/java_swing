public class _26th8_to_string_overriding {
    public static void main(String[] args) {
        Car4 car = new Car4("BMW", "Red", 200);
        System.out.println(car); // Implicitly calls car.toString()
    }
}
