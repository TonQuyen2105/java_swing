public class Car1 {
    String make = "Toyota";
    String model = "Camry";
    int year = 2020;
    double price = 25000.0;
    boolean isElectric = false;
    boolean isRunning = false;

    void start() {
        isRunning = true;   
        System.out.println("Car is starting");
    }

    void stop() {
        isRunning = false;
        System.out.println("Car is stopping");
    }

    void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
        System.out.println("Is Electric: " + isElectric);
    }
}
