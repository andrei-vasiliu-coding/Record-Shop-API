# Record Shop API

An API built to manage a record shop's catalog of albums and artists. This project demonstrates the use of Java, Spring, and SQL for backend development.

## Features

- **CRUD Operations**: Manage records, artists, and albums.
- **Database Integration**: Fully integrated with an SQL database.
- **RESTful Endpoints**: Designed for seamless communication with front-end applications.
- **Extensible Architecture**: Built with scalability in mind using Spring Boot.

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for developing RESTful APIs.
- **SQL**: Database management and querying.
- **Postman**: (if applicable) for testing endpoints.

## Getting Started

### Prerequisites

- Java JDK 8 or higher.
- Maven or Gradle for dependency management.
- A running SQL database (setup instructions below).

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/andrei-vasiliu-coding/Record-Shop-API.git

2. Navigate to the project directory:

   '''bash
   cd Record-Shop-API

3. Configure the database connection in the application.properties file:

   spring.datasource.url=jdbc:mysql://localhost:3306/record_shop_db
   spring.datasource.username=<your_username>
   spring.datasource.password=<your_password>

4. Build and run the application:

   '''bash
   mvn spring-boot:run

### Database Setup

1. Use the provided SQL script recordShopDBSQL.sql in the project to initialize the database schema:

   mysql -u <your_username> -p < recordShopDBSQL.sql

2. Ensure the database is running and accessible.

### API Endpoints
