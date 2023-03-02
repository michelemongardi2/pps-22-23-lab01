package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    public static final int FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void depositWithAtm(int userID, int depositAmountWithATM) {
        if(checkUser(userID) && isAmountGreaterThanOne(depositAmountWithATM)) {
            this.balance =+ depositAmountWithATM-FEE;
        } else throw new IllegalStateException("User not found or illegal deposit amount");
    }

    @Override
    public void withdrawWithAtm(int userID, int withdrawAmoutWithATM) {
        if (checkUser(userID) && isWithdrawAllowed(withdrawAmoutWithATM+FEE)) {
            this.balance -= withdrawAmoutWithATM+FEE;
        } else throw new IllegalStateException("User not found or illegal withdraw amount");
    }

    private boolean isAmountGreaterThanOne(int depositAmountWithATM) {
        return depositAmountWithATM > 1;
    }
}
