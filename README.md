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
Albums
- **Retrieve all albums**
  - `GET /albums`
  - Description: Fetch a list of all albums in the database.

- **Add a new album**
  - `POST /albums`
  - Description: Add a new album to the database.
  - Request Body:
    ```json
    {
      "title": "string",
      "artist": "string",
      "genre": "string",
      "releaseYear": "number"
    }
    ```

- **Update an album by ID**
  - `PUT /albums/{id}`
  - Description: Update an existing album's details using its ID.
  - Request Body:
    ```json
    {
      "title": "string",
      "artist": "string",
      "genre": "string",
      "releaseYear": "number"
    }
    ```

- **Delete an album by ID**
  - `DELETE /albums/{id}`
  - Description: Remove an album from the database by its ID.
 
 ### Artists Endpoints

- **Retrieve all artists**
  - `GET /artists`
  - Description: Fetch a list of all artists in the database.

- **Add a new artist**
  - `POST /artists`
  - Description: Add a new artist to the database.
  - Request Body:
    ```json
    {
      "name": "string",
      "genre": "string",
      "debutYear": "number"
    }
    ```

- **Update an artist by ID**
  - `PUT /artists/{id}`
  - Description: Update an existing artist's details using their ID.
  - Request Body:
    ```json
    {
      "name": "string",
      "genre": "string",
      "debutYear": "number"
    }
    ```

- **Delete an artist by ID**
  - `DELETE /artists/{id}`
  - Description: Remove an artist from the database by their ID.
