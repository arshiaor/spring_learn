package com.jrp.demo.controllers;

import com.jrp.demo.dao.EmployeeRepository;
import com.jrp.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = empRep.findAll();
        model.addAttribute("employeeList",employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/new-employee";
    }

    @Autowired
    EmployeeRepository empRep;

    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model){
        empRep.save(employee);

        return "redirect:/employees/new";
    }
}
