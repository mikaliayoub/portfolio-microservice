package com.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	List<Project> findAll();
	Project findById(int id);
}
