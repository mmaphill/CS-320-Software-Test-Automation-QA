package com.taskservice.task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private Map<String, Task> tasks = new HashMap<>();
	
	// add task to the list of tasks
	public void addTask(Task task) {
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task ID already exists: " + task.getTaskId());
		}
		tasks.put(task.getTaskId(), task);
	}
	
	// delete task from the list of tasks
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("No Task found with ID: " + taskId);
		}
		tasks.remove(taskId);
	}
	
	// update fields
	public void updateName(String taskId, String name) {
		getTask(taskId).setName(name);
	}
	
	public void updateDescription(String taskId, String description) {
		getTask(taskId).setDescription(description);
	}
	
	// method to get task ID
	public Task getTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("No task found with ID: " + taskId);
		}
		return tasks.get(taskId);
	}
}