package com.musala.spring_microservice.service.impl;

import com.musala.spring_microservice.model.Course;
import com.musala.spring_microservice.repository.CourseRepository;
import com.musala.spring_microservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById((long) id);
    }

}
