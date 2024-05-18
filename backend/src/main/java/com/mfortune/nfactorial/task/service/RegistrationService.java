package com.mfortune.nfactorial.task.service;

import com.mfortune.nfactorial.task.domain.Event;
import com.mfortune.nfactorial.task.domain.Registration;
import com.mfortune.nfactorial.task.repository.EventRepository;
import com.mfortune.nfactorial.task.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository;

        public Registration createRegistration(Registration registration) {
            Event event = eventRepository.findById(registration.getEvent().getId()).orElseThrow(() -> new IllegalStateException("Event not found"));
            if (event.getAvailableTickets() >= registration.getReservedSeats()) {
                event.setAvailableTickets(event.getAvailableTickets() - registration.getReservedSeats());
                eventRepository.save(event);
                return registrationRepository.save(registration);
            } else {
                throw new IllegalStateException("Недостаточно билетов, попробуйте уменьшить количество!");
            }
        }
}
