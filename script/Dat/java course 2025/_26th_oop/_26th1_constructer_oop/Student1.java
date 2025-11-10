public class Student1 {
    String name;
    int age;
    String major;
    double gpa;
    boolean isGraduated;

    // Constructor
    public Student1(String name, int age, String major, double gpa, boolean isGraduated) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
        this.isGraduated = isGraduated;
    }

    void study() {
        System.out.println(name + " is studying " + major);
    }

    void graduate() {
        if (!isGraduated) {
            isGraduated = true;
            System.out.println(name + " has graduated!");
        } else {
            System.out.println(name + " has already graduated.");
        }
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Is Graduated: " + isGraduated);
    }    
}
