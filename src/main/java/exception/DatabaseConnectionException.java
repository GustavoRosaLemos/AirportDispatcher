package exception;

public class DatabaseConnectionException extends Exception{
    public DatabaseConnectionException(String errorMessage) {
        super(errorMessage);
    }
}
