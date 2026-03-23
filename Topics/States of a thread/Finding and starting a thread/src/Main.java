class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            if (thread.getState() == Thread.State.NEW) {
                thread.start();
                thread.join();
                break;
            }
        }
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {});
        Thread t2 = new Thread(() -> {});
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finished after 5 secs");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        ThreadProcessor.findAndStartThread(t1, t2, t3);
    }
}