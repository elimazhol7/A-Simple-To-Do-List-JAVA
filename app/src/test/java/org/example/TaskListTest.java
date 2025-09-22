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
    void testAddAndCompleteTask() {
        list.add("Buy milk");
        list.add("Buy eggs");
        list.complete("Buy eggs");

        assertEquals("[✓] Buy eggs", list.getAllTasks().get(1).toString());
        assertEquals("[ ] Buy milk", list.getAllTasks().get(0).toString());
    }

    @Test
    void testIncompleteTask() {
        list.add("Task 1");
        list.complete("Task 1");
        list.incomplete("Task 1");
        assertEquals("[ ] Task 1", list.getAllTasks().get(0).toString());
    }

    @Test
    void testClear() {
        list.add("Task 1");
        list.add("Task 2");
        list.clear();
        assertTrue(list.getAllTasks().isEmpty());
    }
}
