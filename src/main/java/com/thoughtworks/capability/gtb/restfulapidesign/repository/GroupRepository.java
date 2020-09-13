package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository {

    List<Group> findAll();

    Group findById(int id);

    Group save(Group targetGroup);

    void reSet();
}
