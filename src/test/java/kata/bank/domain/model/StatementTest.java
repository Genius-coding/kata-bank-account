package kata.bank.domain.model;

import kata.bank.domain.repository.TransactionRepository;
import kata.bank.infrastructure.repository.TransactionRepositoryInMemory;
import kata.bank.utils.TransactionProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class StatementTest {
    final static String  IBAN ="FR1420041010050500013M02606";
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp(){
        transactionRepository = new TransactionRepositoryInMemory();
    }

    @Test
    public void showStatementsBetweenTwoDates(){
        TransactionProvider.addTransactionsBetweenDates(transactionRepository, LocalDate.of(2021,04,03),  LocalDate.of(2021,10,03));
        Statement statement = Statement.of(LocalDate.of(2021,04,03),
                                           LocalDate.of(2021,10,03),
                                           transactionRepository.getListTransactionsBetweenDates(IBAN,
                                                   LocalDate.of(2021,04,03),
                                                   LocalDate.of(2021,10,03)));
        statement.printStatement();
    }


}
