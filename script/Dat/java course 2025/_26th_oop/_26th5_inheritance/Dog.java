public class Dog extends Animal1 {
    String name;
    int age;

    // Constructor
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method specific to Dog class
    public void bark() {
        System.out.println(name + " says Woof!");
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
    
}
