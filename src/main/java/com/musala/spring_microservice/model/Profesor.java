package com.musala.spring_microservice.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="ID")
@Data
@NoArgsConstructor
@ToString
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    private String name;
    private String lname;
    @ManyToOne
    @JoinColumn(name="facultyId")
//    @JsonBackReference
    private Faculty faculty;
    @OneToOne
    @JoinColumn(name="subjectId")
    private Subject subject;
    private int seq = 1;
}
