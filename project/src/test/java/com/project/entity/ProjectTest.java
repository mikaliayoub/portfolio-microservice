package com.project.entity;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ProjectTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String title = "Project Title";
        String description = "Project Description";
        List<String> skills = Arrays.asList("Java", "Spring", "Hibernate");

        // Act
        Project project = new Project(id, title, description, skills);

        // Assert
        Assert.assertEquals(id, project.getId());
        Assert.assertEquals(title, project.getTitle());
        Assert.assertEquals(description, project.getDescription());
        Assert.assertEquals(skills, project.getSkills());
    }

    @Test
    public void testSetters() {
        // Arrange
        Project project = new Project();

        // Act
        int id = 2;
        String title = "Another Project";
        String description = "Another Description";
        List<String> skills = Arrays.asList("HTML", "CSS", "JavaScript");

        project.setId(id);
        project.setTitle(title);
        project.setDescription(description);
        project.setSkills(skills);

        // Assert
        Assert.assertEquals(id, project.getId());
        Assert.assertEquals(title, project.getTitle());
        Assert.assertEquals(description, project.getDescription());
        Assert.assertEquals(skills, project.getSkills());
    }
}
