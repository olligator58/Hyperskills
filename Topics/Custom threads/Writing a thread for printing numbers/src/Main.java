import java.util.Scanner;

class NumbersThread extends Thread {
    private int from;
    private int to;

    public NumbersThread(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            System.out.println(i);
        }
    }
}

class Testus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        NumbersThread numbersThread = new NumbersThread(from, to);
        numbersThread.start();
        scanner.close();
    }
}