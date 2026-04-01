import java.util.concurrent.Semaphore;

class Buffer {
    private char data;
    private Semaphore producerSemaphore = new Semaphore(1);
    private Semaphore consumerSemaphore = new Semaphore(1);

    public Buffer() {
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException ignored) {
        }
    }

    public void get() throws InterruptedException {
        consumerSemaphore.acquire();
        System.out.println("Consumer consumed data : " + data);
        producerSemaphore.release();
    }

    public void put(char data) throws InterruptedException {
        producerSemaphore.acquire();
        this.data = data;
        System.out.println("Producer produced data : " + data);
        consumerSemaphore.release();
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        String input = "1234567890";
        Buffer buffer = new Buffer();
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < input.length(); i++) {
                    buffer.get();
                }
            } catch (InterruptedException ignored) {
            }
        });
        Thread producer = new Thread(() -> {
            for (int i = 0; i < input.length(); i++) {
                try {
                    buffer.put(input.charAt(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumer.start();
        producer.start();
    }
}