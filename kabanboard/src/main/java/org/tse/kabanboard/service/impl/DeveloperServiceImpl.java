package org.tse.kabanboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.kabanboard.Dao.DeveloperDao;
import org.tse.kabanboard.entity.Developer;
import org.tse.kabanboard.service.DeveloperService;



@Service
public class DeveloperServiceImpl implements DeveloperService {
	
	@Autowired 
	private DeveloperDao _developerDao;
	
	public List<Developer> findAllDevelopers() {
		
		return _developerDao.findAll();
	}

}
