package com.musala.spring_microservice.repository;

import com.musala.spring_microservice.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Integer> {

}
