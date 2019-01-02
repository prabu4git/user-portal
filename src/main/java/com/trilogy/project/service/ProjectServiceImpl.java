package com.trilogy.project.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilogy.project.model.Project;
import com.trilogy.project.model.Role;
import com.trilogy.project.model.User;
import com.trilogy.project.repository.ProjectRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
    private ProjectRepository projectRepository;
	@Override
	public Project findById(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Project saveProject(Project project) {		
		projectRepository.save(project);
		return project;
	}

	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project deleteProjectById(Long id) {
		Project project = findById(id);
		projectRepository.deleteById(id);
		return project;
	}

}
