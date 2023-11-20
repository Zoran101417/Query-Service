package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.GradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "query/api/grade", produces = MediaType.APPLICATION_JSON_VALUE)
public class GradeController {

    private final Logger LOG = LogManager.getLogger(GradeController.class);

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllGrades() {
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getAllGrades());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getGradeById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getGradeById(id));
    }

}
