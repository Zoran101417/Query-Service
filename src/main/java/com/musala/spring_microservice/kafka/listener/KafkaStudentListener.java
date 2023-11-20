package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Student;
import com.musala.spring_microservice.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaStudentListener {

    private final StudentRepository studentRepository;

    public KafkaStudentListener(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(id = "student", topics = "deleteStudent")
    public void handleStudentDelete(int studentId) {
        System.out.println("Student ID received: " + studentId);
        try {
            this.studentRepository.deleteById(studentId);
        } catch (Exception e) {
            throw e;
        }
    }

    @KafkaListener(groupId = "student", topics = "saveStudent")
    public void handleStudent(Student student) {
        System.out.println("Student received: " + student.toString());
        Student std = new Student();
        std.setId(student.getId());
        std.setName(student.getName());
        std.setLname(student.getLname());
        std.setFaculty(student.getFaculty());
        std.setYears(student.getYears());
        try {
            this.studentRepository.save(std);
        } catch (Exception e) {
            throw e;
        }
    }
}
