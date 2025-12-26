class Starter {

    public static void startRunnables(Runnable[] runnables) {
        for (Runnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }
}

class Testus {
    public static void main(String[] args) {
        int n = 1000;
        Runnable[] runnables = new Runnable[n];
        for (int i = 0; i < runnables.length; i++) {
            runnables[i] = () -> System.out.println(Thread.currentThread().getName());
        }
        Starter.startRunnables(runnables);
    }
}
