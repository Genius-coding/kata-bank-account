package kata.bank.service;


import kata.bank.utils.AccountProvider;
import kata.bank.domain.exception.AccountNotExistException;
import kata.bank.domain.model.Account;
import kata.bank.domain.repository.AccountRepository;
import kata.bank.domain.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private AccountService accountService;

    @BeforeEach
    public void setUp(){
        accountRepository =  mock(AccountRepository.class);
        transactionRepository = mock(TransactionRepository.class);
        accountService = new AccountService(accountRepository, transactionRepository);
    }
    @Test
    public void createAccount_thenSaveAccount() {
        final Account account = AccountProvider.getCreatedAccount();
        when(accountRepository.save(account)).thenReturn(account);
        final Account savedAccount = accountService.createAccount(account);
        verify(accountRepository).save(any(Account.class));
        assertNotNull(savedAccount);
    }


    @Test
    public void searchAccountByIBAN_theReturnAccount() {
        final Account account = AccountProvider.getCreatedAccount();
        when(accountRepository.save(account)).thenReturn(account);
        when(accountRepository.findByIban(account.getIban())).thenReturn(Optional.of(account));
        Account savedAccount = accountService.createAccount(account);
        assertEquals(savedAccount,accountService.getAccount(account.getIban()));
    }

    @Test
    public void searchAccountByIBAN_theReturnException(){
        final Account account= AccountProvider.getCreatedAccount();
        when(accountRepository.findByIban(account.getIban())).thenReturn(Optional.empty());
        verify(accountRepository,times(0)).findByIban(any());
        assertThrows(AccountNotExistException.class, () -> accountService.getAccount(account.getIban()));

    }


    // Test Case Update account After Deposit
    // Test Case Update account After Withdraw


}
