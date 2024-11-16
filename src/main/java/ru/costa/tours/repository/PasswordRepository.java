package ru.costa.tours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costa.tours.models.Password;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
