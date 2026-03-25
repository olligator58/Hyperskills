//import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class RequestCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}

/*
class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        RequestCounter counter = new RequestCounter();
        int numOfThreads = scanner.nextInt();
        int numOfOperations = scanner.nextInt();
        Thread[] threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < numOfOperations; j++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.printf("Итоговое значение счетчика: %d%n", counter.getCount());
        scanner.close();
    }
}*/
