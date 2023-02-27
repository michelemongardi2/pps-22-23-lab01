package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final AccountHolder accountHolder;
    private double balance;
    public SimpleBankAccountWithAtm(AccountHolder accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void depositWithAtm(int userID, int amout) {
        if(checkUser(userID)) {
            this.balance =+ amout-1;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {

    }

    private boolean checkUser(final int id) {
        return this.accountHolder.getId() == id;
    }
}
