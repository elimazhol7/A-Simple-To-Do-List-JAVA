package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void add(String description) {
        tasks.add(new Task(description));
        System.out.println("Added task: " + description); // Confirmation
    }

    public void complete(String description) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                t.markComplete();
                System.out.println("Marked complete: " + description);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Task not found: " + description);
    }

    public void incomplete(String description) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                t.markIncomplete();
                System.out.println("Marked incomplete: " + description);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Task not found: " + description);
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("The task list is empty.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void complete() {
        boolean found = false;
        for (Task t : tasks) {
            if (t.isComplete()) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("No completed tasks.");
    }

    public void incomplete() {
        boolean found = false;
        for (Task t : tasks) {
            if (!t.isComplete()) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("No incomplete tasks.");
    }

    public void clear() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
