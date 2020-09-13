package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {

    int count();

    Student save(Student registerStu);

    List<Student> findAll();

    Student findById(int id);

    List<Student> findByGender(String gender);

    void deleteById(int id);
}
