package com.mfortune.nfactorial.task.service;

import com.mfortune.nfactorial.task.domain.User;
import com.mfortune.nfactorial.task.domain.UserSignup;
import com.mfortune.nfactorial.task.exceptions.DuplicateException;
import com.mfortune.nfactorial.task.exceptions.PasswordsDoNotMatchException;
import com.mfortune.nfactorial.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User signup(UserSignup signupUser) {
        if (!signupUser.getPassword().equals(signupUser.getConfirmPassword())) {
            throw new PasswordsDoNotMatchException("Passwords do not match");
        }
        Optional<User> optionalUser = userRepository.findByUsername(signupUser.getUsername());
        optionalUser.ifPresent(s -> {
            throw new DuplicateException("User with username " + optionalUser.get().getUsername() + " already exists.");
        });

        User newUser = new User();
        newUser.setUsername(signupUser.getUsername());
        newUser.setPassword(passwordEncoder.encode(signupUser.getPassword()));
        newUser.setName(signupUser.getName());
        newUser.setSurname(signupUser.getSurname());
        return userRepository.save(newUser);
    }

}
