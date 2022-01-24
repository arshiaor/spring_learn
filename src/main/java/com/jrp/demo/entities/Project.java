package com.jrp.demo.entities;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.List;

@Entity //to let jpa know to map java objects to database tables
public class Project {

    @Id                             //we use these anotations from hibernate to assign default increasing values to project id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    private String name;

    private String stage; // NOTSTARTED, COMPLETED , INPROGRESS

    private String description;

    @OneToMany(mappedBy = "theProject")
    private List<Employee> employees;

    public Project(){}

    public Project(String name, String stage, String description) { // we do not mention id because we want java to assign default
                                                                    // value to project
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
