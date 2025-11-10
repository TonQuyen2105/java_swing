public class _26th11_polymorphism {
    
    // Polymorphism: Many forms
    // Method Overloading: Compile time polymorphism
    // Can be achieved by abstract class and interface or by method overloading

    public static void main(String[] args) {
        Boat boat = new Boat();

        Plane plane = new Plane();

        Truck truck = new Truck();

        Vehicle[] vehicle = {boat, plane, truck};//polymorphism

        for (int i = 0; i < vehicle.length; i++) {
            vehicle[i].go();
        }
    }
}
