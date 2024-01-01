package com.experience.entity;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ExperienceTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String title = "Software Engineer";
        String description = "Developing innovative software solutions";
        Date startDate = new Date();
        Date endDate = new Date();
        String company = "ABC Corp";
        String position = "Senior Developer";
        List<String> skills = Arrays.asList("Java", "Python", "SQL");

        // Act
        Experience experience = new Experience(id, title, description, startDate, endDate, company, position, skills);

        // Assert
        Assert.assertEquals(id, experience.getId());
        Assert.assertEquals(title, experience.getTitle());
        Assert.assertEquals(description, experience.getDescription());
        Assert.assertEquals(startDate, experience.getStartDate());
        Assert.assertEquals(endDate, experience.getEndDate());
        Assert.assertEquals(company, experience.getCompany());
        Assert.assertEquals(position, experience.getPosition());
        Assert.assertEquals(skills, experience.getSkills());
    }

    @Test
    public void testSetters() {
        // Arrange
        Experience experience = new Experience();

        // Act
        int id = 2;
        String title = "Data Analyst";
        String description = "Analyzing data for insights";
        Date startDate = new Date();
        Date endDate = new Date();
        String company = "XYZ Corp";
        String position = "Data Scientist";
        List<String> skills = Arrays.asList("Data Mining", "Statistics", "R");

        experience.setId(id);
        experience.setTitle(title);
        experience.setDescription(description);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setCompany(company);
        experience.setPosition(position);
        experience.setSkills(skills);

        // Assert
        Assert.assertEquals(id, experience.getId());
        Assert.assertEquals(title, experience.getTitle());
        Assert.assertEquals(description, experience.getDescription());
        Assert.assertEquals(startDate, experience.getStartDate());
        Assert.assertEquals(endDate, experience.getEndDate());
        Assert.assertEquals(company, experience.getCompany());
        Assert.assertEquals(position, experience.getPosition());
        Assert.assertEquals(skills, experience.getSkills());
    }
}

