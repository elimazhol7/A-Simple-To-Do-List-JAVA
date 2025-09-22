package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    private TaskList list;

    @BeforeEach
    void setUp() {
        list = new TaskList();
    }

    @Test
    void testAddTask() {
        list.add("Task 1");
        list.add("Task 2");

        assertEquals(2, list.getAllTasks().size());
        assertEquals("Task 1", list.getAllTasks().get(0).getDescription());
        assertEquals("Task 2", list.getAllTasks().get(1).getDescription());
        assertFalse(list.getAllTasks().get(0).isComplete());
        assertFalse(list.getAllTasks().get(1).isComplete());
    }

    @Test
    void testCompleteTask() {
        list.add("Task 1");
        list.complete("Task 1");
        assertTrue(list.getAllTasks().get(0).isComplete());
    }

    @Test
    void testIncompleteTask() {
        list.add("Task 1");
        list.complete("Task 1");
        list.incomplete("Task 1");
        assertFalse(list.getAllTasks().get(0).isComplete());
    }

    @Test
    void testGetCompletedTasks() {
        list.add("Task 1");
        list.add("Task 2");
        list.complete("Task 2");

        assertEquals(1, list.getCompletedTasks().size());
        assertEquals("Task 2", list.getCompletedTasks().get(0).getDescription());
    }

    @Test
    void testGetIncompleteTasks() {
        list.add("Task 1");
        list.add("Task 2");
        list.complete("Task 2");

        assertEquals(1, list.getIncompleteTasks().size());
        assertEquals("Task 1", list.getIncompleteTasks().get(0).getDescription());
    }

    @Test
    void testClear() {
        list.add("Task 1");
        list.add("Task 2");
        list.clear();
        assertTrue(list.getAllTasks().isEmpty());
    }
}
