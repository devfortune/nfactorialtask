package com.mfortune.nfactorial.task.eventmanagement;

import com.mfortune.nfactorial.task.domain.Event;
import com.mfortune.nfactorial.task.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private EventRepository repository;

    // Начальный список мероприятий. Захардходил.

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 5, 20), LocalTime.of(18, 00), "Алматы", "проспект Абылай Хана 83", 350));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 6), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 7), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 8), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 9), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 10), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 11), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "BeeLine BootCamp", LocalDate.of(2024, 6, 12), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 13), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 14), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 15), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 16), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 17), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 18), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 19), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("IT Camp", "Nfactorial BootCamp", LocalDate.of(2024, 6, 20), LocalTime.of(9, 00), "Алматы", "Satbayev University", 75));
        repository.save(new Event("Концерт", "Концерт Prince", LocalDate.of(2024, 5, 25), LocalTime.of(18, 00), "Алматы", "проспект Абылай Хана 83", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 5, 26), LocalTime.of(18, 00), "Астана", "EXPO", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 5, 27), LocalTime.of(18, 00), "Шымкент", "ул. Ленина", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 6, 20), LocalTime.of(18, 00), "Караганда", "проспект Абылай Хана 83", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 7, 15), LocalTime.of(18, 00), "Кокшетау", "проспект Абылай Хана 83", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 7, 16), LocalTime.of(18, 00), "Алматы", "проспект Абылай Хана 83", 350));
        repository.save(new Event("Концерт", "Концерт Hiro", LocalDate.of(2024, 9, 19), LocalTime.of(18, 00), "Алматы", "проспект Абылай Хана 83", 350));
    }
}
