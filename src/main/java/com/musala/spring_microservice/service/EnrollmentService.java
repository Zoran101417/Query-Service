package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Optional<Enrollment> getEnrollmentById(int id);
}
