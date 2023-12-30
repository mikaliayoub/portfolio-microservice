package com.skill.controller;

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

import com.skill.entity.Skill;
import com.skill.repository.SkillRepository;

@RestController
@RequestMapping("/skills")
public class SkillController {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@GetMapping
    public List<Skill> getAllSkills() {
        return  skillRepository.findAll();
    }
	
	@GetMapping("/{Id}")
	public Skill getProjectById(@PathVariable int Id) {
        return  skillRepository.findById(Id);
    }
	
	@GetMapping("/{skill}")
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
	
	
	@PutMapping("/{Id}")
	public Skill updateProject(@PathVariable int Id,@RequestBody Skill skill) {
		skill.setId(Id);
		return skillRepository.save(skill);
	}
	
	@DeleteMapping("/{Id}")
	public void deleteProject(@PathVariable int Id) {
		skillRepository.deleteById(Id);
	}
}
