public class Car2 {
    String model;
    String color;

    Car2(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
    }
}
