
# Task Tracker

A simple task management application built in Java.

## Features

- Task Management: Easily add, update, and delete tasks.
- Status Tracking: Mark tasks as "todo," "in-progress," or "done."
- FTimestamping: Automatically records creation and update times for each task.
- Persistent Storage: Saves tasks in a JSON file, allowing for persistence between sessions.
- Command-Line Interface: Simple commands for managing tasks directly from the terminal.
- Filter Tasks: List tasks based on their status.

## Installation

1. Clone the Repository: Open your terminal (or command prompt) and run

```bash
  git clone https://github.com/latecoder10/task-tracker.git
```
Change directory into the project folder:

```bash
 cd my-project
```
2. Ensure Java is Installed: Make sure you have Java JDK installed. You can check your Java installation by running:

```bash
java --version
```
3. Install Maven: Ensure you have Maven installed. You can check your Maven installation by running:

```bash
 mvn --version
```
4. Build the Project: From the project root directory, run:

```bash
mvn clean install
```

## Deployment

1. Run the Application: You can run the application using:

```bash
  mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp"
```
2. Add Tasks: To add a new task, use the command:

```bash
  mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="add Your task description"
```
3. List Tasks: To list all tasks, use:

```bash
  mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="list"
```
4. Update a Task: To update a task, use:

```bash
 mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="update TaskID New description"
```
5. Delete a Task: To delete a task, use:

```bash
 mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="delete TaskID"
```
6. Mark Task as In Progress: To mark a task as in progress, use:

```bash
  mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="in-progress TaskID"
```
7. Mark Task as Done: To mark a task as done, use:

```bash
  mvn exec:java -Dexec.mainClass="com.tasktracker.TaskTrackerApp" -Dexec.args="done TaskID"
```


## Commands

To run , use the following commands

```bash
  add: Add a new task.
```

```bash
  list: List all tasks.
```

```bash
  update: Update a task description.
```

```bash
  delete: Delete a task.
```

```bash
  in-progress: Mark a task as in progress.
```

```bash
  done: Mark a task as done.
```



## Contributing

Feel free to fork the repository and submit pull requests!



## Project URL

For more details about the GitHub User Activity project, visit: [Task Tracker Project](https://roadmap.sh/projects/task-tracker)
