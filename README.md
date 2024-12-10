# Binary Search Tree Backend

This is the **backend service** for managing Binary Search Tree data. Built with **Spring Boot** and integrated with a **MySQL database**, the service exposes RESTful APIs for the frontend to create, save, and fetch binary search trees.

## Features
- Create binary search trees from a list of numbers.
- Save trees to a MySQL database.
- Retrieve all previously saved trees.
- Cross-Origin Resource Sharing (CORS) support for frontend integration.

## Prerequisites
- Java Development Kit (JDK) 17 or higher.
- MySQL database server.
- Maven build tool (included in the repository).

## Installation

1. **Clone the repository**:
   ```bash
   git clone <your-repo-url>
   cd matrix-tree-backend
   ```

2. **Set up the database**:
   - Log into your MySQL server and create the database:
     ```sql
     CREATE DATABASE bst_app;
     ```
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bst_app
     spring.datasource.username=root
     spring.datasource.password=root
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Build and run the application**:
   - Use Maven to build and start the application:
     ```bash
     ./mvnw spring-boot:run
     ```
   - The backend service will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

### **1. Fetch All Trees**
- **GET /api/previous-trees**
- Description: Retrieves all previously saved trees from the database.
- Example response:
  ```json
  [
    {
      "id": 1,
      "inputNumbers": "10,5,15,3,7",
      "treeStructure": "{\"value\":10,\"left\":{\"value\":5,\"left\":{\"value\":3},\"right\":{\"value\":7}},\"right\":{\"value\":15}}"
    }
  ]
  ```

### **2. Save a Tree**
- **POST /api/save-tree**
- Description: Saves a tree to the database.
- Request body:
  ```json
  {
    "inputNumbers": "10,5,15,3,7",
    "treeStructure": "{\"value\":10,\"left\":{\"value\":5,\"left\":{\"value\":3},\"right\":{\"value\":7}},\"right\":{\"value\":15}}"
  }
  ```
- Example response:
  ```json
  {
    "id": 2,
    "inputNumbers": "10,5,15,3,7",
    "treeStructure": "{\"value\":10,\"left\":{\"value\":5,\"left\":{\"value\":3},\"right\":{\"value\":7}},\"right\":{\"value\":15}}"
  }
  ```

### **3. Generate and Save a Tree from Numbers**
- **POST /api/process-numbers**
- Description: Creates a binary search tree from a list of numbers and saves it to the database.
- Request body:
  ```json
  [10, 5, 15, 3, 7]
  ```
- Example response:
  ```json
  {
    "id": 3,
    "inputNumbers": "10,5,15,3,7",
    "treeStructure": "{\"value\":10,\"left\":{\"value\":5,\"left\":{\"value\":3},\"right\":{\"value\":7}},\"right\":{\"value\":15}}"
  }
  ```

## Folder Structure
```
src/main/
├── java/com/keyin/bts/
│   ├── controller/         # REST API controllers
│   ├── entity/             # Database entity classes
│   ├── repository/         # Spring Data JPA repositories
│   ├── service/            # Business logic and tree generation
│   └── Application.java    # Main application entry point
└── resources/
    ├── application.properties  # Application configuration
    └── data.sql                # Optional: Seed data for testing
```

## Environment
- **Spring Boot**: 3.2.x
- **Java**: 17
- **MySQL**: 8.x
- **Maven**: 3.x (wrapper included)

## Testing
Use tools like **Postman** or **cURL** to test the API endpoints.

### Fetch Trees
```bash
curl -X GET http://localhost:8080/api/previous-trees
```

### Save a Tree
```bash
curl -X POST http://localhost:8080/api/save-tree \
     -H "Content-Type: application/json" \
     -d '{"inputNumbers": "10,5,15", "treeStructure": "{\"value\":10,\"left\":{\"value\":5},\"right\":{\"value\":15}}"}'
```

### Generate and Save a Tree
```bash
curl -X POST http://localhost:8080/api/process-numbers \
     -H "Content-Type: application/json" \
     -d '[10,5,15,3,7]'
```

## Troubleshooting

1. **Database Connection Issues**:
   - Ensure MySQL is running and accessible.
   - Verify credentials in `application.properties`.

2. **CORS Errors**:
   - Ensure CORS is configured in the backend:
     ```java
     @CrossOrigin(origins = "http://localhost:3000")
     ```

3. **Data Not Persisting**:
   - Check `spring.jpa.hibernate.ddl-auto=update` in `application.properties` to ensure schema updates are applied.

## License
This project is licensed under the MIT License.
