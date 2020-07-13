package kg.easy.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.LOCKED)
public class UserIsNotActive extends RuntimeException {

    public UserIsNotActive(String message) {
        super(message);
    }
}
