class UseThreadLocal {
    public static ThreadLocal<Integer> makeThreadLocal(int counter) {
        return ThreadLocal.withInitial(() -> counter + 1);
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = UseThreadLocal.makeThreadLocal(5);
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            threadLocal.set(157);
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            threadLocal.set(462);
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        threadLocal.set(351);
        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
    }
}