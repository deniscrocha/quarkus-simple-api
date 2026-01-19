package rocha.denis.exception;

public class LoginValidationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Invalid login";

    public LoginValidationException() {
        super(ERROR_MESSAGE);
    }
}
