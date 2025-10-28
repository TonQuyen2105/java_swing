import java.util.ArrayList;
import java.util.List;

public class _35th_generics {
    public static void main(String[] args) {
        System.out.println("Generics in Java");
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello, Generics!");
        System.out.println(stringBox.get());

        Product<Integer, String, Double> product = new Product<>();
        product.set(101, "Laptop", 999.99);
        Product<Integer, String, Double> product2 = new Product<>();
        product2.set(102, "Smartphone", 499.49);
        System.out.println(product.get());
        System.out.println(product.getDescription());
        System.out.println(product.getPrice());
        // Product[] products = {product, product2};
        List<Product<Integer, String, Double>> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        for (Product<Integer, String, Double> p : products) {
            System.out.println(p.get() + " - " + p.getDescription() + " - $" + p.getPrice());
        }
        System.out.println(productList);

    }
}
