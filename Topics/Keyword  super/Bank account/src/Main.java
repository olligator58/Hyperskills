class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {

    protected double fee;

    public CheckingAccount(String number, Long balance, double fee) {
        super(number, balance);
        this.fee = fee;
    }
}

class SavingsAccount extends BankAccount {

    protected double interestRate;

    public SavingsAccount(String number, Long balance, double interestRate) {
        super(number, balance);
        this.interestRate = interestRate;
    }
}

class Test {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount("40702810648000000001", 450000L, 12.90);
        print(checkingAccount);
        SavingsAccount savingsAccount = new SavingsAccount("42301810756009834123", 700000L, 19.5);
        print(savingsAccount);
    }

    private static void print(CheckingAccount checkingAccount) {
        System.out.println("CheckingAccount{" +
                "number='" + checkingAccount.number + '\'' +
                ", balance=" + checkingAccount.balance +
                ", fee=" + checkingAccount.fee +
                '}');
    }

    private static void print(SavingsAccount savingsAccount) {
        System.out.println("SavingsAccount{" +
                "number='" + savingsAccount.number + '\'' +
                ", balance=" + savingsAccount.balance +
                ", interestRate=" + savingsAccount.interestRate +
                '}');
    }
}