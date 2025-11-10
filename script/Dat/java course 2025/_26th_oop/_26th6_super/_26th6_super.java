public class _26th6_super {
    public static void main(String[] args) {
        Student1 student = new Student1("Alice", 20, "Computer Science", 3.8);
        Teacher1 teacher = new Teacher1("Mr. Smith", 45, "Mathematics", 55000.0);
        student.displayInfo(); // Calling method from Person class
        student.study(); // Calling method from Student class
        System.out.println("========================");
        teacher.displayInfo(); // Calling method from Person class
        teacher.teach(); // Calling method from Teacher class
    }
    
}
