package dev.shadmanahmed.foodfinder.services;

import dev.shadmanahmed.foodfinder.model.User;
import dev.shadmanahmed.foodfinder.model.UserRepository;
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
