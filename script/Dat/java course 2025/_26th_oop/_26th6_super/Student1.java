public class Student1 extends Person {
    String studentId;
    double gpa;

    Student1(String name, int age, String studentId, double gpa) {
        super(name, age); // Call the constructor of the superclass (Person)
        this.studentId = studentId;
        this.gpa = gpa;
    }

    void study() {
        System.out.println(name + " is studying.");
    }

    public void displayInfo() {
        super.displayInfo(); // Call the method from the superclass (Person)
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
    }
    
}
