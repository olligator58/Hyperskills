import java.util.Scanner;

class MessageNotifier extends Thread {
    private String msg;
    private int repeats;


    public MessageNotifier(String msg, int repeats) {
        this.msg = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeats; i++) {
            System.out.println(msg);
        }
    }
}

class Testus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        int repeats = scanner.nextInt();
        MessageNotifier messageNotifier = new MessageNotifier(msg, repeats);
        messageNotifier.start();
        scanner.close();
    }
}