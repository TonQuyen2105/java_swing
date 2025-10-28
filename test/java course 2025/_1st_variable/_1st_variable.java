// public class first {
    
//     public static void main (String[] args) {

//         System.out.println("Hello, World!");
//         // String color = " Red ";
//         // int year = 2025;
//         String color = "BLUE";
//         int year = 2025;
//         System.out.println("Welcome to Java programming." + "This is my first program." + color + year);
//                 final String RESET = "\u001B[0m";
//         final String RED = "\u001B[31m";
//         final String GREEN = "\u001B[32m";
//         final String YELLOW = "\u001B[33m";
//         final String BLUE = "\u001B[34m";


//         System.out.println(
//             RED + "Welcome to Java programming. "
//             + GREEN + "This is my first program. "
//             + YELLOW + "Welcome to Java programming. "
//             + BLUE + "This is my first program. "
//             + color + year
//             + RESET
//         );
//     }

// }

// public class first {
//     public static void main(String[] args) throws InterruptedException {
//         final String RESET = "\u001B[0m";

//         String text = "Welcome to Java programming. This is my first program. 2025";

//         // Mỗi ký tự sẽ đổi màu theo RGB tăng dần
//         int r = 255, g = 0, b = 0;

//         for (int i = 0; i < text.length(); i++) {
//             // tạo chuỗi màu ANSI dạng RGB
//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";

//             // in ký tự với màu
//             System.out.print(color + text.charAt(i) + RESET);

//             // đổi màu (ví dụ đổi dần sang xanh)
//             r = (r + 5) % 256;
//             g = (g + 3) % 256;
//             b = (b + 7) % 256;


//             Thread.sleep(50);
//         }

//         System.out.println(); // xuống dòng
//     }
// }


// public class first {
//     public static void main(String[] args) throws InterruptedException {
//         final String RESET = "\u001B[0m";
//         String text = "Welcome to Java programming. This is my first program. 2025";

//         // Vòng lặp đổi màu 20 lần
//         for (int i = 0; i < 20; i++) {
//             // Tạo màu RGB ngẫu nhiên
//             int r = (int)(Math.random() * 256);
//             int g = (int)(Math.random() * 256);
//             int b = (int)(Math.random() * 256);

//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";

//             // In ra cả dòng với màu mới
//             System.out.print("\r" + color + text + RESET);

//             Thread.sleep(200);
//         }

//         System.out.println(); // xuống dòng khi xong
//     }
// }

// public class first {
//     public static void main(String[] args) throws InterruptedException {
//         final String RESET = "\u001B[0m";
//         String text = "Welcome to Java programming. This is my first program. 2025";

//         // số bước lặp (số lần đổi màu)
//         for (int t = 0; t < 200; t++) {
//             // công thức tạo màu rainbow mượt
//             int r = (int) (127 * (Math.sin(0.1 * t) + 1));
//             int g = (int) (127 * (Math.sin(0.1 * t + 2) + 1));
//             int b = (int) (127 * (Math.sin(0.1 * t + 4) + 1));

//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";

//             // in đè trên một dòng (chữ đổi màu dần)
//             System.out.print("\r" + color + text + RESET);

//             // delay 50ms để thấy hiệu ứng
//             Thread.sleep(10);
//         }

//         System.out.println(); // kết thúc xuống dòng
//     }
// }


// import java.util.Scanner;

// public class first {
//     private static Scanner sc = new Scanner(System.in);

//     public static void main(String[] args) throws InterruptedException {
//         helloWorldBasic();      // Y tuong 1: Mau co dinh
//         waitEnter();

//         rainbowChar();          // Y tuong 2: Moi ky tu doi mau
//         waitEnter();

//         randomLineColors();     // Y tuong 3: Ca dong doi mau random
//         waitEnter();

//         smoothRainbowLine();    // Y tuong 4: Ca dong doi mau cau vong muot
//         waitEnter();

//         progressBar();          // Y tuong 5: Progress bar ngang
//         waitEnter();

//         spinnerLoading();       // Y tuong 6: Loading spinner
//         waitEnter();

//         System.out.println("\nTat ca hoat anh da hoan thanh!");
//     }

//     // Dung cho toi khi nhan Enter
//     private static void waitEnter() {
//         System.out.println("\n(Nhan Enter de tiep tuc...)");
//         sc.nextLine();
//     }

//     // Y tuong 1: In co ban voi mau co dinh
//     public static void helloWorldBasic() {
//         System.out.println("\n--- Y tuong 1: Mau co dinh ---");

