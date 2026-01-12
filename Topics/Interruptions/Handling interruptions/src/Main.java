class CounterThread extends Thread {

    @Override
    public void run() {
        long counter = 0;

        while (true) {
            if (isInterrupted()) {
                System.out.println("It was interrupted");
                break;
            }
            counter++;
        }
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new CounterThread();
        t.start();
        Thread.sleep(10000);
        t.interrupt();
    }
}