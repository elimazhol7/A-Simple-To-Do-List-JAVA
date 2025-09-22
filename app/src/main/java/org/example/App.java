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

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // clear invalid input
                continue;
            }
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter task description: ");
                String desc = scanner.nextLine();
                list.add(desc);
            } else if (choice == 2) {
                System.out.print("Enter task to mark complete: ");
                String desc = scanner.nextLine();
                list.complete(desc);
            } else if (choice == 3) {
                System.out.print("Enter task to mark incomplete: ");
                String desc = scanner.nextLine();
                list.incomplete(desc);
            } else if (choice == 4) {
                System.out.println("All tasks:");
                list.all();
            } else if (choice == 5) {
                System.out.println("Completed tasks:");
                list.complete();
            } else if (choice == 6) {
                System.out.println("Incomplete tasks:");
                list.incomplete();
            } else if (choice == 7) {
                list.clear();
            } else if (choice == 8) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Exiting task list. Goodbye!");
        scanner.close();
    }
}
