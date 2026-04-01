import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class SharedData {
    private String data = "";

    public void loadData(String info) {
        data += info;
    }

    public String getData() {
        return data;
    }
}

class DataLoader implements Runnable {
    private final CountDownLatch latch;
    private final SharedData data;

    DataLoader(CountDownLatch latch, SharedData data) {
        this.latch = latch;
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            data.loadData("ABA");
        }
        latch.countDown();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();
        Scanner scanner  = new Scanner(System.in);
        int countOfSources = scanner.nextInt();
        CountDownLatch latch = new CountDownLatch(countOfSources);
        for (int i = 0; i < countOfSources; i++) {
            new Thread(new DataLoader(latch, data)).start();
        }
        latch.await();
        System.out.println(data.getData());
    }
}