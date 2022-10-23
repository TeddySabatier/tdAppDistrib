package org.tse.kabanboard.service.impl;

import java.lang.reflect.Executable;
import java.util.Collection;
import java.util.Optional;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.kabanboard.Dao.TaskDao;
import org.tse.kabanboard.Dao.TaskStatusDao;
import org.tse.kabanboard.entity.Task;
import org.tse.kabanboard.entity.TaskStatus;
import org.tse.kabanboard.service.TaskService;
import org.tse.kabanboard.utils.Constants;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao _taskDao;
	@Autowired
	private TaskStatusDao _taskStatusDao;
	
	@Override
	public Collection<Task> findAllTasks() {
		return _taskDao.findAll();
	}

	@Override
	public Task findTask(Long id) {
		return _taskDao.findById(id).orElseThrow();
	}

	@Override
	public Task moveRightTask(Task task) throws Exception {
	    Long state1=Constants.TASK_STATUS_ID_NOTSTARTED;
		Long state2=Constants.TASK_STATUS_ID_STARTED;
		Long state3=Constants.TASK_STATUS_ID_TESTING;
		Long state4=Constants.TASK_STATUS_ID_PROD;
		
		Long currentState=task.getStatus().getId();
		
		if(currentState!=state4) {
			if(currentState == state1 ) {
				task.setStatus(_taskStatusDao.getById(state2));
			}else {
				if(currentState == state2 ) {
					task.setStatus(_taskStatusDao.getById(state3));
				}else {
					if(currentState == state3 ) {
						task.setStatus(_taskStatusDao.getById(state4));
					}else {
							throw new IllegalArgumentException("Unexpected value: " + (task.getStatus().getId()));
						}
				}
			}
		}else {
			throw new Exception("Impossible de déplacer une tache dans un état plus avancer que production.");
		}		
		return task;
	}


	@Override
	public Task moveLeftTask(Task task) throws Exception {
		 	Long state1=Constants.TASK_STATUS_ID_NOTSTARTED;
			Long state2=Constants.TASK_STATUS_ID_STARTED;
			Long state3=Constants.TASK_STATUS_ID_TESTING;
			Long state4=Constants.TASK_STATUS_ID_PROD;
			
			Long currentState=task.getStatus().getId();
			
			if(currentState!=state1) {
				if(currentState == state4 ) {
					task.setStatus(_taskStatusDao.getById(state3));
				}else {
					if(currentState == state3 ) {
						task.setStatus(_taskStatusDao.getById(state2));
					}else {
						if(currentState == state2 ) {
							task.setStatus(_taskStatusDao.getById(state1));
						}else {
								throw new IllegalArgumentException("Unexpected value: " + (task.getStatus().getId()));
							}
					}
				}
			}else {
				throw new Exception("Impossible de déplacer une tache dans un état avant non commencer.");
			}		
			return task;
	}
	

}
