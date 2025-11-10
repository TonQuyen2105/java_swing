public class _26th5_inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);
        dog.displayInfo(); // Calling method from Animal class
        dog.bark(); // Calling method from Dog class
        dog.eat();  // Calling inherited method from Animal class
        System.out.println(dog.isAlive); // Accessing inherited field from Animal class


        Cat1 cat = new Cat1("Whiskers", 2);
        cat.displayInfo(); // Calling method from Animal class
        cat.meow(); // Calling method from Cat class
        cat.eat();  // Calling inherited method from Animal class
        System.out.println(cat.isAlive); // Accessing inherited field from Animal class

        Organism org = new Organism();
        System.out.println(org.isAlive); // Accessing field from Organism class

        org.isAlive = false;
        System.out.println(org.isAlive); // Accessing field from Organism class

        Plant plant = new Plant();
        plant.photosynthesize(); // Calling method from Plant class
        System.out.println(plant.isAlive); // Accessing inherited field from Organism class
    }
}
