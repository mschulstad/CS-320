package week4;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    // Add a new task with a unique ID
    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        taskMap.put(task.getTaskId(), task);
    }

    // Delete a task by task ID
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskMap.remove(taskId);
    }

    // Update task name by task ID
    public void updateTaskName(String taskId, String newName) {
        Task task = getTask(taskId);
        task.setName(newName);
    }

    // Update task description by task ID
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = getTask(taskId);
        task.setDescription(newDescription);
    }

    // Get a task by task ID
    public Task getTask(String taskId) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return task;
    }
}