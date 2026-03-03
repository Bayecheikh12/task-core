# Task Core

A Spring Boot application for task management built with Java 17.

## 🚀 Features

- Task management system
- RESTful API endpoints
- MySQL database integration
- Spring Boot 3.5.11
- Maven build system

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.5.11**
- **Spring Data JPA**
- **MySQL Connector**
- **Maven**

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+ 
- MySQL 8.0+

## 🚀 Quick Start

1. Clone the repository:
```bash
git clone https://github.com/Bayecheikh12/task-core.git
cd task-core
```

2. Configure your MySQL database in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_core
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```

4. The application will be available at `http://localhost:8080`

## 📦 Build

To build the application:
```bash
mvn clean package
```

To run tests:
```bash
mvn test
```

## 🗄️ Database

The application uses MySQL as the database. Make sure to create the database before starting the application.

## 📚 API Documentation

API endpoints will be available at `http://localhost:8080` once the application is running.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Baye Cheikh**
- GitHub: [@Bayecheikh12](https://github.com/Bayecheikh12)

## 🙏 Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
