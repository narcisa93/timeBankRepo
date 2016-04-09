package com.timebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timebank.dao.ProjectDao;
import com.timebank.model.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void addProject(Project project) {
		projectDao.addProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);
	}

}
