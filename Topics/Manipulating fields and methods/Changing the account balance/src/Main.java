import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() {
    }

    public static void increaseBalance(Account account, long amount) {
        try {
            Field field = account.getClass().getDeclaredField("balance");
            field.setAccessible(true);
            long balance = (long) field.get(account);
            balance += amount;
            field.set(account, balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    // some other methods
    //to delete
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}

class Testus {
    public static void main(String[] args) {
        Account account = new Account(50000);
        System.out.println(account);
        AccountUtils.increaseBalance(account, 333);
        System.out.println(account);
    }
}
