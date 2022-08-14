# HumanResourcesManagementSystem
Human Resources Management System Java Spring Boot Project.
- This project is a Java Spring Boot project developed for [kodlama.io](https://www.kodlama.io/) Bootcamp homework.

<div id="badges" align="left">
  <a href="https://www.java.com/tr/">
    <img src="https://img.shields.io/badge/Java-fb5607?style=for-the-badge&logo=Java&logoColor=white" alt="Java Badge"/>
  </a>
   <a href="https://spring.io/">
    <img src="https://img.shields.io/badge/Spring-8ac926?style=for-the-badge&logo=Spring&logoColor=white" alt="Spring Badge"/>
  <a href="https://www.postgresql.org/">
    <img src="https://img.shields.io/badge/PostgreSQL-0081a7?style=for-the-badge&logo=PostgreSQL&logoColor=white" alt="PostgreSQL Badge"/>
  </a>
</div>

--------------------------------------------------------------

### Create Java Spring Boot Project
Go To [Spring Initializr](https://start.spring.io/)
  
<img src="https://user-images.githubusercontent.com/67970973/182492368-52f8fce9-ad60-46e2-9794-7e978be2cd58.png" width="600" />
 
## Entities Package
Our system has three basic types of users. System Staff, Candidates and Employers.
Based on these requirements, I created my [User](https://github.com/Minecakir/HumanResourcesManagementSystem/blob/master/src/main/java/com/example/hrms/entities/concretes/User.java), 
[Employer](https://github.com/Minecakir/HumanResourcesManagementSystem/blob/master/src/main/java/com/example/hrms/entities/concretes/Employer.java) and 
[Candidate](https://github.com/Minecakir/HumanResourcesManagementSystem/blob/master/src/main/java/com/example/hrms/entities/concretes/Candidate.java) entities in my [Entity Package](https://github.com/Minecakir/HumanResourcesManagementSystem/tree/master/src/main/java/com/example/hrms/entities) for my project.
Then I continued to create my classes according to the necessary requirements.

## DataAccess Package
Let's talking about [Data Access](https://github.com/Minecakir/HumanResourcesManagementSystem/tree/master/src/main/java/com/example/hrms/dataAccess) Layer!
This layer is responsible for interacting with databases to save and restore application data.
Our basic  [Job](https://github.com/Minecakir/HumanResourcesManagementSystem/blob/master/src/main/java/com/example/hrms/entities/concretes/Job.java) entity class is simple and looks like below:
  
    public class Job {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="title")
    private String jobTitle;
    
    @OneToMany(mappedBy="jobPos")
    private List<JobAdvertisement> jobAdvertisements;
    }
It's a simple JPA entity with id field as identifier. Now comes the best part, we ofcourse need some code to store and retrieve products from database. Good news is Spring has got us covered. 
All you need to do is define a repository as below
  
    public interface JobDao extends JpaRepository<Job,Integer> {
    }
 
What Spring data jpa provides is

- **No-code repository:** It is the most popular persistence-related pattern. It enables us to implement our business code on a higher abstraction level.
- **Reduced boilerplate code:** It provides the default implementation for each method by its repository interfaces. It means that there is no longer need to implement read and write operations.
- **Generated Queries:** Another feature of Spring Data JPA is the generation of database queries based on the method name. If the query is not too complex, we need to define a method on our repository interface with the name that starts with findBy.
  
 ## Business Package
 The business layer handles all the business logic. It consists of **service classes** and uses services provided by data access layers. It also performs authorization and validation.
Example create a service class that name [JobManager](https://github.com/Minecakir/HumanResourcesManagementSystem/blob/master/src/main/java/com/example/hrms/business/concretes/JobManager.java) with the following content into it: 
  
    @Service
    public class JobManager implements JobService {
    
    private JobDao jobDao;
    
    @Autowired
    public JobManager(JobDao jobDao){
    super();
    this.jobDao = jobDao;
    }
    
    @Override
    public DataResult<List<Job>> getAll() {
    return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Jobs are listed.")
    }
    
    @Override
    public Result add(Job job) {
    this.jobDao.save(job);
    return new SuccessResult("Job position is added.");
    }
   }
  
## Controllers Package
After this, let's build the Spring REST Controller class to display the service to the client or end-user and evaluate input validation for the application:
The resource has representations like XML, HTML, and JSON. The current state capture by representational resource. When we request a resource, we provide the representation of the resource. The important methods of HTTP are:

- **GET:** It reads a resource.
- **PUT:** It updates an existing resource.
- **POST:** It creates a new resource.
- **DELETE:** It deletes the resource.

HTTP also defines the following standard status code:
- **404:** RESOURCE NOT FOUND
- **200:** SUCCESS
- **201:** CREATED
- **401:** UNAUTHORIZED
- **500:** SERVER ERROR

#### Implementing the POST Method to create Job Resource
  
In the previous few steps, we have created simple RESTful services. In this section, we will use the POST method to post the user resource for the specific URI "/api/jobs."
Here we are using two annotations, **@RequestBody** and **@PostMapping**.

<details>
<summary>@RequestBody</summary>
<br>
The @RequestBody annotation maps body of the web request to the method parameter. The body of the request is passed through an HttpMessageConverter.
Optionally, automatic validation can be applied by annotating the argument with @Valid.
</details>
  
        @RestController
        @RequestMapping("/api/jobs")
        public class JobsController {
        
        private JobService jobService;
        
        @Autowired
        public JobsController(JobService jobService){this.jobService = jobService;}
        
        @GetMapping("/getAll")
        public DataResult<List<Job>> getAll(){return this.jobService.getAll();}
        
        @PostMapping("/addJob")
        public Result add(@RequestBody Job job) {
        return this.jobService.add(job);
        }   
       }
 
<div id="postman" align="center">
  <img src="https://user-images.githubusercontent.com/67970973/184484747-c16ba6fa-666c-4abe-b8ac-a0fa06afedab.png" width="300" />
</div>
  
--------------------------------------------------------------
  
**GET METHOD**
  
http://localhost:8080/api/jobs/getAll
  
<img src="https://user-images.githubusercontent.com/67970973/184486079-eb0d07c6-f874-4e41-9702-10a4bc0b9d33.png" width="600" />

**POST METHOD**

http://localhost:8080/api/jobs/addJob

<img src="https://user-images.githubusercontent.com/67970973/184489788-5e59f4d9-37cf-4fcf-b318-03fea9bce7a4.png" width="600" />

<h1 align="center">PROJECT DETAILS</h1>
  
 ### PROJECT REQUIREMENTS 🎯
  
<details>
<summary>CLICK TO LIST REQUIREMENTS</summary>
<br>

<details>
  <summary>Req-1</summary>
  <br>
  
  **Req 1: Canidadates should be able to register in the system.**

Accept conditions:

- During registration, the user is asked for name, surname, tcno, year of birth, e-mail, password, password repeat information.

- All fields are required. The user is informed.
- Mernis verification is done and the system is registered.
- If the validation is not valid, the user is notified.
- If there is a previously registered e-mail or tcno, the registration will not take place. The user is informed.
- Email verification is required for registration to occur.
  
    <details>
     <summary>Test</summary>
     <br>
      
     - **All Fields are Required**
      
     <img src="https://user-images.githubusercontent.com/67970973/184493143-d6d38a5b-16ca-49fd-9a98-c2c2a747cf89.png" width="600" />
      
     - **Add Candidate with name, surname, tcno, year of birth, e-mail, password**
      
     <img src="https://user-images.githubusercontent.com/67970973/184493624-86c46658-a48e-45f2-9209-8ad0f6c5739d.png" width="600" />
     
     - **Previously Registered**
     
     <img src="https://user-images.githubusercontent.com/67970973/184493688-8b0d4d8e-9b71-424d-889b-931b1bd93a6e.png" width="600" />
  </details>
</details>
  
<details>
  <summary>Req-2</summary>
  <br>
  
  **Req 2: Employers should be able to register in the system.**

Accept conditions:

- During registration, the user is asked for company name, website, e-mail with the same domain as the website, phone, password, password repeat information. The purpose here is to prevent non-companies from joining the system.
- All fields are required. The user is informed.
- Company records are verified in two ways. Email verification is required for registration to occur. Approval from HRMS staff (our :)) is required.
- If there is a previously registered e-mail, the registration will not take place. The user is informed.
  <details>
     <summary>Test</summary>
     <br>
      
     - **All Fields are Required**
    
     <img src="https://user-images.githubusercontent.com/67970973/184494383-e1455aa1-0230-41b3-8248-cc2ad1767fdc.png" width="600" />
      
     - **Add Employer with company name, website, e-mail**

     <img src="https://user-images.githubusercontent.com/67970973/184494276-dda12787-ed85-4f02-a3a7-5de57ffa52f4.png" width="600" />
     
     - **Previously Registered E-mail**

     <img src="https://user-images.githubusercontent.com/67970973/184494321-2544414b-1a78-4221-8259-c9772e5ef0f7.png" width="600" />
  </details>
</details>
  
<details>
  <summary>Req-3</summary>
  <br>
  
  **Req 3: General job position names should be added to the system. For example Software Developer, Software Architect.**

Accept conditions:

- These positions cannot be repeated. The user is warned.
  <details>
     <summary>Test</summary>
     <br>
      
     - **Add Job Position**
      
     <img src="https://user-images.githubusercontent.com/67970973/184489788-5e59f4d9-37cf-4fcf-b318-03fea9bce7a4.png" width="600" />
     
     - **Positions Cannot Be Repeated**
      
     <img src="https://user-images.githubusercontent.com/67970973/184494769-aa9c1196-a11e-4bf5-8a29-8577dba52d11.png" width="600" />
  </details>
</details>
  
<details>
  <summary>Req-4</summary>
  <br>
  
  **Req 4: Employers should be able to be listed. (Whole list only)**
    <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184498383-25ea2bea-1672-4b76-b831-7ecc17fd8f74.png" width="600" />
  </details>
</details>

  <details>
    <summary>Req-5</summary>
    <br>
  
  **Req 5: Candidates should be able to be listed. (Whole list only)**
  
  <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184498633-9f3c7ee1-b604-40fe-a089-c23eb9b5644b.png" width="600" />
  </details>
  </details>

  <details>
   <summary>Req-6</summary>
   <br>

  **Req 6 : Job positions should be listed. (Whole list only)**

  <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184492941-71e655ea-931f-405b-b969-09a47665a6f2.png" width="600" />
  </details>
  </details>

  <details>
  <summary>Req-7</summary>
  <br>

  **Req 7: Employers should be able to add job advertisement to the system.**
      
  In the job posting form;
      
- General job position can be selected from the dropdown list. (For example, Java Developer) (Required)
- Job description entry should be possible. (For example; For our company, he is proficient in languages ​​such as JAVA, C #, etc....)(Required)
- City information should be able to be selected from the drop-down list. (Compulsory)
- It should be possible to enter min-max for the salary scale. (Optional)
- It should be possible to enter the number of open positions. (Compulsory)
- The application deadline must be entered.
 <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184532623-82f39b02-8c98-4073-a6ba-dd7af4972d28.png" width="600" />
  </details>
  </details>
  
  <details>
  <summary>Req-8</summary>
  <br>

  **Req 8 : All active job postings in the system should be listed.**
      
  - The list should come in tabular form.
  - Company name, general job position name, number of open positions, publication date, deadline should be in the list.
 <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184532738-bc94ebe6-5a58-4ac8-b4d3-bc3332070aab.png" width="600" />
  </details>
  </details>

  <details>
  <summary>Req-9</summary>
  <br>

  **Req 9 : All active job postings in the system should be listed by date.**
      
  - The list should come in tabular form.
  - Company name, general job position name, number of open positions, publication date, deadline should be in the list.
 <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184532829-a51b8a23-9638-4a0c-8ffc-42f3e054f90b.png" width="600" />
  </details>
  </details>

  <details>
  <summary>Req-10</summary>
  <br>

  **Req 10: All active job postings of a company should be listed in the system.**
      
  - The list should come in tabular form.
  - Company name, general job position name, number of open positions, publication date, deadline should be in the list.
 <details>
     <summary>Test</summary>
     <br>
     <img src="https://user-images.githubusercontent.com/67970973/184532913-5f302d0f-934e-4bbe-8aa8-1ea7a7dbdfaf.png" width="600" />
  </details>
  </details>
  
  <details>
  <summary>Req-11</summary>
  <br>

  **Req 11 : Employers should be able to close a posting in the system. (Passive posting)**
      
 <details>
     <summary>Test</summary>
     <br>
   
   - **Deactivate job adveritsement with job id**
   
   <img src="https://user-images.githubusercontent.com/67970973/184532999-f776a715-54d3-408c-a144-91fdb23705d1.png" width="600" />
   
   - **Job advertisement is deactivated**
   
   <img src="https://user-images.githubusercontent.com/67970973/184533081-43496305-2bef-49e1-9b98-c6eb8f5c58d9.png" width="600" />
   
  </details>
  </details>
  
  <details>
  <summary>Req-12</summary>
  <br>

  **Req 12: Candidates should be able to enter their CV into the system.**
      
  - Candidates should be able to add their schools to the system. (School name, department)
  - These schools should be able to enter the years they studied in the system.
  - If he has not graduated, the graduation year should be blank.
  - The schools attended by the candidates should be in reverse order according to the graduation year. If not graduated, this school should be displayed at the top and as "in progress".
  - Candidates should be able to enter their work experience. (Business name, position)
  - They should be able to enter into the system in which years they have done this experience.
  - If he is still working, the year of leaving should be blank.
  - Candidates' experience should be in reverse order by year. If it is still running, this experience should still be displayed at the top and "in progress".
  - Candidates should be able to enter the foreign languages ​​they know into the system. ( Language, Level -> 1-5)
  - Candidates must be able to enter photos into the system. The photo of the candidate will be kept in the https://cloudinary.com/pricing system. (External service integration) Use the free account.
  - Candidates should be able to enter their github addresses into the system.
  - Candidates should be able to enter their linkedin addresses into the system.
  - Candidates should be able to enter the programming languages ​​or technologies they know into the system. (Programming/Technology name) For example; React
  - Candidates should be able to add a cover letter to the system. (For example: I like working very much....)
  </details>
  

 </details>
  
## Database
  
![Untitled (4)](https://user-images.githubusercontent.com/67970973/184476729-e91b46bd-c3b8-4b6a-a053-6f7a1e2cc659.png)