//         final String RESET = "\u001B[0m";
//         final String RED = "\u001B[31m";
//         final String GREEN = "\u001B[32m";
//         final String YELLOW = "\u001B[33m";
//         final String BLUE = "\u001B[34m";

//         String color = "BLUE";
//         int year = 2025;

//         System.out.println(
//             RED + "Welcome to Java programming. "
//             + GREEN + "This is my first program. "
//             + YELLOW + "Welcome to Java programming. "
//             + BLUE + "This is my first program. "
//             + color + year
//             + RESET
//         );
//     }

//     // Y tuong 2: Moi ky tu doi mau RGB dan
//     public static void rainbowChar() throws InterruptedException {
//         System.out.println("\n--- Y tuong 2: Moi ky tu doi mau ---");

//         final String RESET = "\u001B[0m";
//         String text = "Welcome to Java programming. This is my first program. 2025";

//         int r = 255, g = 0, b = 0;
//         for (int i = 0; i < text.length(); i++) {
//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
//             System.out.print(color + text.charAt(i) + RESET);

//             r = (r + 5) % 256;
//             g = (g + 3) % 256;
//             b = (b + 7) % 256;

//             Thread.sleep(20);
//         }
//         System.out.println();
//     }

//     // Y tuong 3: Ca dong doi mau random
//     public static void randomLineColors() throws InterruptedException {
//         System.out.println("\n--- Y tuong 3: Dong doi mau random ---");

//         final String RESET = "\u001B[0m";
//         String text = "Welcome to Java programming. This is my first program. 2025";

//         for (int i = 0; i < 20; i++) {
//             int r = (int)(Math.random() * 256);
//             int g = (int)(Math.random() * 256);
//             int b = (int)(Math.random() * 256);

//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
//             System.out.print("\r" + color + text + RESET);

//             Thread.sleep(200);
//         }
//         System.out.println();
//     }

//     // Y tuong 4: Ca dong doi mau cau vong muot
//     public static void smoothRainbowLine() throws InterruptedException {
//         System.out.println("\n--- Y tuong 4: Dong doi mau cau vong muot ---");

//         final String RESET = "\u001B[0m";
//         String text = "Welcome to Java programming. This is my first program. 2025";

//         for (int t = 0; t < 200; t++) {
//             int r = (int) (127 * (Math.sin(0.1 * t) + 1));
//             int g = (int) (127 * (Math.sin(0.1 * t + 2) + 1));
//             int b = (int) (127 * (Math.sin(0.1 * t + 4) + 1));

//             String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
//             System.out.print("\r" + color + text + RESET);

//             Thread.sleep(50);
//         }
//         System.out.println();
//     }

//     // Progress bar ngang
//     public static void progressBar() throws InterruptedException {
//         System.out.println("\n--- Y tuong 5: Progress bar ngang ---");
//         int total = 30;
//         for (int i = 0; i <= total; i++) {
//             int percent = (i * 100) / total;
//             String bar = "=".repeat(i) + " ".repeat(total - i);
//             System.out.print("\r[" + bar + "] " + percent + "%");
//             Thread.sleep(100);
//         }
//         System.out.println("\nDone!");
//     }

//     // Spinner xoay xoay
//     public static void spinnerLoading() throws InterruptedException {
//         System.out.println("\n--- Y tuong 6: Spinner loading ---");
//         String[] spinner = {"|", "/", "-", "\\"};
//         System.out.print("Loading ");
//         for (int i = 0; i < 30; i++) {
//             System.out.print("\rLoading " + spinner[i % spinner.length]);
//             Thread.sleep(150);
//         }
//         System.out.println("\rLoading Done!");
//     }
// }


import java.io.IOException;

public class _1st_variable{
    private static volatile boolean skip = false;

    public static void main(String[] args) throws Exception {
        startSkipListener(); // bat thread nghe phim Enter

        helloWorldBasic();
        rainbowChar();
        randomLineColors();
        smoothRainbowLine();
        progressBar();
        progressBarSmooth();
        spinnerLoading();
        RainbowProgressBar.main(null);

        System.out.println("\nTat ca da xong!");
    }

