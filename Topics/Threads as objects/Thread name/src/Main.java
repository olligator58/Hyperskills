class ThreadUtil {
    public static String getName(Thread thread) {
        return thread.getName();
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(ThreadUtil.getName(Thread.currentThread()));
    }
}