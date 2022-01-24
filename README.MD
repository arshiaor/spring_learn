Version Updates:
##version 1.0.0
Project created using H2 temporary Databse , spring Boot and requst mappings.
ih this version we can perform CRUD on Employees and Projects and we learned to use Thymeleaf in our HTML pages.
----
##version 1.0.1
One to many and many To one relations with annotations discussed. Each project can have many Employees 
workig on it. so we created List of Employees in Project with getters&setters and project is created in Employees.
>Note! the name that @OnetoMany is mapped by in Projects.java, must be equal to the instance of Project class that we created in Employee class.
-----
##version 1.1.0
The ability to assign multiple Employees have been added to create-project page.<br>
Cascades have been discussed in @ManyToOne (in class Emloyees).<br>
The problem was in the DB tables that the employee_ID isn't updated so it was solved by getting chosen employees from url and math them with the project foreign key.
