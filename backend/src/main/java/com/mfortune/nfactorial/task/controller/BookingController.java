package com.mfortune.nfactorial.task.controller;

import com.mfortune.nfactorial.task.domain.Booking;
import com.mfortune.nfactorial.task.domain.User;
import com.mfortune.nfactorial.task.service.BookingService;
import com.mfortune.nfactorial.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Booking> getBookings(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return bookingService.findByUser(user);
    }

    @PostMapping("/{eventId}")
    public Booking createBooking(@PathVariable Long eventId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return bookingService.createBooking(user, eventId);
    }

    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername())
                        .orElseThrow(() -> new NoSuchElementException("User not found"));
        bookingService.cancelBooking(user, bookingId);
    }
}

