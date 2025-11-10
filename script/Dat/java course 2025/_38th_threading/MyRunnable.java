public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // System.out.println("Hello from the new thread!");
        for (int i = 1; i <= 5; i++) {
            // System.out.println(i + " seconds left...");
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                return;
            }
            if (i == 5) {
                System.out.println("Time's up!");
                System.exit(0);
            }
        }
    }
}
