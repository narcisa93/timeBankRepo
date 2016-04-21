package com.timebank.dao;

import java.util.List;

import com.timebank.model.Project;

public interface ProjectDao {

	 void addProject (Project project);
	 void updateProject (Project project);
	 List<Project> getProjects();
}
