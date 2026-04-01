import java.util.concurrent.*;

class Mouth {
    private Semaphore semaphore2 = new Semaphore(1);
    private Semaphore semaphore3 = new Semaphore(1);

    public Mouth() {
        try {
            semaphore2.acquire();
            semaphore3.acquire();
        } catch (InterruptedException ignored) {
        }
    }

    public void first() throws InterruptedException {
        System.out.print("I ");
        semaphore2.release();
    }

    public void second() throws InterruptedException {
        semaphore2.acquire();
        System.out.print("love ");
        semaphore2.release();
        semaphore3.release();
    }

    public void third() throws InterruptedException {
        semaphore3.acquire();
        System.out.print("programming!");
        semaphore3.release();
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Mouth mouth = new Mouth();
        Thread t3 = new Thread(() -> {
            try {
                mouth.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C");
        Thread t2 = new Thread(() -> {
            try {
                mouth.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B");
        Thread t1 = new Thread(() -> {
            try {
                mouth.first();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A");
        t3.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t1.start();
        t3.join();
        t2.join();
        t1.join();
    }
}