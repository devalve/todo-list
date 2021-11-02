package com.project.mdsspring.controller;

import com.project.mdsspring.dto.registration.UserRegistrationInfoDto;
import com.project.mdsspring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String registration(@RequestBody UserRegistrationInfoDto userRegistrationInfoDto) {
        return userService.register(userRegistrationInfoDto);
    }
}
