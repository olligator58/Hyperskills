import java.util.Scanner;

class CountDownCounter {
    int count;

    public CountDownCounter(int initial) {
        this.count = initial;
    }

    public synchronized void decrement() {
        count--;
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int numOfThreads = scanner.nextInt();
        int times = scanner.nextInt();
        int initial = scanner.nextInt();

        CountDownCounter counter = new CountDownCounter(initial);
        Runnable task = () -> {
            for (int i = 0; i < times; i++) {
                counter.decrement();
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