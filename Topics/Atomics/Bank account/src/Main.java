import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

class BankAccount {
    private AtomicLong balance;

    public BankAccount(long initialBalance) {
        balance = new AtomicLong(initialBalance);
    }

    public void deposit(long amount) {
        balance.addAndGet(amount);
    }

    public boolean withdraw(long amount) {
        if (amount <= balance.get()) {
            balance.addAndGet(-amount);
            return true;
        }
        return false;
    }

    public long getBalance() {
        return balance.get();
    }
}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0);
        int numOfThreads = scanner.nextInt();
        int numOfOperations = scanner.nextInt();
        Thread[] threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < numOfOperations; j++) {
                    account.deposit(100);
                    System.out.println(Thread.currentThread().getName() + " " + account.getBalance());
                    account.withdraw(99);
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