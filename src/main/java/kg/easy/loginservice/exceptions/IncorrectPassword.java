package kg.easy.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class IncorrectPassword extends RuntimeException {

    public IncorrectPassword(String message) {
        super(message);
    }
}
