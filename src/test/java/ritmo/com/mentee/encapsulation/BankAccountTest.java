package ritmo.com.mentee.encapsulation;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConstructorAndGetters() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");

        assertEquals("ACC123456", account.getAccountNumber());
        assertEquals("Katlego Mtimane", account.getOwnerName());
        assertEquals(0.0, account.getBalance(), 0.001); // balance should start at 0
    }

    @Test
    void testDepositValidAmount() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");

        account.deposit(500.75);

        assertEquals(500.75, account.getBalance(), 0.001);
    }

    @Test
    void testMultipleDeposits() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");

        account.deposit(1000);
        account.deposit(250.50);

        assertEquals(1250.50, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");
        account.deposit(1000);

        account.withdraw(300);

        assertEquals(700, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawExactBalance() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");
        account.deposit(500);

        account.withdraw(500);

        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void testDepositZeroOrNegativeAmountThrowsException() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testWithdrawZeroOrNegativeAmountThrowsException() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount("ACC123456", "Katlego Mtimane");
        account.deposit(500);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600));
    }

    @Test
    void testToStringMethod() {
        BankAccount account = new BankAccount("ACC789", "John Doe");
        account.deposit(1500);

        String result = account.toString();

        assertTrue(result.contains("ACC789"));
        assertTrue(result.contains("John Doe"));
        assertTrue(result.contains("1500"));
    }
}
