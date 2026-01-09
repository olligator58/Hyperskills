import java.util.Scanner;

class Counter {
    int count = 0;

    public synchronized void inc() {
        count++;
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
        int numOfThreads = scanner.nextInt();
        int times = scanner.nextInt();
        Runnable task = () -> {
            for (int i = 0; i < times; i++) {
                counter.inc();
            }
        };
        for (int i = 0; i < numOfThreads; i++) {
            new Thread(task).start();
        }
        Thread.sleep(10000);
        System.out.println(counter.count);
        scanner.close();
    }
}