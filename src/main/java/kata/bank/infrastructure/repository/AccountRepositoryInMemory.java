package kata.bank.infrastructure.repository;

import kata.bank.domain.model.Account;
import kata.bank.domain.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class AccountRepositoryInMemory implements AccountRepository {
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account save(Account account) {
        requireNonNull(account);
        accounts.put(account.getIban(),account);
        return accounts.get(account.getIban());
    }

    @Override
    public Optional<Account> findByIban(String IBAN) {
        requireNonNull(IBAN);
        return Optional.ofNullable(accounts.get(IBAN));
    }

    @Override
    public Account updateAccount(Account account) {
        return accounts.computeIfPresent(account.getIban(), (a,b) -> account);
    }
}
