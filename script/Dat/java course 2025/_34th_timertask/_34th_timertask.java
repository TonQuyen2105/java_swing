import java.util.Timer;
import java.util.TimerTask;

public class _34th_timertask {

    static int count = 3;
    static Timer time = new Timer();
    
    public static void main(String[] args) {
        System.out.println("This is a timer task example.");
        TimerTask task = new MyTask();
        time.schedule(task, 1000,100); // Schedule task to run after 1 second and repeat every 2 seconds
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Timer task executed.");
            count--;
            if (count <= 0) {
                time.cancel();
            }
        }
    }
}
