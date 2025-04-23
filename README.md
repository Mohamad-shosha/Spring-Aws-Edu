# ✨ SpringAWSK8sEdu

A powerful educational project demonstrating the integration of **Spring MVC** with **Java Persistence API (JPA)** and **Hibernate** for Object-Relational Mapping (ORM). The application is deployed on **AWS** using services like **Elastic Beanstalk**, **EC2**, **RDS**, **IAM**, **VPC Security**, and enhanced with **Kubernetes (K8s)** for advanced container orchestration and scaling.

---

## ✨ Key Features

- **Robust Backend Framework**: Efficiently manage and query data using a clean Spring MVC architecture.
- **Advanced AWS Deployment**: Host the application on AWS with Elastic Beanstalk, EC2, and RDS for scalability and reliability.
- **Kubernetes Integration**: Utilize Kubernetes for containerized application management, load balancing, rolling updates, and auto-scaling.
- **Database Schema Management**: Manage database changes using **Liquibase** for smooth migrations and version control.
- **API Testing**: Test all API endpoints seamlessly using **Postman**.
- **Secure Infrastructure**:
  - IAM roles and policies for controlled access.
  - **AWS Systems Manager Parameter Store** for securely managing environment secrets and database credentials.
  - **Spring Profiles** for environment-specific configurations.
- **Docker Support**: Full containerization with Docker images for consistent, portable deployments.
- **Scalable & Secure Network**:
  - **VPC Security Groups** to restrict network traffic.
  - **Route 53 Integration** for custom domain setup.
- **Performance Optimization**: Improved caching, connection pooling, and optimized database queries.
- **MVC Architecture**: Clean separation of concerns between Models, Views, and Controllers.
- **Dynamic Web Pages**: Build interactive pages with **Thymeleaf**.
- **Full CRUD Functionality**: Create, Read, Update, and Delete operations for core entities like **Instructor**, **Course**, and **Address**.

---

## 📝 Table of Contents

- Key Features
- Prerequisites
- Getting Started
- Technologies Used
- Demo
- Docker Usage
- AWS Deployment
- Kubernetes Deployment
- Deployment Process
- Security Enhancements
- Resources

---

## 🎥 Demo

[Watch the full demo here](https://drive.google.com/drive/folders/1Z7WG3Q52P4SGVnE3FR706UXGT05RHmjF)

---

## 🐙 Docker Usage

Build and push your Docker image to your Docker Hub repository.

---

## 🌐 AWS Deployment

The project is deployed on AWS using:
- **Elastic Beanstalk**: Automates deployment and scaling.
- **EC2**: Virtual server hosting.
- **RDS (MySQL)**: Managed relational database service.
- **IAM**: Access management.
- **VPC Security Groups**: Control inbound/outbound traffic.
- **Route 53**: Custom domain mapping.

---

## ☸️ Kubernetes Deployment

**Kubernetes** is used to manage Docker containers with:
- **Deployments**: Control replica sets and application versions.
- **Services**: Expose your app within the cluster or to the internet.
- **ConfigMaps & Secrets**: Manage environment configs and credentials securely.
- **Rolling Updates & Auto-scaling**: Seamless updates and horizontal scaling.

The application can be deployed on:
- **Amazon EKS (Elastic Kubernetes Service)** or
- **Minikube (for local testing)**
# 💻 **Access Minikube Dashboard**

You can manage and monitor your local Kubernetes cluster via the Minikube Dashboard. The dashboard provides a graphical interface to interact with and inspect your cluster resources.

### 1. **Minikube Dashboard**

The Minikube Dashboard helps you visualize and manage your Kubernetes resources with ease. Here's how you can access it:

[Minikube Dashboard](https://github.com/Mohamad-shosha/Spring-Aws-Edu/issues/1#issue-3012444637)
![436319062-2c146dcc-a869-4667-8aba-990137374c04](https://github.com/user-attachments/assets/049210a8-dccf-476a-bcb3-7211d23f8cc4)

Basic steps:
- Containerize your Spring Boot application.
- Define Kubernetes deployment and service configurations.
- Apply manifests via `kubectl`.
- Use Horizontal Pod Autoscaler for scaling.
- Expose your service via a LoadBalancer or Ingress controller.

---

## 🚀 Deployment Process

**Build & Package**
- Build the application using Maven.

**Upload & Deploy**
- Upload your JAR file to AWS Elastic Beanstalk or build Docker images and deploy via Kubernetes.

**Monitor**
- Track logs and performance via AWS Console and Kubernetes dashboard.

**Testing**
- Validate application functionality with Postman.

**Domain Setup**
- Configure a custom domain via AWS Route 53 pointing to your service.

---

## 🔒 Security Enhancements

- Use **AWS Parameter Store** to securely manage database and environment credentials.
- Configure **Spring Profiles** for `dev`, `prod`, and `staging` environments.
- Restrict database and API access using **IAM Roles** and **VPC Security Groups**.
- Enforce HTTPS and security headers in production environments.

---

## 🐂 Prerequisites

- **Java Development Kit (JDK 11 or later)**
- **Maven**
- **Docker**
- **Postman**
- **AWS CLI**
- **kubectl** (Kubernetes CLI)
- Optional: **Minikube** for local Kubernetes testing

---

## 💾 Getting Started

1. Create a new Spring Boot project via [Spring Initializr](https://start.spring.io/).
2. Add required dependencies: Spring Web, Spring Data JPA, Liquibase, Thymeleaf, MySQL Driver.
3. Configure database credentials in `application.properties`.
4. Define core entities and repositories.
5. Build service and controller layers.
6. Create Thymeleaf views.
7. Test using Postman.
8. Build the application and deploy to AWS or Kubernetes.

---

## 📖 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [AWS Documentation](https://docs.aws.amazon.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)
- [Docker Documentation](https://docs.docker.com/)
- [Liquibase Documentation](https://www.liquibase.org/documentation)
- [Postman Documentation](https://learning.postman.com/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)

---

## ✅ Summary

With **SpringAWSK8sEdu**, you gain a real-world, cloud-ready backend project combining modern backend frameworks, cloud services, Docker, and Kubernetes orchestration — all structured with clean MVC principles, secure deployment, and scalable cloud infrastructure.
