Version Updates:<br>
##version 1.0.0<br>
Project created using H2 temporary Databse , spring Boot and requst mappings.<br>
ih this version we can perform CRUD on Employees and Projects and we learned to use Thymeleaf in our HTML pages.<br>
----
##version 1.0.1<br>
One to many and many To one relations with annotations discussed.<br>
Each project can have many Employees <br>
workig on it. so we created List of Employees in Project with getters&setters and project is created in Employees.<br>
>Note! the name that @OnetoMany is mapped by in Projects.java, must be equal to the instance of Project class that we created in Employee class.<br>
>
-----
##version 1.1.0<br>
The ability to assign multiple Employees have been added to create-project page.<br>
Cascades have been discussed in @ManyToOne (in class Emloyees).<br>
The problem was in the DB tables that the employee_ID isn't updated so it was solved by getting chosen employees from url and math them with the project foreign key.<br>
-------
##version 1.1.1<br>
in this version we added Many-To-Many relations between employee and project classes.<br>
we used @ManyToMany annotation for this and used CASCADE options for both classes because we have to save changes for both in many to many relationship.<br>
we used @JoinTable in both classes to create a join table for this relationship<br>
>we should note JoinColumn and InverseJoinColumns property in both classes <br>
###Important note! <br>
>we do not use an instance of Project in class Employee because the relation is Many-To-many
>so we should use List of Projects, because of this in the projectController.java , the lines with Iterable and for-each Loop is deleted.<br> 