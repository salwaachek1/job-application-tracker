package com.salwa.jobtracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String position;

    @Column(length = 1000)
    private String description;

    private LocalDate appliedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        APPLIED,
        INTERVIEWING,
        OFFER,
        REJECTED
    }
}
