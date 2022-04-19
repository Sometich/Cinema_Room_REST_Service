package exceptions;

public class CustomException {
    private final String error;

    public CustomException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
