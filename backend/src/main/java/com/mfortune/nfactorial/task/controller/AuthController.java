package com.mfortune.nfactorial.task.controller;

import com.mfortune.nfactorial.task.domain.User;
import com.mfortune.nfactorial.task.domain.UserLogin;
import com.mfortune.nfactorial.task.domain.UserSignup;
import com.mfortune.nfactorial.task.security.JwtHelper;
import com.mfortune.nfactorial.task.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserSignup signupUser) throws Exception {
        User user = userService.signup(signupUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLogin userLogin) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        String token = JwtHelper.generateToken(userLogin.getUsername());
        return ResponseEntity.ok(token);
    }

}
