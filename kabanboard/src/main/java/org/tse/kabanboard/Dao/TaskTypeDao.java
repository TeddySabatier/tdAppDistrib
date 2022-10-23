package org.tse.kabanboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kabanboard.entity.TaskType;

public interface TaskTypeDao extends JpaRepository<TaskType, Long> {

}
