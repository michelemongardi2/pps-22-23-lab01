package lab01.example.model;

/**
 * Exercise 1 - IntelliJ Basics, Software Quality and Tests
 * Implement a new version of a bank account, allowing the deposit and
 * the withdrawal also using the ATM. Each transaction done with the
 * ATM implies paying a 1$ fee.
 *   - The new bank account must implement the BankAccount interface and
 *     coded into a new class SimpleBankAccountWithAtm
 *   - It is requested to provide a new test class for the new bank account
 *     (SimpleBankAccountWithAtmTest)
 */

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
