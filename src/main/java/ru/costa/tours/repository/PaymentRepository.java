package ru.costa.tours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.costa.tours.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
