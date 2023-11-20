package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
