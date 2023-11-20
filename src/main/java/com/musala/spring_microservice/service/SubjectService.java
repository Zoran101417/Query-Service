package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Subject;

import java.util.List;

public interface SubjectService {

    Subject getSubjectById(int id);

    List<Subject> getAllSubjects();

}
