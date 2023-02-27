import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Roberto", "Bianchi", 2);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositATM() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 200);
        assertEquals(199, bankAccountWithAtm.getBalance());
    }
}
