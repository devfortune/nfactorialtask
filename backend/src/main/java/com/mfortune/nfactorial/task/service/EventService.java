package com.mfortune.nfactorial.task.service;

import com.mfortune.nfactorial.task.domain.Event;
import com.mfortune.nfactorial.task.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return repository.findById(id);
    }

    public Event saveEvent(Event event) {
        return repository.save(event);
    }
}
