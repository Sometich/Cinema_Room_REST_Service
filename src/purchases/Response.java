package purchases;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Response extends RuntimeException {
    private String error;

    public Response() {
    }

    public Response(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }

    public void setMessage(String error) {
        this.error = error;
    }
}
