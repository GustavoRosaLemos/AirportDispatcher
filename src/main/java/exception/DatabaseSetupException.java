package exception;

public class DatabaseSetupException extends Exception {
    public DatabaseSetupException(String errorMessage) {
        super(errorMessage);
    }
}
