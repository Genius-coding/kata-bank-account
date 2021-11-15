package kata.bank.domain.repository;

import kata.bank.domain.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {
    void addTransaction(Transaction transaction);
    List<Transaction> getAccountTransactionsByIban(String iban);
    List<Transaction> getListTransactionsBetweenDates(String iban, LocalDate startDate, LocalDate endDate);
}
