package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
