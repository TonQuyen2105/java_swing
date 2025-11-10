public class _26th1_construter_oop_students{
    //object creation
    public static void main(String[] args) {
        Student1 student1 = new Student1("Alice", 20, "Computer Science", 3.8, false);
        Student1 student2 = new Student1("Bob", 22, "Mathematics", 3.5, true);

        student1.displayInfo();
        student1.study();
        student1.graduate();

        student2.displayInfo();
        student2.study();
        student2.graduate();
    }
}
