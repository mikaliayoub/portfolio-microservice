package com.skill.entity;

import org.junit.Assert;
import org.junit.Test;

public class SkillTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String name = "Java Programming";
        int level = 3;

        // Act
        Skill skill = new Skill(id, name, level);

        // Assert
        Assert.assertEquals(id, skill.getId());
        Assert.assertEquals(name, skill.getName());
        Assert.assertEquals(level, skill.getLevel());
    }

    @Test
    public void testSetters() {
        // Arrange
        Skill skill = new Skill();

        // Act
        int id = 2;
        String name = "Database Management";
        int level = 4;

        skill.setId(id);
        skill.setName(name);
        skill.setLevel(level);

        // Assert
        Assert.assertEquals(id, skill.getId());
        Assert.assertEquals(name, skill.getName());
        Assert.assertEquals(level, skill.getLevel());
    }
}
