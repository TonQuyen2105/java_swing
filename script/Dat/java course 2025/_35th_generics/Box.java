public class Box<Thing> {
    private Thing item;

    public void set(Thing item) {
        this.item = item;
    }

    public Thing get() {
        return item;
    }
    
}
