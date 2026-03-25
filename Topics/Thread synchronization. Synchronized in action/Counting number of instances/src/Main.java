//import java.util.Scanner;

class ClassCountingInstances {

    private static long numberOfInstances;

    public ClassCountingInstances() {
        synchronized (ClassCountingInstances.class) {
            numberOfInstances++;
        }
    }

    public static synchronized long getNumberOfInstances() {
        return numberOfInstances;
    }
}

/*
class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int numberOfThreads = scanner.nextInt();
        int numberOfInstances = scanner.nextInt();
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < numberOfInstances; j++) {
                    new ClassCountingInstances();
                    System.out.println(Thread.currentThread().getName() + " " + j);
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.printf("Всего создано записей класса: %d%n", ClassCountingInstances.getNumberOfInstances());
        scanner.close();
    }
}*/
