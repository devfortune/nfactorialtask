package com.mfortune.nfactorial.task.repository;

import com.mfortune.nfactorial.task.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
