package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "passports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "passport")
    private User user;
}
