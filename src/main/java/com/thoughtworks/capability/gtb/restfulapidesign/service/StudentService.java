package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.RequestGroupNameEmptyException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNameExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.NoSuchStudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentListEmptyException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public Student register(Student student) {
        Student registerStu = Student.builder()
                .id(studentRepository.count() +1)
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

    public List<Group> groupStudent() throws StudentListEmptyException {
        groupRepository.reSet();
        List<Student> studentList = studentRepository.findAll();
        Collections.shuffle(studentList);
        int studentAmount = studentRepository.count();
        int targetGroupId;
        if (studentAmount == 0){
            throw new StudentListEmptyException();
        }

        for (int i = 0; i < studentAmount; i++){
            Student student = studentList.get(i);
            targetGroupId = i%6 +1;
            Group targetGroup = groupRepository.findById(targetGroupId);
            targetGroup.getStudentList().add(student);
            groupRepository.save(targetGroup);
        }

        return groupRepository.findAll();
    }

    public Group updateGroup(int id, Group group) throws Exception {
        validateGroupName(group.getGroupName());
        Group groupToBeUpdate = groupRepository.findById(id);
        groupToBeUpdate.setGroupName(group.getGroupName());
        return groupRepository.save(groupToBeUpdate);
    }

    private void validateGroupName(String groupName) throws RequestGroupNameEmptyException, GroupNameExistException {
        if (groupName == null){
            throw new RequestGroupNameEmptyException();
        }

        Optional<Group> groupExist = groupRepository.findAll()
                .stream()
                .filter(group -> groupName.equals(group.getGroupName()))
                .findAny();

        if (groupExist.isPresent()){
            throw new GroupNameExistException();
        }
    }

    public List<Group> getGroupStudent() {
        return groupRepository.findAll();
    }

    public void deleteStudentById(int id) throws NoSuchStudentException {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new NoSuchStudentException();
        }
        studentRepository.deleteById(id);
    }
}
