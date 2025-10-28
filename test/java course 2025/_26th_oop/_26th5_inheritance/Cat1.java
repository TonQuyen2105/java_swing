public class Cat1 extends Animal1 {
    String name;
    int age;

    public Cat1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void meow() {
        System.out.println(name + " says: Meow!");
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
    
}
