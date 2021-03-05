package com.hcl.foodfinder.controllers;

import com.hcl.foodfinder.model.User;
import com.hcl.foodfinder.model.UserRepository;
import com.hcl.foodfinder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userService.register(user);
        userRepository.save(user);
    }

}
