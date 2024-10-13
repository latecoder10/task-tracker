package com.tasktracker;

import java.util.Arrays;
import java.util.Scanner;

public class TaskTrackerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        // If command-line arguments are provided, handle them
        if (args.length > 0) {
            processArgs(args, taskManager);
        } else {
            // No command provided, enter interactive mode
            String command;
            System.out.println(Color.colored("Enter a command (or 'exit' to quit):", Color.BLUE));
            while (!(command = scanner.nextLine()).equalsIgnoreCase("exit")) {
                String[] commandArgs = command.split(" ");
                processArgs(commandArgs, taskManager);
            }
            System.out.println("");
        }

        scanner.close();
    }

    private static void processArgs(String[] args, TaskManager taskManager) {
        switch (args[0]) {
            case "add":
                if (args.length < 2) {
                    System.out.println(Color.colored("Please provide a task description.", Color.RED));
                } else {
                    String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                    taskManager.addTask(description);
                }
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println(Color.colored("Usage: update <task_id> <new_description>", Color.RED));
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        String newDescription = String.join(" ", Arrays.asList(args).subList(2, args.length));
                        taskManager.updateTask(id, newDescription);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.colored("Invalid task ID.", Color.RED));
                    }
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println(Color.colored("Usage: delete <task_id>", Color.RED));
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.deleteTask(id);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.colored("Invalid task ID.", Color.RED));
                    }
                }
                break;

            case "in-progress":
                if (args.length < 2) {
                    System.out.println(Color.colored("Usage: in-progress <task_id>", Color.RED));
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.markInProgress(id);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.colored("Invalid task ID.", Color.RED));
                    }
                }
                break;

            case "done":
                if (args.length < 2) {
                    System.out.println(Color.colored("Usage: done <task_id>", Color.RED));
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.markDone(id);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.colored("Invalid task ID.", Color.RED));
                    }
                }
                break;

            case "list":
                String status = args.length > 1 ? args[1] : null;
                taskManager.listTasks(status);
                break;

            default:
                System.out.println(Color.colored("Unknown command.", Color.RED));
        }
    }
}
