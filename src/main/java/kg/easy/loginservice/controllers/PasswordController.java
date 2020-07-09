package kg.easy.loginservice.controllers;

import kg.easy.loginservice.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/v1/pwd")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;
    @GetMapping("/generate")
    public String generatePassword(@RequestParam String password){
        return passwordService.generatePassword(password);
    }
}
