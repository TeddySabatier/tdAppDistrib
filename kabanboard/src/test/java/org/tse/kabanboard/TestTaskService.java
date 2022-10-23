package org.tse.kabanboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.kabanboard.Dao.TaskStatusDao;
import org.tse.kabanboard.entity.Developer;
import org.tse.kabanboard.entity.Task;
import org.tse.kabanboard.entity.TaskStatus;
import org.tse.kabanboard.service.TaskService;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TestTaskService {
	@Autowired
	private TaskService _taskService;
	
	@Autowired
	private TaskStatusDao _taskStatus;
	
	@Test
	void testFindAllTasks(){
		Collection<Task> myTasks = _taskService.findAllTasks();
		assertEquals(2, myTasks.size());		
	}
	
	@Test
	void testFindATask() {
	Task myTask = _taskService.findAllTasks().iterator().next();
	assertEquals(_taskService.findTask(myTask.getId()).getId(),myTask.getId());
	
	}
	@Test
	void TestMoveRightTask() {	
	Collection<Task> myTasks = _taskService.findAllTasks();
	//Get the first Task
	Task myTask=myTasks.iterator().next();
	myTask.setStatus(_taskStatus.findAll().get(0));
	try {
		_taskService.moveRightTask(myTask);
	} catch (Exception e) {
		e.printStackTrace();
	}
	assertEquals(_taskStatus.findAll().get(1).getId(),myTask.getStatus().getId());
	
	}
	@Test
	void TestMoveLeftTask() {
		Collection<Task> myTasks = _taskService.findAllTasks();
		//Get the first Task
		Task myTask=myTasks.iterator().next();
		myTask.setStatus(_taskStatus.findAll().get(2));
		try {
			_taskService.moveLeftTask(myTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(_taskStatus.findAll().get(1).getId(),myTask.getStatus().getId());
		
		}
	
}
