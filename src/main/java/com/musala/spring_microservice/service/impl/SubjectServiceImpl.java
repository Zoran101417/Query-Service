package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Subject;
import com.musala.spring_microservice.repository.SubjectRepository;
import com.musala.spring_microservice.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject getSubjectById(int id) {
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
