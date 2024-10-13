Task Tracker
A simple task management application built in Java.

Table of Contents
Installation
Usage
Commands
Contributing
License
Installation
Clone the Repository: Open your terminal (or command prompt) and run:

bash
Copy code
git clone https://github.com/latecoder10/task-tracker.git
Change directory into the project folder:

bash
Copy code
cd task-tracker
Ensure Java is Installed: Make sure you have Java JDK installed. You can check your Java installation by running:

bash
Copy code
java -version
Install Maven: Ensure you have Maven installed. You can check your Maven installation by running:

bash
Copy code
mvn -version
Build the Project: From the project root directory, run:

bash
Copy code
mvn clean install
Usage
Run the Application: You can run the application using:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp"
Add Tasks: To add a new task, use the command:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="add Your task description"
List Tasks: To list all tasks, use:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="list"
Update a Task: To update a task, use:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="update TaskID New description"
Delete a Task: To delete a task, use:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="delete TaskID"
Mark Task as In Progress: To mark a task as in progress, use:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="in-progress TaskID"
Mark Task as Done: To mark a task as done, use:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="done TaskID"
Commands
add: Add a new task.
list: List all tasks.
update: Update a task description.
delete: Delete a task.
in-progress: Mark a task as in progress.
done: Mark a task as done.
Contributing
Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes and commit (git commit -m 'Add new feature').
Push to the branch (git push origin feature-branch).
Create a Pull Request.
License
This project is licensed under the MIT License - see the LICENSE file for details.
