# Binary Search Tree Backend

This is the **backend** application for handling Binary Search Tree data. Built with **Spring Boot**, it interacts with a **MySQL database** to save and retrieve trees and provides RESTful APIs for the frontend.

## Features
- Create binary search trees from input numbers.
- Save generated trees to a MySQL database.
- Retrieve saved trees for visualization in the frontend.
- Cross-Origin Resource Sharing (CORS) configured for React frontend.

## Installation

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd matrix-tree-backend
Configure the database:

Create a MySQL database named bst_app.
Update application.properties with your database credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/bst_app
spring.datasource.username=root
spring.datasource.password=root
Build and run the project:

bash
Copy code
./mvnw spring-boot:run
The backend will run at http://localhost:8080.

API Endpoints
Method	Endpoint	Description
GET	/api/previous-trees	Fetch all saved trees
POST	/api/save-tree	Save a tree to the database
POST	/api/process-numbers	Create and save a tree from numbers
Folder Structure
bash
Copy code
src/main/
├── java/com/keyin/bts/
│   ├── controller/         # API controllers
│   ├── entity/             # Database entities
│   ├── repository/         # Spring Data JPA repositories
│   ├── service/            # Business logic and tree generation
│   └── Application.java    # Main application entry point
└── resources/
    ├── application.properties  # Database and app configurations
    └── data.sql                # (Optional) Seed data
Environment
Spring Boot: 3.2.x
Java: 17
MySQL: 8.x
Testing
Use tools like Postman or cURL to test API endpoints. Example:

Fetch Trees
bash
Copy code
curl -X GET http://localhost:8080/api/previous-trees
Save Tree
bash
Copy code
curl -X POST http://localhost:8080/api/save-tree \
     -H "Content-Type: application/json" \
     -d '{"inputNumbers": "10,5,15", "treeStructure": "{\"value\":10,\"left\":{\"value\":5},\"right\":{\"value\":15}}"}'
License
MIT License
