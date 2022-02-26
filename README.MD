Version Updates:<br>

##  version 1.0.0 <br>

Project created using H2 temporary Databse , spring Boot and requst mappings.<br>
in this version we can perform CRUD on Employees and Projects and we learned to use Thymeleaf in our HTML pages.<br>
----
## version 1.0.1<br>
One to many and many To one relations with annotations discussed.<br>
Each project can have many Employees <br>
workig on it. so we created List of Employees in Project with getters&setters and project is created in Employees.<br>
>Note! the name that @OnetoMany is mapped by in Projects.java, must be equal to the instance of Project class that we created in Employee class.<br>
>
-----
## version 1.1.0<br>


The ability to assign multiple Employees have been added to create-project page.<br>
Cascades have been discussed in @ManyToOne (in class Emloyees).<br>
The problem was in the DB tables that the employee_ID isn't updated so it was solved by getting chosen employees from url and math them with the project foreign key.<br>
-------
## version 1.1.1<br>
in this version we added Many-To-Many relations between employee and project classes.<br>
we used @ManyToMany annotation for this and used CASCADE options for both classes because we have to save changes for both in many to many relationship.<br>
we used @JoinTable in both classes to create a join table for this relationship<br>
>we should note JoinColumn and InverseJoinColumns property in both classes <br>
### Important note! <br>
>we do not use an instance of Project in class Employee because the relation is Many-To-many
>so we should use List of Projects, because of this in the projectController.java , the lines with Iterable and for-each Loop is deleted.<br>
---------
## version 1.1.2<br>
we seed database info so that we will not need to create emps and projs everytime we deploy application.<br>
we use @Bean annotation for using this is ProjectManagementApplication.java <br>
--------
## version 1.1.3<br>
In this version we got rid of @Bean and other codes and instead created a data.sql file to instantiate tables on start.<br>
### Important Note!
####By default, data.sql scripts are now run before Hibernate is initialized. so this cuases errors to solve them put this snippet in Application.properties:

>spring.jpa.defer-datasource-initialization=true

------
## Version 1.1.3.1 <br>
we encoutered an error in previous version during creating a new employee because the generation strategy with **GenerationType.AUTO** (in Employee.java)
creates an employee with primary key starting from 1 but there is already an emp with primary key 1 in data.sql so it creates a conflict. <br>
To solve this problem we should use **GenerationType.IDENTITY** in the scope. <br>
By doing this the primary key for new employees will be set by observing tables not by hibernate.<br>

-----
## Version 1.1.4 <br>
In this version we want to add java script pie chart from chartsjs.org and displaye info,First we create javascript file in static/js.<br>
Then in home.html we used new div to put the chart and used the <script> tag to use the js file.<br>
After that, we used some bootstrap in home.html to have a beautiful scenery of names and projects and etc<br>
Then the big changes came ! we wanted to show how manyt projects are the employees involved in. so to do this we should not use **findAll()** method
in the **EmployeeRepository.java**, so we should insert out own query. To do this we use **@Query()** annotation on the method **employeeProjects()** <br>
then we make an interface in dto(data transfer object) folder named as **Employeeproject.java** to have the property values of this method (employeeProjects) in it.<br>
> Note! we should use get with every property in dto interfaces! example: getFirstname(), getAge(),etc <br>

After making all these changes we go to **Homecontroller.java** and we use **empRepo.employeeProjects()** instead of **empRepo.findAll()** . <br>
 after that we go to **home.html** to edit and replace the email with project count. and it is Done!.<br>
 
 ------
 
## Version 1.1.4.1 <br>
in this part we want to query the status of the projects<br>
to do this, we first go to **ProjectRepository.java** to create our own annotation of @Query on the method
**getprojectStatus()** that contains of a List from **ChartData.java** interface. <br>
after hat we create our interface in dto folder <br>
we want to throw the data to the java script pie chart to show <br>
Then, we go to **HomeController.java** and create a **List<Chartdata>** that is equal to the output of method **empRepo.getprojectStatus()** <br>
to convert the data to JSON to easily use it in javascript file . to do this,
we use **ObjectMapper** class from jackson, and use the **objectMapper.writeValueAsString(projectData)** 
method to do this and then we save it into a String which in my case it's **jsonString** <br>
After ll these we use **model.addAttributes("project StatusCnt", jsonString)** to send it to javascript file. <br>
