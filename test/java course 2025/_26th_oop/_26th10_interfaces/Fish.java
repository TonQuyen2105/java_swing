public class Fish implements Prey, Predator {

    @Override
    public void flee() {
        System.out.println("The fish is swimming away");
    }

    @Override
    public void hunt(Prey prey) {
        System.out.println("The fish is hunting the " + prey.getClass().getSimpleName());
    }
}

class Shark extends Fish {
    
    @Override
    public void hunt(Prey prey) {
        System.out.println("The shark is hunting the " + prey.getClass().getSimpleName());
}    
}
