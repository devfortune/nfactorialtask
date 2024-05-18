package com.mfortune.nfactorial.task.service;

import com.mfortune.nfactorial.task.domain.Booking;
import com.mfortune.nfactorial.task.domain.Event;
import com.mfortune.nfactorial.task.domain.User;
import com.mfortune.nfactorial.task.repository.BookingRepository;
import com.mfortune.nfactorial.task.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Booking> findByUser(User user) {
        return bookingRepository.findByUser(user);
    }
    public Booking createBooking(User user, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Неправильный ID билета"));
        if (event.getAvailableTickets() > 0) {
            event.setAvailableTickets(event.getAvailableTickets() - 1);
            eventRepository.save(event);
            Booking booking = new Booking(user, event);
            return bookingRepository.save(booking);
        } else {
            throw new IllegalStateException("Нет доступных билетов");
        }
    }

    public void cancelBooking(User user, Long bookingId) {
        Booking booking = bookingRepository.findByIdAndUser(bookingId, user);
        if (booking != null) {
            Event event = booking.getEvent();
            event.setAvailableTickets(event.getAvailableTickets() + 1);
            eventRepository.save(event);
            bookingRepository.delete(booking);
        } else {
            throw new IllegalStateException("Бронирование не найдено");
        }
    }
}
