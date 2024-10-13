package com.tasktracker;

import java.util.Arrays;
import java.util.Scanner;

public class TaskTrackerApp {
	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		Scanner scanner = new Scanner(System.in);

		if (args.length > 0) {
			switch (args[0]) {
			case "add":
				if (args.length < 2) {
					System.out.println("Please provide a task description.");
				} else {
					// Join all args starting from index 1 to form the description
					String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
					taskManager.addTask(description);
				}
				break;

			case "update":
				if (args.length < 3) {
					System.out.println("Usage: update <task_id> <new_description>");
				} else {
					int id = Integer.parseInt(args[1]);
					String newDescription = String.join(" ", Arrays.asList(args).subList(2, args.length));
					taskManager.updateTask(id, newDescription);
				}
				break;

			case "delete":
				if (args.length < 2) {
					System.out.println("Usage: delete <task_id>");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.deleteTask(id);
				}
				break;

			case "in-progress":
				if (args.length < 2) {
					System.out.println("Usage: in-progress <task_id>");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markInProgress(id);
				}
				break;

			case "done":
				if (args.length < 2) {
					System.out.println("Usage: done <task_id>");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markDone(id);
				}
				break;

			case "list":
				String status = args.length > 1 ? args[1] : null;
				taskManager.listTasks(status);
				break;

			default:
				System.out.println("Unknown command.");
			}
		} else {
			System.out.println("No command provided.");
		}

		scanner.close();
	}
}
