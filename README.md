# 🏦 SDFC Banking Application

A full-stack Banking Management System developed using **Java, Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA, Hibernate, and MySQL**. This project simulates real-world banking operations such as account creation, deposits, withdrawals, fund transfers, and balance inquiries while following a layered architecture and industry best practices.

---

## 📌 Project Overview

The SDFC Banking Application is designed to provide secure and efficient banking services through a user-friendly web interface. It demonstrates the implementation of core banking functionalities using modern Java technologies and follows the MVC architecture for better maintainability and scalability.

---

## 🚀 Features

### Current Features

- ✅ Open New Bank Account
- ✅ Deposit Money
- ✅ Withdraw Money
- ✅ Transfer Funds Between Accounts
- ✅ Check Account Balance
- ✅ Search Account Details
- ✅ Form Validation
- ✅ Exception Handling
- ✅ Responsive UI with Thymeleaf
- ✅ Layered Architecture (Controller → Service → Repository)
- ✅ Database Integration using MySQL

---

## 🛠️ Technology Stack

### Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Maven

### Frontend

- Thymeleaf
- HTML5
- CSS3
- JavaScript

### Database

- MySQL

### Tools

- Eclipse / Spring Tool Suite
- VS Code
- Git
- GitHub
- Maven
- Postman

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.sdfc.bank
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── dto
│   │       ├── exception
│   │       ├── util
│   │       └── config
│   │
│   └── resources
│       ├── templates
│       ├── static
│       └── application.properties
│
└── test
```

---

## ⚙️ Installation & Setup

### Clone Repository

```bash
git clone https://github.com/GhadgePradip9971/your-repository-name.git
```

### Navigate to Project

```bash
cd your-repository-name
```

### Configure Database

Create a MySQL database.

```sql
CREATE DATABASE sdfc_bank;
```

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sdfc_bank
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

or

Run the project directly from Eclipse / STS.

---

## 📷 Screens

- Home Page
- Open Account
- Deposit
- Withdraw
- Transfer
- Balance Enquiry
- Search Account

*(Screenshots will be added soon.)*

---

## 🏛️ Application Architecture

```
Browser
    │
    ▼
Spring MVC Controller
    │
    ▼
Service Layer
    │
    ▼
Repository (Spring Data JPA)
    │
    ▼
MySQL Database
```

---

## 🔒 Validation

The application uses Bean Validation annotations such as:

- @NotBlank
- @NotNull
- @Pattern
- @Email
- @DecimalMin

---

## 📈 Future Enhancements

### Security

- Spring Security
- Customer Login
- Admin Login
- Role-Based Authorization
- BCrypt Password Encryption
- Forgot Password
- Change Password

### Banking Features

- Transaction History
- Mini Statement
- Passbook
- Account Statement (PDF)
- Beneficiary Management
- Scheduled Transfers
- Fixed Deposit Module
- Loan Management
- Interest Calculation

### Notifications

- Email Alerts
- OTP Verification
- Transaction Notifications

### Reports

- PDF Export
- Excel Export
- Printable Statements

### REST API

- RESTful APIs
- Swagger/OpenAPI Documentation
- Postman Collection

### Performance

- Spring Cache
- Logging
- Spring Boot Actuator
- Monitoring

### Deployment

- Docker
- Docker Compose
- Railway
- Render
- AWS EC2

### Additional Improvements

- Audit Logs
- Pagination & Sorting
- Search Filters
- Dashboard Analytics
- Dark Mode
- Responsive Bootstrap UI
- Unit & Integration Testing
- Global Exception Handling

---

## 📚 Learning Objectives

This project demonstrates practical implementation of:

- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Thymeleaf
- Bean Validation
- Layered Architecture
- MVC Design Pattern
- CRUD Operations
- Database Integration
- Exception Handling

---

## 👨‍💻 Author

**Pradip Ghadge**

Java Full Stack Developer

📍 Pune, Maharashtra

GitHub: https://github.com/GhadgePradip9971

LinkedIn: https://www.linkedin.com/in/pradip-ghadge

Email: pradipghadge17@gmail.com

---

## ⭐ Future Vision

This project is continuously evolving into a production-ready Internet Banking System by incorporating modern Java technologies, secure authentication, REST APIs, cloud deployment, monitoring, testing, and enterprise-level best practices.

---

## 📄 License

This project is developed for educational, learning, and portfolio purposes.
