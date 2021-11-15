package kata.bank.service;

import kata.bank.domain.TransactionType;
import kata.bank.domain.exception.AccountNotExistException;
import kata.bank.domain.model.Account;
import kata.bank.domain.model.Transaction;
import kata.bank.domain.repository.AccountRepository;
import kata.bank.domain.repository.TransactionRepository;

import java.math.BigDecimal;

public class AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(String iban) {
        return accountRepository.findByIban(iban).orElseThrow(() ->
                new AccountNotExistException("There is no account related to this IBAN"));
    }

    public void deposit(String iban, BigDecimal amount) {
        Account account = getAccount(iban);
        account.deposit(amount);
        transactionRepository.addTransaction(Transaction.of(iban,amount,account.getBalance(), TransactionType.DEPOSIT));
        accountRepository.updateAccount(account);

    }

    public void withDraw(String iban, BigDecimal amount) {
        Account account = getAccount(iban);
        account.withdraw(amount);
        transactionRepository.addTransaction(Transaction.of(iban,amount,account.getBalance(), TransactionType.WITHDRAWAL));
        accountRepository.updateAccount(account);
    }

}
