package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> getAllGrades();
    Optional<Grade> getGradeById(int id);
}
