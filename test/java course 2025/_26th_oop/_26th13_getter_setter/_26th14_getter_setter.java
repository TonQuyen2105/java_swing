public class _26th14_getter_setter {
    
    public static void main(String[] args) {
        Car4 car = new Car4("Toyota", "Red", 30000, 2020);

        System.out.println(car.getColor());

        car.setColor("Blue");

        System.out.println(car.getColor());

        System.out.println(car.getPrice());

        car.setPrice(-5000);
    }
}
