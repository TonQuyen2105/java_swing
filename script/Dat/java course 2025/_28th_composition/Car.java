public class Car {

    String model;
    int year;
    Engine engine;

    Car(String model, int year, String engineType, int horsepower ) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType, horsepower);
    }
    
    void start() {
        this.engine.start();
        System.out.println("the car " + this.model + " is running.");
    }
}
