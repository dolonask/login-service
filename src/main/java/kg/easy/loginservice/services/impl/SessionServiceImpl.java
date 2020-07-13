package kg.easy.loginservice.services.impl;

import kg.easy.loginservice.dao.SessionRepository;
import kg.easy.loginservice.exceptions.IncorrectPassword;
import kg.easy.loginservice.exceptions.SessionNotFound;
import kg.easy.loginservice.exceptions.UserIsNotActive;
import kg.easy.loginservice.mappers.SessionMapper;
import kg.easy.loginservice.mappers.UserMapper;
import kg.easy.loginservice.models.dto.SessionDto;
import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.Session;
import kg.easy.loginservice.services.PasswordService;
import kg.easy.loginservice.services.SessionService;
import kg.easy.loginservice.services.UserService;
import kg.easy.loginservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserService userService;
    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public SessionDto appendNewSession(UserDto userDto) {

        closeSession(userDto);

        Session session = new Session();
        session.setStartDate(new Date());
        session.setEndDate(DateUtil.AddMinutesToDate(new Date(), 5));
        session.setUser(UserMapper.INSTANCE.userDtoToUser(userDto));
        session.setToken(UUID.randomUUID().toString());
        session = sessionRepository.save(session);

        return SessionMapper.INSTANCE.sessionToSessionDto(session);
    }

    @Override
    public boolean closeSession(UserDto userDto) {

        Session session = sessionRepository.findByUserAndEndDateIsAfter(UserMapper.INSTANCE.userDtoToUser(userDto), new Date());

        if (session != null){
            session.setEndDate(new Date());
            sessionRepository.save(session);
        }

        return true;
    }

    @Override
    public SessionDto logIn(String login, String password) {

        UserDto userDto = userService.findUserByLogin(login);

        if (!userDto.isActive()){
            throw new UserIsNotActive("Пользователь не активен!");
        }

        password = passwordService.generatePassword(password);

        if (!userDto.getAccount().getPassword().equals(password)){
            throw new IncorrectPassword("Неверный пароль!");
        }

        return appendNewSession(userDto);
    }

    @Override
    public boolean closeSession(String auth) {
        Session session = sessionRepository.findByToken(auth);

        if (session != null){
            session.setEndDate(new Date());
            session = sessionRepository.save(session);
        }
        return true;
    }

    @Override
    public SessionDto findSessionByToken(String token) {
        Session session = sessionRepository.findByToken(token);

        if (session == null){
            throw new SessionNotFound("Сессия не найдена!");
        }

        session.setEndDate(DateUtil.AddMinutesToDate(new Date(),5));
        session = sessionRepository.save(session);

        return SessionMapper.INSTANCE.sessionToSessionDto(session);
    }

}
