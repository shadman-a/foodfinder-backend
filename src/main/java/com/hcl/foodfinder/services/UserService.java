package com.hcl.foodfinder.services;

import com.hcl.foodfinder.model.User;
import com.hcl.foodfinder.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void register(User user) {
        try {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }catch (Exception e) {
            e.getMessage();
        }
    }
}
