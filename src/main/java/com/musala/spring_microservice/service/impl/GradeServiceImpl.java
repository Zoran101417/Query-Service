package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Grade;
import com.musala.spring_microservice.repository.GradeRepository;
import com.musala.spring_microservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGradeById(int id) {
        return gradeRepository.findById((long) id);
    }

}
