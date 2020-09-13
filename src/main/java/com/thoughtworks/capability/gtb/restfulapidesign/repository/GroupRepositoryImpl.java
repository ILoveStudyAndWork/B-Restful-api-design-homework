package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository{
    private final static int GROUP_SIZE = 6;
    private static List<Group> groups = null;
    public GroupRepositoryImpl() {
        groups = new ArrayList<>();
        for (int i = 1; i <= GROUP_SIZE ;i++){
            Group group = new Group(i ,"Team " + i,new ArrayList<>(), "Team " + i);
            groups.add(group);
        }
    }

    @Override
    public List<Group> findAll() {
        return groups;
    }

    @Override
    public Group findById(int id) {
        return groups.stream().filter(group -> group.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Group save(Group targetGroup) {
        Group groupIfExist = groups.stream()
                .filter(group -> group.getId() == targetGroup.getId())
                .findAny()
                .get();
        groupIfExist.setStudentList(targetGroup.getStudentList());
        return groups.stream()
                .filter(group -> group.getId() == targetGroup.getId())
                .findAny()
                .get();
    }

    @Override
    public void reSet() {
        for (int i = 0; i < GROUP_SIZE ;i++){
            groups.get(i).getStudentList().clear();
        }
    }

}
