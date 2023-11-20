package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "query/api/subject", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectController {

    private final Logger LOG = LogManager.getLogger(SubjectController.class);

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllSubject() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getAllSubjects());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSubjectById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectById(id));
    }

}
