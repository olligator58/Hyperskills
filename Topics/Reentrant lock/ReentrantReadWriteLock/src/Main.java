import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.Scanner;
import java.util.ArrayList;

class ThreadSafeCache {

    private static int cache;
    private final ReentrantReadWriteLock lock;

    public ThreadSafeCache() {
        cache = 0;
        lock = new ReentrantReadWriteLock();
    }

    public int get() {
        lock.readLock().lock();
        try {
            return cache;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void add() {
        lock.writeLock().lock();
        try {
            cache++;
        } finally {
            lock.writeLock().unlock();
        }
    }
}

// Protect code below...
public class Main {
    private static final int COUNT_READ = 10;

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCache cache = new ThreadSafeCache();

        Scanner scanner = new Scanner(System.in);
        int countAdd = scanner.nextInt();

        Runnable writerTask = () -> {
            for (int i = 0; i < countAdd; i++) {
                cache.add();
            }
        };
        Runnable readerTask = () -> {
            for (int i = 0; i < COUNT_READ; i++) {
                cache.get();
            }
        };

        Thread writerThread1 = new Thread(writerTask);
        Thread writerThread2 = new Thread(writerTask);
        Thread writerThread3 = new Thread(writerTask);
        Thread readerThread1 = new Thread(readerTask);
        Thread readerThread2 = new Thread(readerTask);

        writerThread1.start();
        writerThread2.start();
        writerThread3.start();
        readerThread1.start();
        readerThread2.start();
        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(writerThread1);
        threads.add(writerThread2);
        threads.add(writerThread3);
        threads.add(readerThread1);
        threads.add(readerThread2);

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(cache.get());
    }
}