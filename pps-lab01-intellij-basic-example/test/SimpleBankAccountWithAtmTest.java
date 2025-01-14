import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountWithAtm;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccountWithAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Roberto", "Bianchi", 2);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithATM() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 200);
        assertEquals(199, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithATM() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 150);
        bankAccountWithAtm.withdrawWithAtm(accountHolder.getId(), 50);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testIllegalWithdraw() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 150);
        assertThrows(IllegalStateException.class, () -> bankAccountWithAtm.withdrawWithAtm(accountHolder.getId(), 150));
    }
}
