package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.University;
import java.util.List;
import java.util.Optional;

public interface UniversityService {

    Optional<University> getUniversityById(int id);

    University getUniversityByName(String name);

    List<University> getAllUniversity();

}
