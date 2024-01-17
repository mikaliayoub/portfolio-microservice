package com.skill.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.skill.entity.Skill;
import com.skill.repository.SkillRepository;

@ExtendWith(MockitoExtension.class)
class SkillServiceTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @Test
    void getAllSkills() {
        // Création de données de test
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(1, "Java", 80));
        skills.add(new Skill(2, "Python", 90));

        when(skillRepository.findAll()).thenReturn(skills);

        List<Skill> retrievedSkills = skillService.getAllSkills();

        assertEquals(2, retrievedSkills.size());
        assertEquals("Java", retrievedSkills.get(0).getName());
        assertEquals("Python", retrievedSkills.get(1).getName());
    }

    @Test
    void getSkillByIdEexistingSkill() {
        // Création de données de test
        Skill skill = new Skill(1, "Java", 80);

        when(skillRepository.findById(1)).thenReturn(skill);

        Skill retrievedSkill = skillService.getSkillById(1);

        assertNotNull(retrievedSkill);
        assertEquals("Java", retrievedSkill.getName());
        assertEquals(80, retrievedSkill.getLevel());
    }


    // Tests similaires pour les autres méthodes (getSkillByName, createSkill, updateSkill, deleteSkill)
}
