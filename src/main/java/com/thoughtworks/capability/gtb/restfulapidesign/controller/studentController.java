package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentListEmptyException;
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
    public List<Student> getStudents(@RequestParam(required = false) String gender){
        return studentService.getStudents(gender);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PatchMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){
        return studentService.updateStudent(id,student);
    }

    @PostMapping("/students/groups")
    public List<Group> GroupStudent() throws StudentListEmptyException {
        return studentService.groupStudent();
    }

    @PatchMapping("/students/groups/{id}")
    public Group updateStudent(@RequestBody Group group,@PathVariable int id){
        return studentService.updateGroup(id,group);
    }

    @GetMapping("/students/groups")
    public List<Group> getStudentGroup(){
        return studentService.getGroupStudent();
    }

}
