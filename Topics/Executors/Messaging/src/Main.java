import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Do not change this class */
class Message {
    final String text;
    final String from;
    final String to;

    Message(String from, String to, String text) {
        this.text = text;
        this.from = from;
        this.to = to;
    }
}

/* Do not change this interface */
interface AsyncMessageSender {
    void sendMessages(Message[] messages);

    void stop();
}

class AsyncMessageSenderImpl implements AsyncMessageSender {
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private final int repeatFactor;

    public AsyncMessageSenderImpl(int repeatFactor) {
        this.repeatFactor = repeatFactor;
    }

    @Override
    public void sendMessages(Message[] messages) {
        for (Message msg : messages) {
            for (int i = 0; i < repeatFactor; i++) {
                executor.submit(() -> {
                    System.out.printf("(%s>%s): %s\n", msg.from, msg.to, msg.text); // do not change it
                });
            }
        }
    }

    @Override
    public void stop() {
        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Testus {
    public static void main(String[] args) {

        AsyncMessageSender sender = new AsyncMessageSenderImpl(1000);

        Message[] messages = {

                new Message("John", "Mary", "Hello!"),
                new Message("Clara", "Bruce", "How are you today?"),
                new Message("Huy", "Winnie", "How are you today?"),
                new Message("Pizda", "Kelly", "How are you today?"),
                new Message("Blyad", "Frank", "How are you today?")
        };

        sender.sendMessages(messages);
        sender.stop();

        System.out.println("Completed.");
    }
}