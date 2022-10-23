package org.tse.kabanboard.service;

import java.util.Collection;

import org.tse.kabanboard.entity.Task;

public interface TaskService {
	public Collection<Task> findAllTasks();
	public Task findTask(Long id);
	public Task moveRightTask(Task task) throws Exception;
	public Task moveLeftTask(Task task) throws Exception;
}
