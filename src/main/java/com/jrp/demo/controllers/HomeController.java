package com.jrp.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.demo.dao.EmployeeRepository;
import com.jrp.demo.dao.ProjectRepository;
import com.jrp.demo.dto.ChartData;
import com.jrp.demo.dto.EmployeeProject;
import com.jrp.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping("/")
    public String displayhome(Model model) throws JsonProcessingException {
        Map<String , Object> map = new HashMap<>();
        List<Project> projects=proRepo.findAll();
        model.addAttribute("projectsList",projects);

        List<ChartData>projectData = proRepo.getprojectStatus();

        //lets convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // [["notStarted",1], ["INPROGRESS",2], ["COMPLETED",1]]

        model.addAttribute("projectStatusCnt",jsonString);

        //we are querying database for employees
        List<EmployeeProject> employeesProjectsCnt = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCnt", employeesProjectsCnt);
        return "main/home";
    }
}
