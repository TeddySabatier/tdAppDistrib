package org.tse.kabanboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kabanboard.entity.Developer;

public interface DeveloperDao extends JpaRepository<Developer, Long> {

}
