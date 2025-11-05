public class _26th10_interfaces {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();

        rabbit.flee();

        Hawk hawk = new Hawk();

        hawk.hunt(rabbit);

        Fish fish = new Fish();

        fish.flee();

        Fish shark = new Shark();

        shark.hunt(fish);
    }
}
