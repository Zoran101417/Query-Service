package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.EnrollmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "query/api/enrollment", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnrollmentController {

    private final Logger LOG = LogManager.getLogger(EnrollmentController.class);

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllEnrollments() {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.getAllEnrollments());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEnrollmentById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.getEnrollmentById(id));
    }
}
