package com.trilogy.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trilogy.project.model.Project;



@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long>{


}
