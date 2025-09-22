package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList list = new TaskList();
        boolean running = true;

        while (running) {
            System.out.println("\n=== TASK LIST MENU ===");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Mark Task Incomplete");
            System.out.println("4. Show All Tasks");
            System.out.println("5. Show Completed Tasks");
            System.out.println("6. Show Incomplete Tasks");
            System.out.println("7. Clear All Tasks");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine(); // read entire line
            int choice;

            try {
                choice = Integer.parseInt(input); // convert to number
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc1 = scanner.nextLine().trim();
                    if (desc1.isEmpty()) {
                        System.out.println("Task description cannot be empty.");
                    } else {
                        list.add(desc1);
                        System.out.println("Added task: " + desc1);
                    }
                    break;

                case 2:
                    System.out.print("Enter task to mark complete: ");
                    String desc2 = scanner.nextLine().trim();
                    if (!list.complete(desc2)) {
                        System.out.println("Task not found: " + desc2);
                    } else {
                        System.out.println("Marked complete: " + desc2);
                    }
                    break;

                case 3:
                    System.out.print("Enter task to mark incomplete: ");
                    String desc3 = scanner.nextLine().trim();
                    if (!list.incomplete(desc3)) {
                        System.out.println("Task not found: " + desc3);
                    } else {
                        System.out.println("Marked incomplete: " + desc3);
                    }
                    break;

                case 4:
                    System.out.println("All tasks:");
                    if (list.getAllTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (Task t : list.getAllTasks()) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Completed tasks:");
                    if (list.getCompletedTasks().isEmpty()) {
                        System.out.println("No completed tasks.");
                    } else {
                        for (Task t : list.getCompletedTasks()) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Incomplete tasks:");
                    if (list.getIncompleteTasks().isEmpty()) {
                        System.out.println("No incomplete tasks.");
                    } else {
                        for (Task t : list.getIncompleteTasks()) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 7:
                    list.clear();
                    System.out.println("All tasks cleared!");
                    break;

                case 8:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        System.out.println("Exiting task list. Goodbye!");
        scanner.close();
    }
}
