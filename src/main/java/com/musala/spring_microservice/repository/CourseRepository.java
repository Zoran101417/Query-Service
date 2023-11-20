package com.musala.spring_microservice.repository;


import com.musala.spring_microservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
