package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "query/api/faculty", produces = MediaType.APPLICATION_JSON_VALUE)
public class FacultyController {

    private final Logger LOG = LogManager.getLogger(FacultyController.class);

    private final                                                                                                                                                           FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllFaculty() {
        return ResponseEntity.status(HttpStatus.OK).body(facultyService.getAllFaculties());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFacultyById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(facultyService.getFacultyById(id));
    }

}
