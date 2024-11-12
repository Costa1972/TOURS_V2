package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "payment_basis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentBasis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "paymentBasis")
    private Payment payment;
}
