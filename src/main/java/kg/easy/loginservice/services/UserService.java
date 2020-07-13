package kg.easy.loginservice.services;

import kg.easy.loginservice.exceptions.ResourceNotFoundException;
import kg.easy.loginservice.models.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findUserByLogin(String login) throws ResourceNotFoundException;

    UserDto createUser(String auth, UserDto userDto);

    UserDto updateUser(String auth, UserDto userDto);

    UserDto findUserById(Long id);

    boolean deactivateUser(String auth, Long userId);

    List<UserDto> findAllUsers();

    UserDto findUserById(String auth, Long id);

    List<UserDto> findAllUsers(String auth);
}
