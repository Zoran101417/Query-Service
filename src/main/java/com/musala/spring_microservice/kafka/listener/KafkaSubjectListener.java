package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Subject;
import com.musala.spring_microservice.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaSubjectListener {

    private final SubjectRepository subjectRepository;

    public KafkaSubjectListener(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @KafkaListener(groupId = "subject", topics = "deleteSubject")
    public void handleSubjectDelete(int subjectID) {
        System.out.println("Subject ID received: " + subjectID);
        try {
            this.subjectRepository.deleteById(subjectID);
        } catch (Exception e) {
            throw e;
        }
    }

    @KafkaListener(groupId = "subject", topics = "saveSubject")
    public void handleSubject(Subject subject) {
        System.out.println("Subject received: " + subject.toString());
        Subject subj = new Subject();
        subj.setId(subject.getId());
        subj.setName(subject.getName());
        try {
            this.subjectRepository.save(subj);
        } catch (Exception e) {
            throw e;
        }
    }

}
