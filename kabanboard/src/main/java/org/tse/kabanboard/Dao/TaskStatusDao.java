package org.tse.kabanboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kabanboard.entity.TaskStatus;

public interface TaskStatusDao extends JpaRepository<TaskStatus, Long> {

}
