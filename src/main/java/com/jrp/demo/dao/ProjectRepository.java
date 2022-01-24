package com.jrp.demo.dao;

import com.jrp.demo.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> { //the identifier we want to use is Projects and the ID is Long
    //using this crudRepository
    //we can crud data in database with it's methods (in this case minimal h2)
    public List<Project> findAll();
}
