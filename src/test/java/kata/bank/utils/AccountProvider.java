package kata.bank.utils;

import kata.bank.domain.model.Account;

import java.math.BigDecimal;


public class AccountProvider {

    final static String  IBAN ="FR1420041010050500013M02606";
    private static final double INITIAL_BALANCE = 100.00;

    public static Account getCreatedAccount() {
        return new Account(IBAN, BigDecimal.valueOf(INITIAL_BALANCE));
    }
}
