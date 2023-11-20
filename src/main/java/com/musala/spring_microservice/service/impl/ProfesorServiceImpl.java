package com.musala.spring_microservice.service.impl;


import com.musala.spring_microservice.model.Profesor;
import com.musala.spring_microservice.repository.ProfesorRepository;
import com.musala.spring_microservice.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Profesor getProfesorById(int id) {
        return profesorRepository.getReferenceById(id);
    }

    @Override
    public List<Profesor> getAllProfesors() {
        return profesorRepository.findAll();
    }

}
