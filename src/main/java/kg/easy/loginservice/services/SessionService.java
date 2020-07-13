package kg.easy.loginservice.services;

import kg.easy.loginservice.models.dto.SessionDto;
import kg.easy.loginservice.models.dto.UserDto;

public interface SessionService {

    SessionDto appendNewSession(UserDto userDto);
    boolean closeSession(UserDto userDto);
    SessionDto logIn(String login, String password);
    boolean closeSession(String auth);
    SessionDto findSessionByToken(String token);
}
