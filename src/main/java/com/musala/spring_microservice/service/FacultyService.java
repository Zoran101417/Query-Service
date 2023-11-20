package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty getFacultyById(int id);

    List<Faculty> getAllFaculties();

//    List<Faculty> getAllFacultiesByUniversityId(int universityID);

}
