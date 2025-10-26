package com.taskservice.task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	private Task task;

	@BeforeEach
	void testSetUp() {
		task = new Task("001","task01","This is the first task");
	}
	
	// Test Task Creation
	@Test
	void testTask() {
		assertTrue(task.getTaskId().equals("001"));
		assertTrue(task.getName().equals("task01"));
		assertTrue(task.getDescription().equals("This is the first task"));
	}
	
	@Test
	void testTaskIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task("01234567890","task01","This is the first task"));
	}
	
	@Test
	void testTaskIdNull() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task(null,"task01","This is the first task"));
	}
	
	@Test
	void testTaskNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task("001","This Name is Too Long","This is the first task"));
	}
	
	@Test
	void testTaskNameNull() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task("001",null,"This is the first task"));
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task("001","task01","If an individual were to create a task description that was much too long, it would look something like this"));
	}
	@Test
	void testTaskDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> task = new Task("001","task01",null));
	}
	
	// Test Setters
	@Test
	void testSetValidTaskName() {
		assertDoesNotThrow(() -> task.setName("1st Task"));
	}
	
	@Test
	void testSetTaskNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> task.setName("This Task Name is Too Long"));
	}
	
	@Test
	void testSetTaskNameNull() {
		assertThrows(IllegalArgumentException.class, () -> task.setName(null));
	}
	
	@Test
	void testSetTaskDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> task.setDescription("This task description is much too long for the created object"));
	}
	
	@Test
	void testSetTaskDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
	}
}
