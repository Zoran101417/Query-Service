package com.musala.spring_microservice.service;

import com.musala.spring_microservice.model.Profesor;

import java.sql.SQLException;
import java.util.List;

public interface ProfesorService {

    Profesor getProfesorById(int id);

    List<Profesor> getAllProfesors();

}
