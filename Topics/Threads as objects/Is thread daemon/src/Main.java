class ThreadUtil {
    public static void printIfDaemon(Thread thread) {
        System.out.println((thread.isDaemon()) ? "daemon" : "not daemon");
    }
}

class Testus {
    public static void main(String[] args) {
        ThreadUtil.printIfDaemon(Thread.currentThread());
        Thread daemon = new Thread(()-> {});
        daemon.setDaemon(true);
        daemon.start();
        ThreadUtil.printIfDaemon(daemon);
    }
}