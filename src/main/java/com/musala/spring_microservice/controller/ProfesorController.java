package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.ProfesorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("query/api/professor")
public class ProfesorController {

    private final Logger LOG = LogManager.getLogger(ProfesorController.class);

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProfessor() {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.getAllProfesors());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProfessorById(@PathVariable int id) {
       return ResponseEntity.status(HttpStatus.OK).body(profesorService.getProfesorById(id));
    }
}

