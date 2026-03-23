class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        for (Thread thread : threads) {
            if (thread.getState() == Thread.State.TERMINATED) {
                System.out.println(thread.getName());
                break;
            }
        }
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finished after 5 sec");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName() + " finished after 6 sec");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " finished");
        });
        Thread[] threads = new Thread[]{t1, t2, t3};
        t1.start();
        t2.start();
        t3.start();
        t3.join();
        ThreadUtil.printNameOfTerminatedThread(threads);
    }
}