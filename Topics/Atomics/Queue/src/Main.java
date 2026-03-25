//import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceArray;

class Queue {

    AtomicReferenceArray<Object> queue;

    public Queue(AtomicReferenceArray<Object> queue) {
        this.queue = queue;
    }

    public boolean enqueue(Object item) {
        for (int i = 0; i < queue.length(); i++) {
            if (queue.get(i) == null) {
                queue.set(i, item);
                return true;
            }
        }
        return false;
    }
}

/*
class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int numberOfThreads = scanner.nextInt();
        int n = scanner.nextInt();
        Thread[] threads = new Thread[numberOfThreads];
        AtomicReferenceArray<Object> newQueue = new AtomicReferenceArray<>(n);
        Queue queue = new Queue(newQueue);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < n; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + j + " " + queue.enqueue(j));
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.printf("Итоговая очередь: %s%n", newQueue);
        scanner.close();
    }
}*/
