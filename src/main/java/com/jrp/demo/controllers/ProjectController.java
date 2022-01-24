package com.jrp.demo.controllers;

import com.jrp.demo.dao.EmployeeRepository;
import com.jrp.demo.dao.ProjectRepository;
import com.jrp.demo.entities.Employee;
import com.jrp.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = proRep.findAll();
        model.addAttribute("projectsList",projects);
        return "projects/list-projects";
    }




    @GetMapping("/new")        //@RequestMapping("/new")
    public String displayProjectForm(Model model){  //bind objects to that form

        List<Employee> employees = empRepo.findAll();  //this and under this line is to select employees for each project
        model.addAttribute("allEmployees",employees);

        model.addAttribute("project", new Project());
        return "projects/new-project";
    }

    @Autowired //we give this responsibility to spring container to inject an auto created instance of project repository and we leave it up to spring framework to create instance of this interface
    ProjectRepository proRep; //create instance to use


    @Autowired
    EmployeeRepository empRepo;

    @PostMapping("/save") //@RequestMapping(value="/new",method=Req... .POST)
    public String createProject(Project project,@RequestParam List<Long> employees, Model model){ //employees are the params that come with the url from the form
        //this should handel saving to he database
        proRep.save(project);


        Iterable <Employee> chosenEmployees = empRepo.findAllById(employees); //we capture those IDs

        for(Employee emp : chosenEmployees){ // then here we find that foregin key of the involved in the table
            emp.setTheProject(project);
            empRepo.save(emp);
        }



        //we always use redirect to prevent duplicate submissions to database
        return "redirect:/projects/new";
    }

}
