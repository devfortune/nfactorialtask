package com.mfortune.nfactorial.task.repository;

import com.mfortune.nfactorial.task.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
