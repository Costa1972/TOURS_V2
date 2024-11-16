package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "passwords")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id = 1L;
    @Column(name = "content")
    private String content;
}
