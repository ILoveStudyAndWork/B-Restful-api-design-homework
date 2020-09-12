package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {

    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student register(@RequestBody Student student){
        return studentService.register(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
