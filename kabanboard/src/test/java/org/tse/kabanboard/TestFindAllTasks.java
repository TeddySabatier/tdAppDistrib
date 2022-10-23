package org.tse.kabanboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.kabanboard.Dao.TaskDao;
import org.tse.kabanboard.entity.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TestFindAllTasks {
	@Autowired
	private TaskDao _TaskDao;
	@Test
	void testFindAllDevelopers(){
		List <Task> myTasks = _TaskDao.findAll();
		assertEquals(2, myTasks.size());		
	}
}
