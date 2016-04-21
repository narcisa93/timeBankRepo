package com.timebank.service;

import java.util.List;

import com.timebank.model.Project;

public interface ProjectService {
	 void addProject (Project project);
	 void updateProject (Project project);
	 List<Project> getProjects();
}
