# School Service

A Spring Boot microservice for managing school data. Provides RESTful APIs to perform CRUD operations on school entities. Designed to be part of a microservices ecosystem with support for CORS and easy integration.

## Features

- Create, read, update, and delete school records
- RESTful API endpoints for managing schools
- Cross-Origin Resource Sharing (CORS) enabled for all origins
- Uses JPA for database persistence
- Simple, clean, and extendable service layer

## API Endpoints

| Method | Endpoint         | Description                |
|--------|------------------|----------------------------|
| GET    | `/schools/`      | Retrieve all schools        |
| POST   | `/schools/`      | Create a new school         |
| GET    | `/schools/{id}`  | Retrieve school by ID       |
| PUT    | `/schools/{id}`  | Update existing school      |
| DELETE | `/schools/{id}`  | Delete school by ID         |

## Technology Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2/MySQL/PostgreSQL (configurable)
- Maven

## Prerequisites

- Java 17 or higher
- Maven
- Database setup (H2, MySQL, PostgreSQL, etc.)

## Running the Application

1. Configure your database settings in `application.properties`.
2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the service:

   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at `http://localhost:8080/schools`.

## Environment Variables

Set environment variables if required (via `.env` or system):

* `SERVER_PORT` — port number the service listens on

## Notes

* CORS is enabled globally (`@CrossOrigin("*")`), adjust as needed for production.
* Exception handling can be extended for better error responses.
* Easily extendable to add more features like paging, filtering, and authentication.
