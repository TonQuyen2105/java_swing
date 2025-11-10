public class Engine {
    
    String type;
    int horsepower;

    Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    void start() {
        System.out.println("you start the engine " + this.type + " with horsepower " + this.horsepower);
    }
}
