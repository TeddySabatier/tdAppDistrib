package org.tse.kabanboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.kabanboard.Dao.DeveloperDao;
import org.tse.kabanboard.entity.Developer;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TestFindAllDevelopers {
	@Autowired
	private DeveloperDao _DeveloperDao;
	@Test
	void testFindAllDevelopers(){
		List <Developer> myDevelopers = _DeveloperDao.findAll();
		assertEquals(1, myDevelopers.size());		
	}
}
