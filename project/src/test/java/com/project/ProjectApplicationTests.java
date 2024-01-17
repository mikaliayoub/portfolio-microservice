package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.entity.Project;
import com.project.repository.ProjectRepository;
import com.project.service.ProjectService;

@SpringBootTest
class ProjectApplicationTests {

	@MockBean
    private ProjectRepository projectRepository;

	@Autowired
    private ProjectService projectService;

    @Test
    void getAllProjects() {
        List<Project> projects = new ArrayList<>();
        // Ajouter des projets à la liste projects

        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> retrievedProjects = projectService.getAllProjects();
        assertEquals(projects.size(), retrievedProjects.size());
        // Ajouter d'autres assertions pour comparer les données
    }



}
