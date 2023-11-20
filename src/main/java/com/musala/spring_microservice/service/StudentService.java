package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(int id);

    List<Student> getAllStudents();

}
