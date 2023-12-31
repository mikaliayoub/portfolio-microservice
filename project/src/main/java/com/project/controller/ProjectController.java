package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.Project;
import com.project.repository.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping
    public List<Project> getAllProject() {
        return  projectRepository.findAll();
    }
	
	@GetMapping("/{projectId}")
	public Project getProjectById(@PathVariable int projectId) {
        return  projectRepository.findById(projectId);
    }
	
	@GetMapping("/{projectId}/skills")
	public List<String> getProjectSkillById(@PathVariable int projectId) {
        return  projectRepository.findById(projectId).getSkills();
    }
	
	@PostMapping
	public Project createProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	
	@PutMapping("/{projectId}")
	public Project updateProject(@PathVariable int projectId,@RequestBody Project project) {
		project.setId(projectId);
		return projectRepository.save(project);
	}
	
	@DeleteMapping("/{projectId}")
	public void deleteProject(@PathVariable int projectId) {
		projectRepository.deleteById(projectId);
	}
}
