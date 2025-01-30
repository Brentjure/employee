# Employee Management Application

## Overview
The Employee Management Application is a full-stack system for managing employee details. It uses Angular for the frontend, Java Spring Boot for the backend, RabbitMQ for message queuing, and MySQL as the database.
![Screenshot 2025-01-30 114716](https://github.com/user-attachments/assets/d48ea43f-1b4c-4fc4-9d5f-09745725e3d3)

![Screenshot 2025-01-17 094926](https://github.com/user-attachments/assets/3451aea8-8290-45a7-ab25-6da441de8481)
---
![Screenshot 2025-01-17 094950](https://github.com/user-attachments/assets/8e392090-819a-496a-b59a-8cbd8ea62ee0)

## Features
1. Employees can be created through a user-friendly Angular frontend.
2. Details submitted are sent to the backend via REST API.
3. The backend publishes the employee data to RabbitMQ.
4. A consumer service reads the message from RabbitMQ and saves the details to a MySQL database.


---


## System Architecture

### Components
1. **Frontend (Angular)**:
   - Captures employee details.
  
2. **Backend (Spring Boot)**:
   - Provides REST API endpoints for employee operations.
   - Publishes messages to RabbitMQ.
   - Consumes messages from RabbitMQ and persists data in MySQL.

3. **RabbitMQ**:
   - Acts as the messaging broker to decouple the frontend and backend processes.

4. **Database (MySQL)**:
   - Stores employee records persistently.

---

## Database Design

### Employee Table
- **Fields:**
  - `id` (Primary Key): Auto-incremented unique identifier for each employee.
  - `first_name`: Employee's first name.
  - `last_name`: Employee's last name.
  - `email`: Employee's email address.
  - `gender`: Employee's gender.
  - `position`: Employee job title

---

## Process Flow

1. Employee details are entered on the Angular form.
2. The form sends the data to the Spring Boot API via a POST request.
3. Spring Boot publishes the employee data to RabbitMQ.
4. A RabbitMQ consumer listens for messages and saves them to the database.
5. Angular retrieves the list of employees from the API and displays them.

---

## Installation and Setup

### Prerequisites
- Node.js and Angular CLI for the frontend.
- Java and Maven for the backend.
- RabbitMQ installed and running.
- MySQL database installed.

### Steps

#### 1. Frontend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/employee-app.git
   cd employee-app/frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the Angular app:
   ```bash
   ng serve
   ```

#### 2. Backend Setup
1. Navigate to the backend directory:
   ```bash
   cd employee-app/backend
   ```
2. Install dependencies and build the project:
   ```bash
   ./mvnw clean install
   ```
3. Configure the `application.properties` file with MySQL and RabbitMQ details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=root

   spring.rabbitmq.host=localhost
   spring.rabbitmq.port=5672
   ```
4. Start the backend application:
   ```bash
   ./mvnw spring-boot:run
   ```

#### 3. RabbitMQ Setup
1. Start RabbitMQ:
   ```bash
   rabbitmq-server
   ```
2. Verify the RabbitMQ queue is created:
   - Access the RabbitMQ management console at `http://localhost:15672`.
   - Check for `employee.queue` under the Queues section.

---

## API Endpoints

### **POST** `/api/v1/post-employee-details`
- **Description:** Receives employee data and publishes it to RabbitMQ.
- **Payload Example:**
  ```json
  {
    "first_name":"Jonathan", 
    "last_name":"Otieno", 
    "email":"jonanthan.otieno@example.com", 
    "gender":"M", 
    "position": "solution architect"
       
}
  ```

### **GET** `/api/v1/get-all-employees`
- **Description:** Retrieves all employees from the database.

---

## Future Improvements
1. Add authentication and role-based access control.
2. Implement advanced search and filter features on the employee list.
3. Deploy the application to cloud platforms for scalability.
4. Add automated tests for backend and frontend components.

---

## License
This project is licensed under the MIT License.

---

## Contact
For any questions or feedback, please reach out to [your-email@example.com].

