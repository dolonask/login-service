package kg.easy.loginservice.controllers;

import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @PostMapping("/save")
    public UserDto save(@RequestHeader("auth") String auth, @RequestBody UserDto userDto){

        return null;
    }

    @PutMapping("/update")
    public UserDto update(@RequestHeader("auth") String auth, @RequestBody UserDto userDto){
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@RequestHeader("auth") String auth, @PathVariable Long id){
        return true;
    }

    @GetMapping("/find/{id}")
    public UserDto getById(@RequestHeader("auth") String auth, @PathVariable Long id){
        return null;
    }

    @GetMapping("/all")
    public List<UserDto> findAllUsers(@RequestHeader("auth") String auth){
        return null;
    }
}
