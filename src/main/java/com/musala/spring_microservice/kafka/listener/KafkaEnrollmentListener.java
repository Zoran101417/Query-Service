package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Course;
import com.musala.spring_microservice.model.Enrollment;
import com.musala.spring_microservice.repository.CourseRepository;
import com.musala.spring_microservice.repository.EnrollmentRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEnrollmentListener {

    private final EnrollmentRepository enrollmentRepository;

    public KafkaEnrollmentListener(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @KafkaListener(groupId = "enrollment", topics = "deleteEnrollment")
    public void handleEnrollmentDelete(int enrollmentID) {
        System.out.println("Enrollment ID received: " + enrollmentID);
        try {
            this.enrollmentRepository.deleteById((long) enrollmentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "enrollment", topics = "saveEnrollment")
    public void handleEnrollmentSave(Enrollment enrollment) {
        System.out.println("Enrollment received: " + enrollment);
        Enrollment enrol = new Enrollment();
        enrol.setId(enrollment.getId());
        enrol.setCourse(enrollment.getCourse());
        enrol.setStudent(enrollment.getStudent());
        try {
            this.enrollmentRepository.save(enrol);
        } catch (Exception e) {
            throw e;
        }
    }
}
