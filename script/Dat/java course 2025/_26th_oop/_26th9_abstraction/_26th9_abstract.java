public class _26th9_abstract {
    public static void main(String[] args) {
        // Abstract class cannot be instantiated
        // Abstract class can have abstract and non-abstract methods
        // Abstract class can have constructors
        // Abstract class can have member variables
        // Abstract class can be extended by other classes
        // Abstract class can implement interfaces

        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 5);
        Rectangle rectangle = new Rectangle(6, 7);
        circle.display();
        triangle.display();
        rectangle.display();
        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Area of Triangle: " + triangle.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
    }
    
}
