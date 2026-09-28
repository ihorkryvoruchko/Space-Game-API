# 🚀 SpaceGame REST API

A robust backend REST API service built with **Spring Boot**, designed to support the **[SpaceGame Java Swing Client](https://github.com/ihorkryvoruchko/Space-Game)** by handling game logic, score tracking, and persistent data storage.

---

## 🛠️ Tech Stack & Architecture

- **Language:** Java
- **Framework:** Spring Boot (Spring Web, Spring Data JPA)
- **Database:** H2 / MySQL (configurable via properties)
- **Build Tool:** Maven
- **Architecture Pattern:** Controller-Service-Repository layered architecture

---

## 📂 Project Structure

```text
Space-Game-API/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/    # REST endpoints handlers
│   │   │   ├── model/         # Entity models and database tables
│   │   │   ├── repository/    # Spring Data JPA interfaces
│   │   │   └── service/       # Business logic layer
│   │   └── resources/
│   │       └── application.yml # Database and server configuration
│   └── target/                # Build output (excluded from Git)
├── .gitignore
├── pom.xml                    # Maven dependencies configuration
└── README.md