import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

class MyList {
    public void removeDuplicates(AtomicReference<List<Integer>> list) {
        List<Integer> sortedList = list.get().stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        list.set(sortedList);
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<List<Integer>> list = new AtomicReference<>(List.of(5, 3, 4, 5, 4, 3, 2, 2, 1, 1, 3, 4, 5));
        System.out.printf("Исходный список: %s%n", list.get());
        Scanner scanner = new Scanner(System.in);
        int numOfThreads = scanner.nextInt();
        int numOfOperations = scanner.nextInt();
        Thread[] threads = new Thread[numOfThreads];
        MyList myList = new MyList();

        for (int i = 0; i < numOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < numOfOperations; j++) {
                    myList.removeDuplicates(list);
                    System.out.println(Thread.currentThread().getName() + " " + list.get());
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.printf("Итоговый список: %s%n", list.get());
        scanner.close();
    }
}