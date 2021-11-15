package kata.bank.infrastructure.repository;

import kata.bank.domain.model.Transaction;
import kata.bank.utils.TransactionProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryInMemoryTest {
    final static String  IBAN ="FR1420041010050500013M02606";

    private TransactionRepositoryInMemory transactionRepository;

    @BeforeEach
    public void setUp(){
        transactionRepository = new TransactionRepositoryInMemory();
        TransactionProvider.addTransactions(transactionRepository);
    }

    @Test
    public void findListOfTransactionsByIban(){
        final List<Transaction> transactionList =transactionRepository.getAccountTransactionsByIban(IBAN);
        assertNotNull(transactionList);
        assertEquals(transactionList.size(), 2);
    }

}
