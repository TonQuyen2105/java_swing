public class Product<T, U, V> {
    private T item;
    private U description;
    private V price; // Unused third type parameter for demonstration

    public void set(T item, U description, V price) {
        this.item = item;
        this.description = description;
        this.price = price;
    }
    public T get() {
        return this.item;
    }
    public U getDescription() {
        return this.description;
    }
    public V getPrice() {
        return this.price;
    }

}
