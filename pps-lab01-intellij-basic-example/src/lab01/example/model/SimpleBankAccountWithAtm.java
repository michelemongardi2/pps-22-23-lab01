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
    public void deposit(final int userID, final double depositAmount) {
        if (checkUser(userID)) {
            this.balance += depositAmount;
        }
    }

    @Override
    public void depositWithAtm(int userID, int depositAmountWithATM) {
        if(checkUser(userID) && isAmountGreaterThanOne(depositAmountWithATM)) {
            this.balance =+ depositAmountWithATM-1;
        }
    }

    @Override
    public void withdraw(int userID, double withdrawAmout) {
        if (checkUser(userID) && isWithdrawAllowed(withdrawAmout)) {
            this.balance -= withdrawAmout;
        }
    }

    @Override
    public void withdrawWithAtm(int userID, int withdrawAmoutWithATM) {
        if (checkUser(userID) && isWithdrawAllowed(withdrawAmoutWithATM)){
            this.balance -= withdrawAmoutWithATM+1;
        }
    }

    private boolean isAmountGreaterThanOne(int depositAmountWithATM) {
        return depositAmountWithATM > 1;
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount+1;
    }

    private boolean checkUser(final int id) {
        return this.accountHolder.getId() == id;
    }
}
