package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.University;
import com.musala.spring_microservice.repository.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaUniversityListener {

    private final UniversityRepository universityRepository;

    public KafkaUniversityListener(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @KafkaListener(groupId = "university", topics = "saveUniversity")
    public void handleUniversitySave(University university) {
        System.out.println("University received: " + university.toString());
        University uni = new University();
        uni.setId(university.getId());
        uni.setName(university.getName());
        uni.setLocation(university.getLocation());
        try {
            this.universityRepository.save(uni);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "university", topics = "deleteUniversity")
    public void handleUniversityDelete(int universityId) {
        System.out.println("University ID received: " + universityId);
        try {
            this.universityRepository.deleteById(universityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
