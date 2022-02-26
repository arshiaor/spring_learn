package com.jrp.demo.dto;

public interface EmployeeProject {
    //need to have the property names begin with get (for spring)
    public String getFirstName();
    public String getLastName();
    public int getProjectCount();

}
