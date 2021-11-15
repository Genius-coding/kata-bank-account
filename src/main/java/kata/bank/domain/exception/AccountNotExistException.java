package kata.bank.domain.exception;

public class AccountNotExistException extends IllegalArgumentException {
    public AccountNotExistException(String message) {
        super(message);
    }
}
