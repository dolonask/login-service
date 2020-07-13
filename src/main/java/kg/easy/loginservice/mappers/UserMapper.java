package kg.easy.loginservice.mappers;

import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);

    List<User> userDtosToUsers(List<UserDto> userDtos);
    List<UserDto> usersToUserDtos(List<User> users);
}
