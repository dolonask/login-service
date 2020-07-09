package kg.easy.loginservice.services;

import kg.easy.loginservice.models.dto.UserDto;

public interface UserService {

    UserDto findUserByLogin(String login);
}
