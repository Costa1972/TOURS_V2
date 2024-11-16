package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "paiments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pmnt_basis_id", referencedColumnName = "id")
    private PaymentBasis paymentBasis;
}
