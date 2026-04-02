import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

class UseCopyOnWriteArrayList {

    public static void printElement(int n) throws InterruptedException {

        CopyOnWriteArrayList<Integer> onWriteArrayList = new CopyOnWriteArrayList<>();

        Thread writer1 = new Thread(() -> Main.addNumbers(onWriteArrayList));
        Thread writer2 = new Thread(() -> Main.removeNumbers(onWriteArrayList));

        writer1.start();
        writer2.start();

        writer1.join();
        writer2.join();

        System.out.println(onWriteArrayList.get(n));
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        UseCopyOnWriteArrayList.printElement(n);
    }

    public static void addNumbers(List<Integer> list) {
        for (int i = 0; i <= 100_000; i++) {
            list.add(i);
        }
    }

    public static void removeNumbers(List<Integer> list) {
        int counter = 0;
        while (counter <= 50_000) {
            if (list.contains(counter)) {
                list.remove(Integer.valueOf(counter));
                counter++;
            }
        }
    }
}