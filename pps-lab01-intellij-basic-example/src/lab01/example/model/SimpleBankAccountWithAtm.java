package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void depositWithAtm(int userID, int depositAmountWithATM) {
        if(checkUser(userID) && isAmountGreaterThanOne(depositAmountWithATM)) {
            this.balance =+ depositAmountWithATM-1;
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
        return this.holder.getId() == id;
    }
}
