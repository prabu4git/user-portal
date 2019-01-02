package com.trilogy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trilogy.project.model.Project;
import com.trilogy.project.service.ProjectService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/projects")
public class ProjectController {

	
	
public static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
    @Autowired
    private ProjectService projectService;
    
    
    @PostMapping
    public Project create(@RequestBody Project project){   
    	System.out.println("===>"+project.getProjectDesc());
        return projectService.saveProject(project);
    }

    @GetMapping(path = {"/{id}"})
    public Project findOne(@PathVariable("id") long id){
        return projectService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Project update(@PathVariable("id") long id, @RequestBody Project project){    
    	project.setId(id);
        return projectService.saveProject(project);
    }

    @DeleteMapping(path ={"/{id}"})
    public Project delete(@PathVariable("id") long id) {
    	return projectService.deleteProjectById(id);
    }
    
    @GetMapping
    public List<Project> findAll(){
        return projectService.findAllProject();
    }
}
