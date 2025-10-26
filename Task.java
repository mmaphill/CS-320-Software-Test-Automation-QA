package com.taskservice.task;

public class Task {
	// fields
	private final String taskId;
	private String name;
	private String description;
	
	// constructor
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Task ID must be non-null and no greater than 10 characters");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Task Name must be non-null and no greater than 20 characters");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Task Descpription must be non-null and no greater than 50 characters");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// getters
	public String getTaskId() { return taskId; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	
	// setters
	public void setName(String name) { 
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Task Name must be non-null and no greater than 20 characters");
		}
		this.name = name; 
	}
	public void setDescription(String description) { 
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Task Descpription must be non-null and no greater than 50 characters");
		}
		this.description = description; 
	}
}