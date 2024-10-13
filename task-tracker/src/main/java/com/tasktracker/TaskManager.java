package com.tasktracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private final String filePath = "tasks.json";
    private int nextId = 1;

    public TaskManager() {
        tasks = new ArrayList<>(); // Ensure tasks is initialized here
        loadTasks();
    }

    public void addTask(String description) {
        String currentTime = String.valueOf(System.currentTimeMillis());
        Task task = new Task(nextId++, description, "todo", currentTime, currentTime);
        tasks.add(task);
        saveTasks();
        System.out.println(Color.colored("Task added successfully (ID: " + task.getId() + ")", Color.GREEN));
    }

    public void updateTask(int id, String newDescription) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(newDescription);
            task.setUpdatedAt(String.valueOf(System.currentTimeMillis()));
            saveTasks();
            System.out.println(Color.colored("Task updated successfully.", Color.GREEN));
        } else {
            System.out.println(Color.colored("Task not found.", Color.RED));
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            saveTasks();
            System.out.println(Color.colored("Task deleted successfully.", Color.GREEN));
        } else {
            System.out.println(Color.colored("Task not found.", Color.RED));
        }
    }

    public void markInProgress(int id) {
        updateTaskStatus(id, "in-progress");
    }

    public void markDone(int id) {
        updateTaskStatus(id, "done");
    }

    public void listTasks(String status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (status == null || task.getStatus().equals(status)) {
                filteredTasks.add(task);
            }
        }
        filteredTasks.forEach(task -> 
            System.out.println(Color.colored("ID: " + task.getId() + ", Description: " + task.getDescription() + ", Status: " + task.getStatus(), Color.BLUE)));
    }

    private void updateTaskStatus(int id, String newStatus) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(newStatus);
            task.setUpdatedAt(String.valueOf(System.currentTimeMillis()));
            saveTasks();
            System.out.println(Color.colored("Task marked as " + newStatus + ".", Color.GREEN));
        } else {
            System.out.println(Color.colored("Task not found.", Color.RED));
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void loadTasks() {
        try {
            if (Files.exists(Paths.get(filePath))) {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                tasks = new Gson().fromJson(reader, new TypeToken<List<Task>>() {}.getType());
                if (tasks == null) {
                    tasks = new ArrayList<>(); // Ensure tasks is initialized
                }
                nextId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
                reader.close();
            }
        } catch (IOException e) {
            System.err.println(Color.colored("Error loading tasks: " + e.getMessage(), Color.RED));
        }
    }

    private void saveTasks() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            new Gson().toJson(tasks, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println(Color.colored("Error saving tasks: " + e.getMessage(), Color.RED));
        }
    }
}
