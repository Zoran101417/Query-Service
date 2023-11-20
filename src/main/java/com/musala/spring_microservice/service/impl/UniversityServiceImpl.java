package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.University;
import com.musala.spring_microservice.repository.UniversityRepository;
import com.musala.spring_microservice.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public Optional<University> getUniversityById(int id) {
        return universityRepository.findById(id);
    }

    @Override
    public University getUniversityByName(String name) {
        return null;
    }

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

}
