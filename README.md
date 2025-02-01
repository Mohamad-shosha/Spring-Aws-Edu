# ✨ SpringAWSEdu

This project showcases the powerful integration of **Spring MVC** with **Java Persistence API (JPA)**, utilizing **Hibernate** for efficient Object-Relational Mapping (ORM). Now deployed on **AWS** using **Elastic Beanstalk**, **EC2**, **RDS**, **IAM**, **VPC Security**, and more.

## ✨ Key Features:
- **Seamless Backend Integration**: Effortlessly manage and query data with a robust backend framework.
- **Advanced AWS Deployment**: Hosted on AWS using Elastic Beanstalk, EC2, and RDS, ensuring high availability and scalability.
- **Core Entities**:
  - **Instructor**: Manage instructor details and associated courses.
  - **Address**: Handle address information for instructors and courses.
  - **Course**: Organize and maintain course offerings and their related entities.
- **Database Schema Management**: Leverage **Liquibase** to manage database versioning and migrations, ensuring smooth transitions during updates.
- **API Testing**: Utilize **Postman** as a client for testing API endpoints, making it easy to verify and validate the functionality of your application.
- **Enhanced Security**: 
  - Secure roles and permissions with **IAM Roles**.
  - Use **AWS Systems Manager Parameter Store** for securely storing database credentials.
  - Implement **Spring Profiles** for environment-specific configurations (**dev, prod**), improving security and maintainability.
- **Docker Integration**: Easily deploy using Docker with pre-configured containerization support.
- **Scalable & Secure Architecture**:
  - Utilize **VPC Security Groups** to control network access.
  - **Route 53 Integration** for a custom domain setup.
- **Performance Optimization**: Utilize caching, connection pooling, and optimized database queries for high efficiency.
- **MVC Architecture**: Utilize a clean and organized *Model-View-Controller* architecture for clear separation of concerns.
- **Dynamic Web Pages**: Render interactive and dynamic web pages with *Thymeleaf*.
- **CRUD Operations**: Perform *Create, Read, Update, and Delete* operations for Instructor, Address, and Course entities.

With this setup, you can efficiently build and maintain a robust, secure, and scalable application tailored to your data management needs!

## 📝 Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Technologies](#technologies)
- [Demo](#demo)
- [Docker](#docker)
- [AWS Deployment](#aws-deployment)
- [Deployment Process](#deployment-process)
- [Security Enhancements](#security-enhancements)
- [Resources](#resources)

## 🎥 Demo

[Watch the demo video here](https://drive.google.com/drive/folders/1Z7WG3Q52P4SGVnE3FR706UXGT05RHmjF)

## 🐙 Docker

To push your Docker image to Docker Hub, use the following command:

```bash
docker push your-docker-repo/spring-mvc-app:latest
```

## 🌐 AWS Deployment

The project is now deployed on AWS using the following services:
- **Elastic Beanstalk**: Automates the deployment process.
- **EC2**: Provides scalable computing resources.
- **RDS (MySQL)**: Secure and managed database service.
- **IAM Roles**: Controls access permissions.
- **VPC Security**: Restricts network access.
- **Route 53**: Custom domain setup.

## 🚀 Deployment Process

### Step 1: Build the JAR File
Run the following command to build the project:
```bash
mvn clean package -DskipTests
```

### Step 2: Upload the JAR File to AWS
Use AWS Elastic Beanstalk CLI or AWS Management Console to upload the JAR file.
```bash
ew deploy --application-name my-spring-app --environment-name my-env --version-label v1 --source-bundle myapp.jar
```

### Step 3: Monitor Deployment
Monitor the deployment logs on AWS Elastic Beanstalk to ensure successful deployment.

### Step 4: Test the Application
Access your deployed application at:
```bash
http://your-app-env.elasticbeanstalk.com
```

### Step 5: Set Up Route 53
To associate a custom domain with your application:
1. Purchase a domain from AWS Route 53.
2. Create a new hosted zone in Route 53.
3. Configure an **A record** to point to the Elastic Beanstalk environment.
4. Update the domain settings to reflect the new changes.
5. Verify the domain mapping works correctly.

## 🔒 Security Enhancements
- **AWS Parameter Store** for securely storing credentials.
- **Spring Profiles (dev, prod)** for environment-specific settings.
- **Database credentials secured via AWS Systems Manager Parameter Store**.

## 🐂 Prerequisites

Before you begin, ensure you have the following:
- *Java Development Kit (JDK 11 or later)* installed.
- *Maven* for dependency management.
- *Postman* for API testing.
- *Docker* installed for containerization.
- *AWS CLI* configured for deployment.

## 💾 Getting Started

### 🚀 Step 1: Create a Spring Boot Project

Generate a new Spring Boot project using [Spring Initializr](https://start.spring.io/) with:
- **Project**: Maven Project
- **Language**: Java
- **Spring Boot**: Latest stable version
- **Packaging**: Jar
- **Dependencies**: Spring Web, Spring Data JPA, Thymeleaf, Liquibase, MySQL Driver

### 💪 Step 2: Configure Database & Liquibase

Update `application.properties`:
```properties
spring.liquibase.change-log=db/changelog/db_master_changelog.xml

# Use environment variables for security
database.url=jdbc:mysql://localhost:3307/mydb
database.username=root
database.password=shosh404@@

spring.datasource.url=${database.url}
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}
```

### 👨‍💻 Step 3: Define Entities & Repositories

Create entities for **Instructor**, **Address**, and **Course**, and define repository interfaces for each.

### 🔧 Step 4: Implement Service Layer & Controllers

Develop services to handle business logic and controllers to manage HTTP requests.

### 🎨 Step 5: Create Thymeleaf Views

Design templates for user interactions.

### 🔍 Step 6: Test Using Postman

Verify API functionality with Postman by sending **CRUD** requests.

### ▶️ Step 7: Run Your Application

Start your Spring Boot application. The server will be available at:
[http://localhost:8082](http://localhost:8082)

## 💽 Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring MVC Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc)
- [JPA and Hibernate Guide](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/)
- [Liquibase Documentation](https://www.liquibase.org/documentation/index.html)
- [Postman Documentation](https://learning.postman.com/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Docker Documentation](https://docs.docker.com/get-started/)
- [AWS Documentation](https://docs.aws.amazon.com/)
