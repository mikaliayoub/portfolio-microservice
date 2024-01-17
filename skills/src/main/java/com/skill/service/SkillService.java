package com.skill.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.entity.Skill;
import com.skill.repository.SkillRepository;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(int skillId) {
        return skillRepository.findById(skillId);
    }

    public Skill getSkillByName(String skillName) {
        return skillRepository.findByName(skillName);
    }

    public Skill createSkill(Skill skill) {
        if (skill.getLevel() < 0 || skill.getLevel() > 100) {
            throw new IllegalArgumentException("Niveau de compétence invalide");
        }
        return skillRepository.save(skill);
    }

    public Skill updateSkill(int skillId, Skill skill) {
        Skill existingSkill = skillRepository.findById(skillId);
        if (existingSkill != null) {
            existingSkill.setName(skill.getName());
            existingSkill.setLevel(skill.getLevel());
            // Mettre à jour d'autres champs si nécessaire
            return skillRepository.save(existingSkill);
        } else {
            throw new IllegalArgumentException("Compétence introuvable avec l'ID: " + skillId);
        }
    }

    public void deleteSkill(int skillId) {
        skillRepository.deleteById(skillId);
    }
}