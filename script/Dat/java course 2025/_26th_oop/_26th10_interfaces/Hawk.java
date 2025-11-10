public class Hawk  implements Predator {

    @Override
    public void hunt(Prey prey) {
        System.out.println("The hawk is hunting the "+prey.getClass().getSimpleName());
    }
    
}
