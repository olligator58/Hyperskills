class Invoker {

    public static void invokeMethods(Thread t1, Thread t2, Thread t3) throws InterruptedException {
        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
        t1.join();
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("This is thread 1"));
        Thread t2 = new Thread(() -> System.out.println("This is thread 2"));
        Thread t3 = new Thread(() -> System.out.println("This is thread 3"));
        Invoker.invokeMethods(t1, t2, t3);
    }
}