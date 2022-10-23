package org.tse.kabanboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kabanboard.entity.ChangeLog;

public interface ChangeLogDao extends JpaRepository<ChangeLog, Long> {

}
