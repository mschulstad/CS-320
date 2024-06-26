package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        Task task = new Task("12345", "Test Task", "This is a test task.");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("12345"));
    }

    @Test
    void testAddTaskDuplicateId() {
        Task task1 = new Task("12345", "Task 1", "First task");
        Task task2 = new Task("12345", "Task 2", "Second task");
        taskService.addTask(task1);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });

        assertEquals("Task ID already exists", exception.getMessage());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("12345", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.deleteTask("12345");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("12345");
        });
    }

    @Test
    void testDeleteNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("12345");
        });
    }

    @Test
    void testUpdateTaskName() {
        Task task = new Task("12345", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.updateTaskName("12345", "Updated Task");
        assertEquals("Updated Task", taskService.getTask("12345").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        Task task = new Task("12345", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.updateTaskDescription("12345", "Updated description");
        assertEquals("Updated description", taskService.getTask("12345").getDescription());
    }

    @Test
    void testUpdateNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("12345", "New Name");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("12345", "New Description");
        });
    }
}
