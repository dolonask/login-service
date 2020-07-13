package kg.easy.loginservice.services.impl;

import kg.easy.loginservice.dao.UserRepository;
import kg.easy.loginservice.exceptions.ResourceNotFoundException;
import kg.easy.loginservice.mappers.AccountMapper;
import kg.easy.loginservice.mappers.UserMapper;
import kg.easy.loginservice.models.dto.AccountDto;
import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.User;
import kg.easy.loginservice.services.AccountService;
import kg.easy.loginservice.services.SessionService;
import kg.easy.loginservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private AccountService accountService;

    @Override
    public UserDto findUserByLogin(String login) {

        User user = userRepository.findUserByLogin(login);

        if (user == null){
            throw new ResourceNotFoundException("Учетная запись не найдена!");
        }

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto createUser(String auth, UserDto userDto) {

        UserDto naviUser = sessionService.findSessionByToken(auth).getUser();

        AccountDto accountDto = accountService.createAccount(userDto.getAccount());
        userDto.setAccount(accountDto);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        user = userRepository.save(user);


        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(String auth, UserDto userDto) {

        UserDto naviUser = sessionService.findSessionByToken(auth).getUser();

        UserDto currUserDto = findUserById(userDto.getId());

        AccountDto accountDto = accountService.updateAccount(userDto.getAccount());
        userDto.setAccount(accountDto);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);


        user = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Пользователь не найден!"));
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public boolean deactivateUser(String auth, Long userId) {

        UserDto userDto = findUserById(userId);

        userDto.setActive(false);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);
        return !user.isActive();
    }



    @Override
    public List<UserDto> findAllUsers() {
        List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC,"active","name"));
        return UserMapper.INSTANCE.usersToUserDtos(list);
    }

    @Override
    public UserDto findUserById(String auth, Long id) {
        UserDto naviUser = sessionService.findSessionByToken(auth).getUser();
        return findUserById(id);
    }

    @Override
    public List<UserDto> findAllUsers(String auth) {
        UserDto naviUser = sessionService.findSessionByToken(auth).getUser();
        return findAllUsers();
    }
}
