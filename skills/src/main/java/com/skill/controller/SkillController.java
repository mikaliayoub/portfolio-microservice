package com.skill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skill.entity.Skill;
import com.skill.repository.SkillRepository;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:3000/")
public class SkillController {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@GetMapping
    public List<Skill> getAllSkills() {
        return  skillRepository.findAll();
    }
	
	@GetMapping("/{skillId}")
	public Skill getProjectById(@PathVariable int skillId) {
        return  skillRepository.findById(skillId);
    }
	
	@GetMapping("/skillname/{skill}")
	public Skill getSkillByName(@PathVariable String skill) {
        return  skillRepository.findByName(skill);
    }
	
	@PostMapping
	public Skill createSkill(@RequestBody Skill skill) {
		
		if (skill.getLevel()<0 || skill.getLevel()>100){
			return null;
		}
		else {
			return skillRepository.save(skill);
		}
		
	}
	
	
	@PutMapping("/{skillId}")
	public Skill updateProject(@PathVariable int skillId,@RequestBody Skill skill) {
		skill.setId(skillId);
		return skillRepository.save(skill);
	}
	
	@DeleteMapping("/{skillId}")
	public void deleteProject(@PathVariable int skillId) {
		skillRepository.deleteById(skillId);
	}
}
