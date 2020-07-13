package kg.easy.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SessionNotFound extends RuntimeException {

    public SessionNotFound(String message) {
        super(message);
    }
}
