package kg.easy.loginservice.services.impl;

import kg.easy.loginservice.models.responses.SessionInfo;
import kg.easy.loginservice.services.PasswordService;
import kg.easy.loginservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private PasswordService passwordService;
    @Override
    public SessionInfo logIn(String login, String password) {


        return null;
    }
}
