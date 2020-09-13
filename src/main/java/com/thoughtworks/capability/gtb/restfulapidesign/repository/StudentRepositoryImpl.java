package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> students = null;

    public StudentRepositoryImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public int count() {
        return students.size();
    }

    @Override
    public Student save(Student student) {
        Optional<Student> studentExist = students.stream()
                .filter(stu -> stu.getId() == student.getId())
                .findAny();
        if (studentExist.isPresent()) {
            Student stuUpdate = studentExist.get();
            stuUpdate.setGender(student.getGender());
            stuUpdate.setName(student.getName());
            stuUpdate.setNote(student.getNote());
        } else {
            students.add(student);
        }

        return students.stream()
                .filter(stu -> stu.getId() == student.getId())
                .findAny()
                .orElse(null);
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

    @Override
    public List<Student> findByGender(String gender) {
        return students.stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        Student studentToBeDelete = students.stream()
                .filter(student -> student.getId() == id)
                .findAny()
                .get();
        students.remove(studentToBeDelete);
    }
}
