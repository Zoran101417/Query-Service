package com.musala.spring_microservice.kafka.listener;

import com.musala.spring_microservice.model.Profesor;
import com.musala.spring_microservice.repository.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProfesorListener {

    private final ProfesorRepository profesorRepository;

    public KafkaProfesorListener(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @KafkaListener(groupId = "professor", topics = "saveProfesor")
    public void handleProfesor(Profesor profesor) {
        System.out.println("Profesor received: " + profesor.toString());
        try {
            this.profesorRepository.save(profesor);
        } catch (Exception e) {
            throw e;
        }
    }

    @KafkaListener(groupId = "professor", topics = "deleteProfesor")
    public void handleProfesorDelete(int profesorID) {
        System.out.println("Profesor ID received: " + profesorID);
        try {
            this.profesorRepository.deleteById(profesorID);
        } catch (Exception e) {
            throw e;
        }
    }
}
