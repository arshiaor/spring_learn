package com.jrp.demo.dao;

import com.jrp.demo.dto.EmployeeProject;
import com.jrp.demo.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    public List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount"+
            " FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id"+
            " GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects(); //find how many projects each employee has been signed to
}
