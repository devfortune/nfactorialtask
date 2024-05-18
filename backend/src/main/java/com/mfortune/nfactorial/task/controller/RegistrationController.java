package com.mfortune.nfactorial.task.controller;

import com.mfortune.nfactorial.task.domain.Registration;
import com.mfortune.nfactorial.task.domain.User;
import com.mfortune.nfactorial.task.service.RegistrationService;
import com.mfortune.nfactorial.task.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

//    @PostMapping
//    public Registration createRegistration(@RequestBody Registration registration) {
//        return registrationService.createRegistration(registration);
//    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        registration.setUser(user);
        System.out.println("Создание бронирования: " + registration);
        return registrationService.createRegistration(registration);
    }

//    @PostMapping
//    public Registration createRegistration(@RequestBody Registration registration, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
//        // Log headers for debugging
//        System.out.println("Headers: ");
//        request.getHeaderNames().asIterator().forEachRemaining(header -> System.out.println(header + ": " + request.getHeader(header)));
//
//        // Log the token
//        String token = request.getHeader("Authorization");
//        System.out.println("Token: " + token);
//
//        // Proceed with registration
//        return registrationService.createRegistration(registration);
//    }
}
