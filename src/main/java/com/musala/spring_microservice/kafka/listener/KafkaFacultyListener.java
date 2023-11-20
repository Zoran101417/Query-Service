package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Faculty;
import com.musala.spring_microservice.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaFacultyListener {

    private final FacultyRepository facultyRepository;

    public KafkaFacultyListener(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @KafkaListener(groupId = "faculty", topics = "deleteFaculty")
    public void handleFacultyDelete(int facultyId) {
        System.out.println("Faculty ID received: " + facultyId);
        try {
            this.facultyRepository.deleteById(facultyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "faculty", topics = "saveFaculty")
    public void handleFacultySave(Faculty faculty) {
        System.out.println("Faculty received: " + faculty);
        Faculty fac = new Faculty();
        fac.setId(faculty.getId());
        fac.setName(faculty.getName());
        fac.setUniversity(faculty.getUniversity());
        try {
            this.facultyRepository.save(fac);
        } catch (Exception e) {
            throw e;
        }
    }
}
