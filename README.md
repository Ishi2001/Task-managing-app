# Task Tracker API with PostgreSQL Backend

Welcome to the Task Tracker API. It is based on RESTful API using Java, PostgreSQL, and robust error handling.

## Programming Language used
Java framework Spring Boot.
And Database used is PostgreSQL.
## Configure PostgreSQL

   1) Create a database in your PostgreSQL instance.
   2) Update the application.properties file in the src/main/resources folder with the URL, username and password for your PostgreSQL instance. The table schema for the Task Traker  will be created for you in the database.
## Build and run the sample

    1. mvnw package
    2. Open a web browser to http://localhost:8309

As you add and update tasks in the app you can verify the changes in the database through the PostgreSQL console. 
## Task Properties
Each task has the following properties:

1. id (String): Unique identifier for the task.
2. title (String): Title of the task.
3. description (String): Description of the task.
4. dueDate (Date): Due date of the task.

.Implemented the following endpoints:

1. POST /tasks: Create a new task.
2. GET /tasks/{id}: Retrieve a task by its ID.
3. GET /tasks: Retrieve a list of all tasks.
4. PUT /tasks/{id}: Update an existing task by its ID.
5. DELETE /tasks/{id}: Delete a task by its ID
## 🔗 Links
https://github.com/Ishi2001/Task-managing-app
## Features

- Task Tracker will add the  task
- Task Tracker will update the task
- Task Tracker eill delete the task
- If task is completed toggle on complete button it will show complition status
- Task Tracker will assigne the due date of task
- It contains the logging file (log.txt)
- It also handle the error
