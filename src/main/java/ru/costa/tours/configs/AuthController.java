package ru.costa.tours.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.costa.tours.services.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "Welcome ";
    }
}
