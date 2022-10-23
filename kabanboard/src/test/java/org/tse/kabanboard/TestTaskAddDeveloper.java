package org.tse.kabanboard;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.kabanboard.entity.Developer;
import org.tse.kabanboard.entity.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
class TestTaskAddDeveloper {

	@Test
	void testAddDeveloper() {
		Developer myDeveloper = new Developer();
		Task myTask = new Task();
		myTask.addDeveloper(myDeveloper);
		assertEquals(myDeveloper, myTask.getDevelopers().iterator().next());
	}

}
