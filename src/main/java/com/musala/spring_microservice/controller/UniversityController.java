package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.exceptions.DataNotFoundException;
import com.musala.spring_microservice.model.University;
import com.musala.spring_microservice.service.UniversityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "query/api/university", produces = MediaType.APPLICATION_JSON_VALUE)
public class UniversityController {

    private final Logger LOG = LogManager.getLogger(UniversityController.class);

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<University>> getAllUniversity() {
        return ResponseEntity.status(HttpStatus.OK).body(universityService.getAllUniversity());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<University> getUniversityById(@PathVariable int id) throws Exception {

        University university = universityService.getUniversityById(id).orElseThrow(() -> new DataNotFoundException(
                String.format("University with id: %d does not exist", id)));

        return ResponseEntity.status(HttpStatus.OK).body(university);
    }


}
