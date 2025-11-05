public class Car4 {

   private String model;
   private String color;
   private int price;
   private int year;

    Car4(String model, String color, int price, int year) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        } else {
            this.price = price;
        }
    }

}
