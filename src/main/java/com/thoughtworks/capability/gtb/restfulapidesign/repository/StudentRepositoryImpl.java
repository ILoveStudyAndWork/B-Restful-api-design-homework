package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private static List<Student> students = null;

    public StudentRepositoryImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public int count() {
        return students.size()+1;
    }

    @Override
    public Student save(Student registerStu) {
        students.add(registerStu);
        return registerStu;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findAny()
                .orElse(null);
    }


}
