package kg.easy.loginservice.services;

import kg.easy.loginservice.models.responses.SessionInfo;

public interface SessionService {

    SessionInfo logIn(String login, String password);
}
