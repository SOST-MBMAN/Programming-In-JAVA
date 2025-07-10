class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
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

public class ThreadExtend {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        MyThread thread3 = new MyThread("MBMAN");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}