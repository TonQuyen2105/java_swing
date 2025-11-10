public class Teacher1 extends Person{
    String subject;
    double salary;

    Teacher1(String name, int age, String subject, double salary) {
        super(name, age); // Call the constructor of the superclass (Person)
        this.subject = subject;
        this.salary = salary;
    }

    void teach() {
        System.out.println(name + " is teaching " + subject + ".");
    }

    public void displayInfo() {
        super.displayInfo(); // Call the method from the superclass (Person)
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
    }
    
}
