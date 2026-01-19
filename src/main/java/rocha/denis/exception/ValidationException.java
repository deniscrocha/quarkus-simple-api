package rocha.denis.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String field, String reason) {
        super("Invalid field: " +
            field +
            " " +
            reason);
    }
}
