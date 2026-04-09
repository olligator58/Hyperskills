import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class TransactionCollector {

    public static Map<String, Long> getAccount2TransSum(List<Transaction> trans) {
        return trans.stream()
                .collect(
                        Collectors.groupingBy(t -> t.getAccount().getNumber(), summingLong(Transaction::getSum))
                );
    }

    static class Transaction {

        private final String uuid;
        private final Long sum;
        private final Account account;

        public Transaction(String uuid, Long sum, Account account) {
            this.uuid = uuid;
            this.sum = sum;
            this.account = account;
        }

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "uuid='" + uuid + '\'' +
                    ", sum=" + sum +
                    '}';
        }
    }

    static class Account {
        private final String number;
        private final Long balance;

        public Account(String number, Long balance) {
            this.number = number;
            this.balance = balance;
        }

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }

}

class Testus {
    public static void main(String[] args) {
        TransactionCollector.Account account1 = new TransactionCollector.Account("40702", 5000L);
        TransactionCollector.Account account2 = new TransactionCollector.Account("20202", 600000000L);
        TransactionCollector.Account account3 = new TransactionCollector.Account("42301", 1200000L);
        List<TransactionCollector.Transaction> transactions = new ArrayList<>();
        transactions.add(new TransactionCollector.Transaction("1", 1000L, account1));
        transactions.add(new TransactionCollector.Transaction("2", 500L, account1));
        transactions.add(new TransactionCollector.Transaction("3", 27L, account1));
        transactions.add(new TransactionCollector.Transaction("4", 10000L, account2));
        transactions.add(new TransactionCollector.Transaction("5", 3000L, account2));
        transactions.add(new TransactionCollector.Transaction("6", 421L, account2));
        transactions.add(new TransactionCollector.Transaction("7", 7000L, account3));
        transactions.add(new TransactionCollector.Transaction("8", 900L, account3));
        transactions.add(new TransactionCollector.Transaction("9", 13L, account3));
        System.out.println(TransactionCollector.getAccount2TransSum(transactions));
    }
}