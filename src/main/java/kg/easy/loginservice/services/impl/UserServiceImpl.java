package kg.easy.loginservice.services.impl;

import kg.easy.loginservice.dao.UserRepository;
import kg.easy.loginservice.exceptions.UserNotFound;
import kg.easy.loginservice.mappers.UserMapper;
import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.User;
import kg.easy.loginservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findUserByLogin(String login) {

        User user = userRepository.findUserByLogin(login);

        if (user == null){
            throw new UserNotFound("Учетная запись не найдена!");
        }

        return UserMapper.INSTANCE.userToUserDto(user);
    }
}
