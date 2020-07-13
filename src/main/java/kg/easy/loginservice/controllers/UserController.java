package kg.easy.loginservice.controllers;

import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.User;
import kg.easy.loginservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserDto save(@RequestHeader("auth") String auth, @RequestBody UserDto userDto){
        return userService.createUser(auth, userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestHeader("auth") String auth, @RequestBody UserDto userDto){
        return userService.updateUser(auth, userDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@RequestHeader("auth") String auth, @PathVariable Long id){
        return userService.deactivateUser(auth, id);
    }

    @GetMapping("/find/{id}")
    public UserDto getById(@RequestHeader("auth") String auth, @PathVariable Long id){
        return userService.findUserById(auth, id);
    }

    @GetMapping("/all")
    public List<UserDto> findAllUsers(@RequestHeader("auth") String auth){
        return userService.findAllUsers(auth);
    }
}
