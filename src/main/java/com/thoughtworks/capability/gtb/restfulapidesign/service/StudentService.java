package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student register(Student student) {
        Student registerStu = Student.builder()
                .id(studentRepository.count())
                .name(student.getName())
                .gender(student.getGender())
                .note(student.getNote())
                .build();
        return studentRepository.save(registerStu);
    }

    public List<Student> getStudents(String gender) {
        if (gender == null){
            return studentRepository.findAll();
        }
        else
            return studentRepository.findByGender(gender);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(int id, Student student) {
        Student updateStu = Student.builder()
                .id(id)
                .name(student.getName())
                .gender(student.getGender())
                .note(student.getNote())
                .build();
        return studentRepository.save(updateStu);
    }
}
