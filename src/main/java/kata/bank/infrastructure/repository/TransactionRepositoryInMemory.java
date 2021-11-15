package kata.bank.infrastructure.repository;



import kata.bank.domain.model.Transaction;
import kata.bank.domain.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class TransactionRepositoryInMemory implements TransactionRepository {

    ArrayList<Transaction> transactions = new ArrayList<>();
    @Override
    public void addTransaction(Transaction transaction) {
        requireNonNull(transaction);
        transactions.add(transaction );
    }

    @Override
    public List<Transaction> getAccountTransactionsByIban(String iban) {
            return transactions.stream()
                    .filter(t -> t.getAccountIban().equals(iban))
                    .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Transaction> getListTransactionsBetweenDates(String iban, LocalDate startDate, LocalDate endDate) {
        return getAccountTransactionsByIban(iban).stream()
                .filter(transaction -> datePredicate(startDate, endDate, transaction))
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .collect(Collectors.toList());
    }

    private boolean datePredicate(LocalDate startDate, LocalDate endDate, Transaction transaction) {
        return transaction.getDate().isBefore(endDate) && transaction.getDate().isAfter(startDate);
    }


}
