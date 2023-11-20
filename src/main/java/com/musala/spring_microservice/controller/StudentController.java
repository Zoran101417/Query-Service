package com.musala.spring_microservice.controller;

import com.musala.spring_microservice.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "query/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final Logger LOG = LogManager.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

}
