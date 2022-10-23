package org.tse.kabanboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kabanboard.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long> {

}
