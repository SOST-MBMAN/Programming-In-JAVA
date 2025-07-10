class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + ": Count " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                System.out.println(name + ": Interrupted");
            }
        }
    }
}

public class RunnableImplementation {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable("Runnable-1");
        Runnable runnable2 = new MyRunnable("Runnable-2");

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}