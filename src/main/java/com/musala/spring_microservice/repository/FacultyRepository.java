package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
