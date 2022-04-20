package com.redi.demo.controller;

import com.redi.demo.repository.UserRepository;
import com.redi.demo.repository.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/user/{email}")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public User get(@PathVariable final String email ) {
        return userRepository.findById(email).get();
    }
}
