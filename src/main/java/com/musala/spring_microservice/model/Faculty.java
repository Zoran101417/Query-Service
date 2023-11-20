package com.musala.spring_microservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name="universityID")
    private University university;
    @Column(name = "universityID", insertable = false, updatable = false)
    private int universityID;
    private int seq = 1;

}
