package com.jrp.demo.controllers;

import com.jrp.demo.dao.ProjectRepository;
import com.jrp.demo.entities.Employee;
import com.jrp.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("project", new Project());
        return "projects/new-project";
    }

    @Autowired //we give this responsibility to spring container to inject an auto created instance of project repository and we leave it up to spring framework to create instance of this interface
    ProjectRepository proRep; //create instance to use

    @PostMapping("/save") //@RequestMapping(value="/new",method=Req... .POST)
    public String createProject(Project project,Model model){
        //this should handel saving to he database
        proRep.save(project);

        //we always use redirect to prevent duplicate submissions to database
        return "redirect:/projects/new";
    }

}
