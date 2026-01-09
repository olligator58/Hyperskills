class Account {

    private volatile long balance = 0;

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
        Account account = new Account();
        Runnable task1 = () -> {
            for (int i = 0; i < 5000000; i++) {
                account.deposit(1);
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 4000000; i++) {
                account.deposit(1);
            }
        };
        Runnable task3 = () -> {
            for (int i = 0; i < 8500000; i++) {
                account.withdraw(1);
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();

        Thread.sleep(10000);
        System.out.println(account.getBalance());
    }
}