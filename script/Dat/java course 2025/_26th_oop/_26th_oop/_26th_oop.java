public class _26th_oop {

    //object creation
    
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();


        car1.make = "GMC";
        car1.model = "Sierra";
        car1.year = 2020;
        car1.price = 35000.0;
        car1.isElectric = false;

        System.out.println(car1.make);
        System.out.println(car1.model);
        System.out.println(car1.year);
        System.out.println(car1.price);
        System.out.println(car1.isElectric);
        System.out.println("Is the car running? " + car1.isRunning);
        car1.start();
        System.out.println("Is the car running? " + car1.isRunning);
        car1.stop();
        System.out.println("Is the car running? " + car1.isRunning);
        car1.displayInfo();
    }
}  
