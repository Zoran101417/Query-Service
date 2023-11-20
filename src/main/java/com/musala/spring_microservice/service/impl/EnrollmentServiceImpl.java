package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Enrollment;
import com.musala.spring_microservice.repository.EnrollmentRepository;
import com.musala.spring_microservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(int id) {
        return enrollmentRepository.findById((long) id);
    }

}
