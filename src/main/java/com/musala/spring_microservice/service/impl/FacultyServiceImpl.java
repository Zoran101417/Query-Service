package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Faculty;
import com.musala.spring_microservice.repository.FacultyRepository;
import com.musala.spring_microservice.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty getFacultyById(int id) {
        return facultyRepository.getReferenceById(id);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
