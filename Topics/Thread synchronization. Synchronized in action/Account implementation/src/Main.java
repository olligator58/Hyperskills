import java.util.Scanner;

class Account {

    private long balance = 0;

    public synchronized boolean withdraw(long amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(long amount) {
        balance += amount;
    }

    public long getBalance() {
        return balance;
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        int numOfThreads = scanner.nextInt();
        int numOfOperations = scanner.nextInt();
        Thread[] threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < numOfOperations; j++) {
                    account.deposit(2);
                    System.out.println(Thread.currentThread().getName() + " " + account.getBalance());
                    account.withdraw(1);
                    System.out.println(Thread.currentThread().getName() + " " + account.getBalance());
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.printf("Итоговый баланс счета: %d%n", account.getBalance());
        scanner.close();
    }
}