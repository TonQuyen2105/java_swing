public abstract class Shape {
    // Abstract method (must be implemented by subclasses)
    public abstract double area();

    // Non-abstract method
    public static void display() {//concrete method
        System.out.println("This is a shape");
    }
    
}
