import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SquareUpDown {
    private int counter = 2;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int depth = 0;
    private final int threshold;

    public SquareUpDown(int threshold) {
        this.threshold = threshold;
    }

    public void pow() {
        lock.writeLock().lock();
        try{
            if (counter < threshold) {
                counter *= 2;
                pow();
            } else {
                depth = lock.writeLock().getHoldCount();
            }
        } finally{
            lock.writeLock().unlock();
        }
    }

    public int getDegree() {
        lock.readLock().lock();
        try{
            return depth;
        } finally{
            lock.readLock().unlock();
        }
    }
}

// Protect code below...
public class Main {
    private static final int COUNT_READ = 10;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int threshold = scanner.nextInt();
        SquareUpDown recursiveCounter = new SquareUpDown(threshold);

        Runnable writerTask = recursiveCounter::pow;

        Runnable readerTask = () -> {
            for (int i = 0; i < COUNT_READ; i++) {
                recursiveCounter.getDegree();
            }
        };

        Thread writerThread = new Thread(writerTask);
        Thread logger1 = new Thread(readerTask);
        Thread logger2 = new Thread(readerTask);
        writerThread.start();
        logger1.start();
        logger2.start();


        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(writerThread);
        threads.add(logger1);
        threads.add(logger2);

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(recursiveCounter.getDegree());
    }
}