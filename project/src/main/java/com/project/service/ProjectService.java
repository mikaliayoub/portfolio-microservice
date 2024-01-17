package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Project;
import com.project.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(int projectId) {
        Project optionalProject = projectRepository.findById(projectId);
        return optionalProject;
    }

    public List<String> getProjectSkillsById(int projectId) {
        Project optionalProject = projectRepository.findById(projectId);
        return optionalProject.getSkills();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int projectId, Project project) {
        Project existingProjectOptional = projectRepository.findById(projectId);
        if (existingProjectOptional!=null) {
            Project existingProject = projectRepository.findById(projectId);
            existingProject.setTitle(project.getTitle());
            existingProject.setSkills(project.getSkills());
            // Mettez à jour d'autres champs si nécessaire
            return projectRepository.save(existingProject);
        } else {
            // Gérer l'absence de projet avec cet ID
            return null;
        }
    }

    public void deleteProject(int projectId) {
        projectRepository.deleteById(projectId);
    }
}
