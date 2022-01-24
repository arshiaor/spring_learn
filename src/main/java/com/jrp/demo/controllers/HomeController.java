package com.jrp.demo.controllers;

import com.jrp.demo.dao.EmployeeRepository;
import com.jrp.demo.dao.ProjectRepository;
import com.jrp.demo.entities.Employee;
import com.jrp.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping("/")
    public String displayhome(Model model){
        List<Project> projects=proRepo.findAll();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("projectsList",projects);
        model.addAttribute("employeeList",employees);
        return "main/home";
    }
}
