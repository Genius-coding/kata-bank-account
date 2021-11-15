package kata.bank.domain.model;
import kata.bank.domain.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class Account {
    private final String iban;
    private final BigDecimal balance;

    public Account(String iban, BigDecimal  balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public Account deposit(BigDecimal amount){
        return new Account(iban, balance.add(amount));
    }

    public Account withdraw(BigDecimal amount){
        if(balance.compareTo(amount) < 0){
            throw new InsufficientFundsException("Funds insufficient to process this operation !");
        }
        return new Account(iban, balance.subtract(amount));
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}
