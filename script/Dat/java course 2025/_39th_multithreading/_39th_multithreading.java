public class _39th_multithreading {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Thread timerThread = new Thread(new Timer());
        // timerThread.start();

        Thread player1 = new Thread(new Timer("Ping"));
        Thread player2 = new Thread(new Timer("Pong"));

        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game Over!");
    }
}