    // Thread doc Enter
    private static void startSkipListener() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    int ch = System.in.read();
                    if (ch == '\n') {
                        skip = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private static void waitForEnter() throws IOException {
        skip = false;
        System.out.print("\n(Nhan Enter de tiep tuc...)\n");
        while (!skip) {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
        skip = false;
    }

    // --- Animation ---
    public static void helloWorldBasic() throws Exception {
        System.out.println("\n--- Y tuong 1: Mau co dinh ---");
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";

        String color = "BLUE";
        int year = 2025;

        System.out.println(
            RED + "Welcome to Java programming. "
            + GREEN + "This is my first program. "
            + YELLOW + "Welcome to Java programming. "
            + BLUE + "This is my first program. "
            + color + year
            + RESET
        );

        waitForEnter();
    }

    public static void rainbowChar() throws Exception {
        System.out.println("\n--- Y tuong 2: Moi ky tu doi mau ---");

        final String RESET = "\u001B[0m";
        String text = "Welcome to Java programming. This is my first program. 2025";

        int r = 255, g = 0, b = 0;
        for (int i = 0; i < text.length(); i++) {
            if (skip) break;
            String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
            System.out.print(color + text.charAt(i) + RESET);

            r = (r + 5) % 256;
            g = (g + 3) % 256;
            b = (b + 7) % 256;

            Thread.sleep(20);
        }
        System.out.println();

        waitForEnter();
    }

    public static void randomLineColors() throws Exception {
        System.out.println("\n--- Y tuong 3: Dong doi mau random ---");

        final String RESET = "\u001B[0m";
        String text = "Welcome to Java programming. This is my first program. 2025";

        for (int i = 0; i < 20; i++) {
            if (skip) break;
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);

            String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
            System.out.print("\r" + color + text + RESET);

            Thread.sleep(200);
        }
        System.out.println();

        waitForEnter();
    }

    public static void smoothRainbowLine() throws Exception {
        System.out.println("\n--- Y tuong 4: Dong doi mau cau vong muot ---");

        final String RESET = "\u001B[0m";
        String text = "Welcome to Java programming. This is my first program. 2025";

        for (int t = 0; t < 200; t++) {
            if (skip) break;
            int r = (int) (127 * (Math.sin(0.1 * t) + 1));
            int g = (int) (127 * (Math.sin(0.1 * t + 2) + 1));
            int b = (int) (127 * (Math.sin(0.1 * t + 4) + 1));

            String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
            System.out.print("\r" + color + text + RESET);

            Thread.sleep(50);
        }
        System.out.println();

        waitForEnter();
    }

    public static void progressBar() throws Exception {
        System.out.println("\n--- Y tuong 5: Progress bar ngang ---");
        int total = 30;
        for (int i = 0; i <= total; i++) {
            if (skip) break;
            int percent = (i * 100) / total;
            String bar = ">".repeat(i) + " ".repeat(total - i);
            System.out.print("\r[" + bar + "] " + percent + "%");
            Thread.sleep(100);
        }
        System.out.println("\nDone!");

        waitForEnter();
    }

    public static void progressBarSmooth() throws Exception {
        System.out.println("\n--- Y tuong 6: Progress bar lien mach ---");

        final int total = 50; // số block của thanh bar
        for (int i = 0; i <= total; i++) {
            if (skip) break;
            int percent = (i * 100) / total;
            String bar = "#".repeat(i) + "-".repeat(total - i); // dùng █ thay cho =
            System.out.print("\r[" + bar + "] " + percent + "%");
            Thread.sleep(80); // tốc độ chạy
        }
        System.out.println("\nDone!");

        waitForEnter();
    }


    public static void spinnerLoading() throws Exception {
        System.out.println("\n--- Y tuong 7: Spinner loading ---");
        String[] spinner = {"|", "/", "-", "\\"};
        System.out.print("Loading ");
        for (int i = 0; i < 30; i++) {
            if (skip) break;
            System.out.print("\rLoading " + spinner[i % spinner.length]);
            Thread.sleep(150);
        }
        System.out.println("\rLoading Done!");

        waitForEnter();
    }

    public class RainbowProgressBar {
    // ANSI màu cầu vồng
    private static final String[] COLORS = {
        "\u001B[31m", 
        "\u001B[33m",
        "\u001B[32m", 
        "\u001B[36m",
        "\u001B[34m", 
        "\u001B[35m", 
    };
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        int total = 40;  
        for (int i = 0; i <= total; i++) {
            if (skip) break;
            int percent = (i * 100) / total;

          

            String color = COLORS[i % COLORS.length];

            
            String bar = "#".repeat(i) + "-".repeat(total - i);

            
            System.out.print("\r" + color + "[" + bar + "] " + percent + "%" + RESET);

            Thread.sleep(120);
        }
        System.out.println("\nDone!");
    }
}

}

