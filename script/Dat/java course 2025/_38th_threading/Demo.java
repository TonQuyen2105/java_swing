    import java.util.Scanner;
    import java.util.concurrent.*;
    
    public class Demo {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Scanner scanner = new Scanner(System.in);
    
            // Thread phụ: đếm ngược
            new Thread(() -> {
                for (int i = 5; i > 0; i--) {
                    try {
                        System.out.println(i + "...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Countdown interrupted");
                    }
                }
                System.out.println("Time's up!");
            }).start();
    
            // Thread nhập: giới hạn 5 giây
            Callable<String> task = () -> {
                System.out.print("Enter your name: ");
                return scanner.nextLine();
            };
    
            Future<String> future = executor.submit(task);
    
            try {
                String name = future.get(5, TimeUnit.SECONDS);
                System.out.println("Hello " + name);
            } catch (TimeoutException e) {
                System.out.println("You did not enter your name in time!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executor.shutdownNow();
                scanner.close();
            }
        }
    }
    

