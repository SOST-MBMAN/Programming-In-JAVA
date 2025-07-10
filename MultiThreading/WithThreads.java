public class WithThreads {
    public static void main(String[] args) {
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        });

        Thread letterThread = new Thread(() -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letter: " + c);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
            }
        });

        numberThread.start();
        letterThread.start();
    }
}
