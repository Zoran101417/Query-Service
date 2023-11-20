package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Course;
import com.musala.spring_microservice.model.Grade;
import com.musala.spring_microservice.repository.GradeRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaGradeListener {
    private final GradeRepository gradeRepository;

    public KafkaGradeListener(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }


    @KafkaListener(groupId = "grade", topics = "deleteGrade")
    public void handleGradeDelete(int gradeId) {
        System.out.println("Grade ID received: " + gradeId);
        try {
            this.gradeRepository.deleteById((long) gradeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "grade", topics = "saveGrade")
    public void handleGradeSave(Grade grade) {
        System.out.println("Grade received: " + grade);
        Grade grade1 = new Grade();
        grade1.setId(grade.getId());
        grade1.setGrade(grade.getGrade());
        grade1.setEnrollment(grade.getEnrollment());
        try {
            this.gradeRepository.save(grade1);
        } catch (Exception e) {
            throw e;
        }
    }
}
