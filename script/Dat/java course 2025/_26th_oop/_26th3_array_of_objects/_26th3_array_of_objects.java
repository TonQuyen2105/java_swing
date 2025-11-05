public class _26th3_array_of_objects {
    public static void main(String[] args) {

        Car2 car1 = new Car2("Toyota", "Red");
        Car2 car2 = new Car2("BMW", "White");
        Car2 car3 = new Car2("Honda", "Blue");
        Car2 car4 = new Car2("Ford", "Black");

        Car2[] cars = {car1, car2, car3, car4};

        for (int i = 0; i < cars.length; i++) {
            System.out.println("--------------------------------------------");
            cars[i].displayInfo();
            System.out.println("--------------------------------------------");
        }

        for (Car2 car : cars) {
            System.out.println("********************************************");
            car.displayInfo();
            System.out.println("********************************************");
        }

        for (Car2 car : cars) {
            System.out.println("********************************************");
            car.color = "Yellow";
            car.displayInfo();
            System.out.println("********************************************");
        }
    }
}
