package kata.bank.domain.model;

import kata.bank.domain.TransactionType;
import kata.bank.infrastructure.utils.IdGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;

public final class Transaction {
    private Long id;
    private String accountIban;
    private LocalDate date;
    private BigDecimal amount;
    private BigDecimal balance;
    private TransactionType transactionType;


    public Transaction(Long id, String accountIban, LocalDate date, BigDecimal amount, BigDecimal balance, TransactionType transactionType) {
        this.id = id;
        this.accountIban = accountIban;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getAccountIban() {
        return accountIban;
    }

    public static Transaction of(String accountIban, BigDecimal amount, BigDecimal balance, TransactionType transactionType){
        return new Transaction(IdGenerator.generateId(), accountIban,LocalDate.now(),amount, balance, transactionType);
    }
}
