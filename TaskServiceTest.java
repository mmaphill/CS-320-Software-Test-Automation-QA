package com.taskservice.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TaskServiceTest {
	private TaskService tasks;
	private Task task;
	
	@BeforeEach
	void testSetUp() {
		tasks = new TaskService();
		task = new Task("001","Task 01","First Task");
	}
	
	// Test Add Tasks
	@Test
	void testAddTask() {
		assertDoesNotThrow(() -> tasks.addTask(task));
	}
	
	@Test
	void testDuplicateTask() {
		tasks.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> tasks.addTask(task));
	}
	
	// Test Delete Tasks
	@Test
	void testDeleteTask() {
		tasks.addTask(task);
		tasks.deleteTask("001");
	}
	
	@Test
	void testDeleteNonExistentTask() {
		assertThrows(IllegalArgumentException.class, () -> tasks.deleteTask("111"));
	}
	
	// Test Update Name
	@Test
	void testUpdateName() {
		tasks.addTask(task);
		tasks.updateName("001", "1st Task");
		assertEquals("1st Task", tasks.getTask("001").getName());
	}
	
	// Test Update Description
	@Test
	void testUpdateDescription() {
		tasks.addTask(task);
		tasks.updateDescription("001", "Updating the description");
		assertEquals("Updating the description", tasks.getTask("001").getDescription());
	}
	
	// Test Get Task
	
	@Test
	void testGetTask() {
		tasks.addTask(task);
		assertDoesNotThrow(() -> tasks.getTask("001"));
	}
	
	@Test
	void testNonExistentTaskId() {
		assertThrows(IllegalArgumentException.class, () -> tasks.getTask("111"));
	}
}
