public class Timer implements Runnable {

    private final String text;

    Timer(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(text);
                // System.out.println(Thread.currentThread().getName() );
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
