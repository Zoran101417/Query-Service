package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
