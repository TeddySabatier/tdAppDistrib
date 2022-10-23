package org.tse.kabanboard.utils;


import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.tse.kabanboard.Dao.DeveloperDao;
import org.tse.kabanboard.Dao.TaskDao;
import org.tse.kabanboard.Dao.TaskStatusDao;
import org.tse.kabanboard.Dao.TaskTypeDao;
import org.tse.kabanboard.entity.Developer;
import org.tse.kabanboard.entity.Task;
import org.tse.kabanboard.entity.TaskStatus;
import org.tse.kabanboard.entity.TaskType;


@Configuration
public class LoadDB {
	@Bean
	@Profile("test")
	CommandLineRunner initDB(DeveloperDao _developerDao,
			TaskDao _taskDao,
			TaskStatusDao _taskStatusDao,
			TaskTypeDao _taskTypeDao) {

		return args -> {			
			initTaskStatusAndType(_taskStatusDao, _taskTypeDao);
			initDevelopersTest(_developerDao);
			initTasksTest(_taskDao,_developerDao);
		};
	}
	
	static private void initTasksTest(TaskDao _taskDao,DeveloperDao _developerDao) {
		Developer myDeveloper=_developerDao.findAll().get(0);
		
		Task task1 =new Task();
		task1.addDeveloper(myDeveloper);
		task1.setCreated(ConstantsTests.TASK1_CREATED);
		task1.setNbHoursForecast(ConstantsTests.TASK1_NBHOURSFORECAST);
		task1.setNbHoursReal(ConstantsTests.TASK1_NBHOURSREAL);
		task1.setTitle(ConstantsTests.TASK1_TITLE);
		
		Task task2 =new Task();
		task2.addDeveloper(myDeveloper);
		task2.setCreated(ConstantsTests.TASK2_CREATED);
		task2.setNbHoursForecast(ConstantsTests.TASK2_NBHOURSFORECAST);
		task2.setNbHoursReal(ConstantsTests.TASK2_NBHOURSREAL);
		task2.setTitle(ConstantsTests.TASK2_TITLE);
		_taskDao.save(task1);
		_taskDao.save(task2);
		
	}
	static private void initDevelopersTest(DeveloperDao _developerDao ) {
		Developer myDeveloper=new Developer();
		myDeveloper.setEmail(ConstantsTests.DEVELOPER_MAIL);
		myDeveloper.setFirstname(ConstantsTests.DEVELOPER_FIRSTNAME);
		myDeveloper.setLastname(ConstantsTests.DEVELOPER_LASTNAME);
		myDeveloper.setPassword(ConstantsTests.DEVELOPER_PASSWORD);
		myDeveloper.setStartContract(ConstantsTests.DEVELOPER_STARTCONTRACT);
		_developerDao.save(myDeveloper);
		
	}
	private void initTaskStatusAndType(TaskStatusDao _taskStatusDao, TaskTypeDao _taskTypeDao) {
		
		TaskStatus notStarted = new TaskStatus(Constants.TASK_STATUS_ID_NOTSTARTED, Constants.TASK_STATUS_LABEL_NOTSTARTED);
		TaskStatus started = new TaskStatus(Constants.TASK_STATUS_ID_STARTED, Constants.TASK_STATUS_LABEL_STARTED);
		TaskStatus testing = new TaskStatus(Constants.TASK_STATUS_ID_TESTING, Constants.TASK_STATUS_LABEL_TESTING);
		TaskStatus production = new TaskStatus(Constants.TASK_STATUS_ID_PROD, Constants.TASK_STATUS_LABEL_PROD);
		
		_taskStatusDao.save(notStarted);
		_taskStatusDao.save(started);
		_taskStatusDao.save(testing);		
		_taskStatusDao.save(production);

		TaskType bug = new TaskType(Constants.TASK_TYPE_ID_BUG, Constants.TASK_TYPE_LABEL_BUG);
		TaskType addon = new TaskType(Constants.TASK_TYPE_ID_ADDON, Constants.TASK_TYPE_LABEL_ADDON);
		
		_taskTypeDao.save(addon);
		_taskTypeDao.save(bug);

}
}