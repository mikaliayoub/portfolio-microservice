package com.education.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class EducationTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String degree = "Bachelor";
        String institution = "University A";
        String graduationYear = "2022";

        // Act
        Education education = new Education(id, degree, institution, graduationYear);

        // Assert
        Assert.assertEquals(id, education.getId());
        Assert.assertEquals(degree, education.getDegree());
        Assert.assertEquals(institution, education.getInstitution());
        Assert.assertEquals(graduationYear, education.getGraduationYear());
    }

    @Test
    public void testSetters() {
        // Arrange
        Education education = new Education();

        // Act
        int id = 2;
        String degree = "Master";
        String institution = "University B";
        String graduationYear = "2023";

        education.setId(id);
        education.setDegree(degree);
        education.setInstitution(institution);
        education.setGraduationYear(graduationYear);

        // Assert
        Assert.assertEquals(id, education.getId());
        Assert.assertEquals(degree, education.getDegree());
        Assert.assertEquals(institution, education.getInstitution());
        Assert.assertEquals(graduationYear, education.getGraduationYear());
    }
}
