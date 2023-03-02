package lab01.example.model;

public interface BankAccountWithAtm extends BankAccount {

    void depositWithAtm(int userID, int amount);

    void withdrawWithAtm(int id, int i);

}
