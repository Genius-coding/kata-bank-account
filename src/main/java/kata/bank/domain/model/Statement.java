package kata.bank.domain.model;
import java.time.LocalDate;
import java.util.List;

public class Statement {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<Transaction> transactions ;


    public Statement(LocalDate startDate, LocalDate endDate, List<Transaction> transactions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactions = transactions;
    }


    private void printTransaction(Transaction transaction) {
        System.out.println("Transaction Type : " + transaction.getTransactionType() +
                "|Date : " + transaction.getDate() +
                "|Amount : " + transaction.getAmount() +
                "|Balance : " + transaction.getBalance());
    }

    public void printStatement(){
        transactions.forEach(transaction -> printTransaction(transaction));
    }

    public static Statement of(LocalDate startDate, LocalDate endDate, List<Transaction> transactions) {
        return new Statement(startDate,endDate, transactions);
    }
}
