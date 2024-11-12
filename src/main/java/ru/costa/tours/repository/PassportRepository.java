package ru.costa.tours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.costa.tours.models.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
}