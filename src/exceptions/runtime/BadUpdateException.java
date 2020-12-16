package exceptions.runtime;

public class BadUpdateException extends RuntimeException{
    public BadUpdateException(String message) {
        super(message);
    }
}
