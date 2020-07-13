package kg.easy.loginservice.controllers;

import kg.easy.loginservice.models.dto.SessionDto;
import kg.easy.loginservice.models.entities.Session;
import kg.easy.loginservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/session")
public class SessionController {


    @Autowired
    private SessionService sessionService;

    @GetMapping("/auth")
    public SessionDto auth(@RequestParam String login, @RequestParam String password){
        return sessionService.logIn(login, password);
    }

    @GetMapping("/out")
    public boolean logOut(@RequestHeader("auth") String auth){
        return sessionService.closeSession(auth);
    }

    public boolean checkSession(@RequestHeader("auth") String auth){
        return sessionService.findSessionByToken(auth) != null;
    }




}
