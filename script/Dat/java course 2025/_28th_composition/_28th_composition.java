public class _28th_composition {
    
    public static void main(String[] args) {
        
        Car car = new Car("Toyota", 2020, "V6", 300);
        
        System.out.println("Car Model: " + car.model);
        System.out.println("Car Year: " + car.year);
        System.out.println("Engine Type: " + car.engine.type);
        System.out.println("Engine Horsepower: " + car.engine.horsepower);

        car.start();
    }
}
