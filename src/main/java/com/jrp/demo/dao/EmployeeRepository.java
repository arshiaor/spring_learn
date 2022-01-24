package com.jrp.demo.dao;

import com.jrp.demo.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    public List<Employee> findAll();
}
