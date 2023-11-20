package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(int id);
}
