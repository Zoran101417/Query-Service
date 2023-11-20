package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Student;
import com.musala.spring_microservice.repository.StudentRepository;
import com.musala.spring_microservice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getReferenceById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}
