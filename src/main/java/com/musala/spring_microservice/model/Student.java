package com.musala.spring_microservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    private String name;
    private String lname;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Faculty.class)
    @JoinColumn(name = "facultyID")
    @JsonBackReference
    private Faculty faculty;
    private int years;
    private int seq = 1;

}
