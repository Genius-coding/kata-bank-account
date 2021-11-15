package kata.bank.domain.repository;

import kata.bank.domain.model.Account;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account any);
    Optional<Account> findByIban(String IBAN);
    Account updateAccount(Account account);
}
