public class _26th7_method_overriding {
    public static void main(String[] args) {
        People p1 = new People();
        p1.walk();

        Wheelchair_people p2 = new Wheelchair_people();
        p2.walk();

        Amputated_people p3 = new Amputated_people();
        p3.walk();
    }
    
}
