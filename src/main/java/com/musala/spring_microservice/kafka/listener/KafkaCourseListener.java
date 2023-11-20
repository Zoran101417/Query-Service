package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Course;
import com.musala.spring_microservice.model.Faculty;
import com.musala.spring_microservice.repository.CourseRepository;
import com.musala.spring_microservice.repository.FacultyRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaCourseListener {
    private final CourseRepository courseRepository;

    public KafkaCourseListener(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @KafkaListener(groupId = "course", topics = "deleteCourse")
    public void handleCourseDelete(int courseId) {
        System.out.println("Course ID received: " + courseId);
        try {
            this.courseRepository.deleteById((long) courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "course", topics = "saveCourse")
    public void handleCourseSave(Course course) {
        System.out.println("Course received: " + course);
        Course cour = new Course();
        cour.setId(course.getId());
        cour.setName(course.getName());
        cour.setDescription(course.getDescription());
        try {
            this.courseRepository.save(cour);
        } catch (Exception e) {
            throw e;
        }
    }

}
