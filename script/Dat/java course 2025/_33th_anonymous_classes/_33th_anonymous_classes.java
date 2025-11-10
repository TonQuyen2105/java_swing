public class _33th_anonymous_classes {
    public static void main(String[] args) {
        Dog1 dog1 = new Dog1();
        Dog1 dog2 = new Dog1(){
            @Override
            public void makeSound() {
                System.out.println("dog2 speaks bark");
            }
        };

        dog1.makeSound();
        dog2.makeSound();
    }
}
