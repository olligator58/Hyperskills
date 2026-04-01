import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class SharedData {
    private String data = "";

    public SharedData(String data) {
        this.data = data;
    }

    public void preOperation() {
        data += "PRE";
    }

    public void calculate() {
        data += "Message";
    }

    public String getValue() {
        return data;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String preString = scanner.next();
        SharedData data = new SharedData(preString);

        int countOfPreprocessors = scanner.nextInt();
        CountDownLatch latch = new CountDownLatch(countOfPreprocessors);

        for (int i = 0; i < countOfPreprocessors; i++) {
            new Thread(() -> {
                synchronized (data) {
                    data.preOperation();
                }
                latch.countDown();
            }).start();
        }
        Thread thread = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (data) {
                data.calculate();
            }
        });
        thread.start();
        thread.join();
        System.out.println(data.getValue());
    }
}