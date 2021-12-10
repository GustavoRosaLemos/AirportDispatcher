package exception;

public class DatabaseDisconnectException extends Exception {
    public DatabaseDisconnectException(String errorMessage) {
        super(errorMessage);
    }
}
