package com.trilogy.project.service;

import java.util.List;

import com.trilogy.project.model.Project;

public interface ProjectService {	
		Project findById(Long id);	
		Project saveProject(Project project);
		List<Project> findAllProject();
		Project deleteProjectById(Long id);
	
}
