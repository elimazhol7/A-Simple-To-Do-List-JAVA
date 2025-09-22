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
    }

    public boolean complete(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                t.markComplete();
                return true;
            }
        }
        return false;
    }

    public boolean incomplete(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                t.markIncomplete();
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getCompletedTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isComplete()) completed.add(t);
        }
        return completed;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> incomplete = new ArrayList<>();
        for (Task t : tasks) {
            if (!t.isComplete()) incomplete.add(t);
        }
        return incomplete;
    }

    public void clear() {
        tasks.clear();
    }
}
