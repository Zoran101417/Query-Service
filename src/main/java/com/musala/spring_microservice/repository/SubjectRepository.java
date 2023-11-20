package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
