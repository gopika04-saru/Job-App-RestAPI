# 🚀 Job REST API

## 📝 Overview
This is a **Spring Boot REST API** for managing job listings and applications. It provides endpoints for CRUD operations on jobs and includes authentication, logging, validation using Aspect-Oriented Programming (AOP), and performance monitoring.

## 🌟 Features
- 🔒 **Authentication & Authorization** using Spring Security & JWT
- 📌 **CRUD Operations** for job postings
- 📝 **Logging** with SLF4J and Logback
- ✅ **Validation** using AOP
- 📊 **Performance Monitoring** with Actuator
- ⚠️ **Exception Handling** with custom error responses
- 🗄️ **Database Integration** with PostgreSQL

## 🛠️ Tech Stack
- ☕ **Java** (Spring Boot, Spring MVC, Spring Security)
- 🏛 **Spring Data JPA** (PostgreSQL, H2 for testing)
- 🔐 **JWT Authentication**
- 📦 **Maven** for dependency management
- 🧪 **Postman** for API testing

## 🔧 Setup & Installation
### 📌 Prerequisites
- Java 17+
- Maven
- PostgreSQL (or use an in-memory H2 database for testing)

### 📥 Clone the Repository
```sh
 git clone https://github.com/your-username/job-restapi.git
 cd job-restapi
```

### ⚙️ Configure Database
Modify the `application.properties` file to set up database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/job_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### ▶️ Run the Application
```sh
 mvn clean install
 mvn spring-boot:run
```

### 🐳 Running with Docker
```sh
 docker build -t job-restapi .
 docker run -p 8080:8080 job-restapi
```

## 🔗 API Endpoints
### 🔐 Authentication
| Method | Endpoint           | Description               |
|--------|-------------------|---------------------------|
| POST   | `/auth/register`  | Register a new user       |
| POST   | `/auth/login`     | Authenticate user         |

### 📌 Job Management
| Method | Endpoint             | Description            |
|--------|---------------------|------------------------|
| GET    | `/jobposts`        | Get all job postings   |
| GET    | `/jobpost/{id}`    | Get job by ID          |
| POST   | `/jobpost`         | Create a new job       |
| PUT    | `/jobpost/{id}`    | Update job details     |
| DELETE | `/jobpost/{id}`    | Delete a job           |
| GET    | `/jobposts/{keys}` | Search jobs by keywords |

## 🔒 Security
- Uses **JWT tokens** for authentication.
- Secure endpoints require a **valid JWT token**.
- Role-based access control for users.

## 🔑 Password Encryption & Storage
- User passwords are **hashed** before storing in the database.
- Uses **BCrypt** algorithm for secure password hashing.
- Ensures protection against **brute-force attacks**.

## 📊 Logging & Monitoring
- 📂 Logging with **SLF4J & Logback**.
- 📡 Performance monitoring with **Spring Boot Actuator**.
- ⚠️ Exception handling with **custom error messages**.

## 📤 Output Generation
- Job data is stored in **PostgreSQL**.
- API responses are in **JSON format**.
- Securely stored passwords with **BCrypt hashing**.

## 📦 Dependencies (`pom.xml`)
```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    
    <!-- JWT Dependency -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.11.5</version>
    </dependency>
</dependencies>
```

## 🎯 JobController (`JobController.java`)
```java
@RestController
@RequestMapping("/jobposts")
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
    
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createJob(job));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        return ResponseEntity.ok(jobService.updateJob(id, job));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{keys}")
    public List<Job> searchJobs(@PathVariable String keys) {
        return jobService.searchJobs(keys);
    }
}
```

## 🤝 Contributing
1. 🍴 Fork the repo.
2. 🛠 Create a new feature branch (`git checkout -b feature-branch`)
3. 📌 Commit changes (`git commit -m 'Add new feature'`)
4. 📤 Push to branch (`git push origin feature-branch`)
5. 🔄 Create a pull request.

## 📄 License
This project is licensed under the **MIT License**.

## 📞 Contact
For queries, contact 📧 kotakalagopika@gmail.com or visit 🌐 https://github.com/gopika04-saru.

