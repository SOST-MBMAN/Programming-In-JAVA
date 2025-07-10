// This code demonstrates how to print numbers and letters sequentially without using threads.
public class WithoutThreads {
    public static void main(String[] args) {
        printNumbers();
        printLetters();
    }

    static void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }

    static void printLetters() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letter: " + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }
}
