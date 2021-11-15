package kata.bank.domain.model;

import kata.bank.utils.AccountProvider;
import kata.bank.domain.exception.InsufficientFundsException;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    @Test
    public void shouldUpdateBalanceAfterDeposit(){
        final Account account = AccountProvider.getCreatedAccount();
        Account afterDeposit = account.deposit(valueOf(100));
        assertTrue(valueOf(200).compareTo(afterDeposit.getBalance()) == 0);
    }

    @Test
    public void shouldUpdateBalanceAfterWithdrawal(){
        final Account account = AccountProvider.getCreatedAccount();
        final Account afterWithdrawal = account.withdraw(valueOf(50));
        assertTrue(valueOf(50).compareTo(afterWithdrawal.getBalance()) == 0);
    }

    @Test
    public void shouldNotWithdrawWhenInsufficientFunds(){
        final  Account account = AccountProvider.getCreatedAccount();
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(valueOf(200)));
    }

}


